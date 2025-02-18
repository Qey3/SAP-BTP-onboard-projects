package com.example.java_tutorial;

import com.example.java_tutorial.configuration.CurrentTenantIdentifierResolverImpl;
import com.example.java_tutorial.entity.Employee;
import com.example.java_tutorial.repository.EmployeeRepository;
import com.example.java_tutorial.service.TenantDBSchemaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest(classes = MultiTenantApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MultiTenantApplicationTests {

    public static final String PIVOTAL = "PIVOTAL";
    public static final String VMWARE = "VMWARE";

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TransactionTemplate txTemplate;

    @Autowired
    CurrentTenantIdentifierResolverImpl currentTenant;

    @Autowired
    TenantDBSchemaService tenantDBSchemaService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeAll
    void setup() {
        // Create schemas for tenants in H2
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS PIVOTAL");
        jdbcTemplate.execute("CREATE TABLE PIVOTAL.EMPLOYEE (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), department VARCHAR(255), salary VARCHAR(255))");
        //jdbcTemplate.execute("INSERT INTO tenant1.products (name) VALUES ('Product A')");

        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS VMWARE");
        jdbcTemplate.execute("CREATE TABLE VMWARE.EMPLOYEE (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), department VARCHAR(255), salary VARCHAR(255))");
        //jdbcTemplate.execute("INSERT INTO public.products (name) VALUES ('Default Product')");
    }

    @AfterEach


    @Test
    void contextLoads() {
    }

    @Test
    void saveAndLoadPerson() {
        tenantDBSchemaService.subscribeTenant(PIVOTAL);
        tenantDBSchemaService.subscribeTenant(VMWARE);
        createEmployee(PIVOTAL, "Adam");
        createEmployee(VMWARE, "Eve");

        currentTenant.setTenant(VMWARE);
        Assertions.assertThat(employeeRepository.findAll()).extracting(Employee::getName).containsExactly("Eve");

        currentTenant.setTenant(PIVOTAL);
        Assertions.assertThat(employeeRepository.findAll()).extracting(Employee::getName).containsExactly("Adam");
    }

    private Employee createEmployee(String schema, String name) {

        currentTenant.setTenant(schema);

        Employee employee1 = txTemplate.execute(tx ->
                {
                    Employee employee = new Employee();
                    employee.setName(name);
                    return employeeRepository.save(employee);
                }
        );

        Assertions.assertThat(employee1.getId()).isNotNull();
        return employee1;
    }

}
