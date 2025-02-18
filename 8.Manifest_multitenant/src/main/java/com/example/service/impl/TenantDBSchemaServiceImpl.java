package com.example.service.impl;

import com.example.service.TenantDBSchemaService;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.util.TenantSchemaNameBuilder.buildSchemaName;
import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class TenantDBSchemaServiceImpl implements TenantDBSchemaService {

    private static final String LIQUIBASE_MASTER_PATH = "liquibase/hana.changelog-master.yml";

    private final DataSource dataSource;

    @Override
    public void subscribeTenant(String tenantId) {
        String schemaName = buildSchemaName(tenantId);

        try (Connection connection = dataSource.getConnection()) {

            createSchema(tenantId, schemaName, connection);
            setupSchema(tenantId, schemaName, connection);

        } catch (SQLException | LiquibaseException e) {

            String message = format("Failed to initialize schema while subscribing tenant: [%s].", tenantId);
            throw new RuntimeException(message, e);

        }
    }

    private void createSchema(String tenantId, String schemaName, Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(format("CREATE SCHEMA IF NOT EXISTS \"%s\"", schemaName));
        }

        log.info("SCHEMA with name: {} was created", tenantId);
    }

    private void setupSchema(String tenantId, String schemaName, Connection connection) throws SQLException, LiquibaseException {
        log.debug("Setting up schema [{}] for tenant [{}].", schemaName, tenantId);

        connection.setSchema(schemaName);
        Database database = getDatabaseInstance(connection);
        Liquibase liquibase = new Liquibase(LIQUIBASE_MASTER_PATH, new ClassLoaderResourceAccessor(), database);
        liquibase.update(new Contexts(), new LabelExpression());

        log.info("Successfully set up schema [{}] for tenant [{}].", schemaName, tenantId);
    }

    @SneakyThrows
    private Database getDatabaseInstance(Connection connection) {
        return DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
    }


    @Override
    public void unsubscribeTenant(String tenantId) {
        String schemaName = buildSchemaName(tenantId);

        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(String.format("DROP SCHEMA IF EXISTS \"%s\" CASCADE", schemaName));

        } catch (SQLException e) {

            String message = format("Failed to initialize schema while subscribing tenant: [%s].", tenantId);
            throw new RuntimeException(message, e);

        }

        log.info("SCHEMA with name: {} was deleted successfully", tenantId);
    }
}
