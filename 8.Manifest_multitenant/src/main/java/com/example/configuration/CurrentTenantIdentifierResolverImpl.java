package com.example.configuration;

import com.sap.cloud.security.xsuaa.token.AuthenticationToken;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver<String>, HibernatePropertiesCustomizer {

    public static final String DEFAULT_TENANT_SCHEMA = "public";

    private static final String SAP_PROVISIONING_TENANT_ID = "sap-provisioning";

    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.remove();
    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        return Optional.ofNullable(currentTenant.get())
                .filter(StringUtils::isNotBlank)
                .orElseGet(this::getTenantIdFromSession);
    }

    private String getTenantIdFromSession() {
        AuthenticationToken authToken = (AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        if (Objects.isNull(authToken)) {
            return DEFAULT_TENANT_SCHEMA;
        }

        var attributes = authToken.getTokenAttributes();

        String tenantId = (String) attributes.get("zid");
        String resolvedTenantId = resolveTenantId(tenantId);

        return resolvedTenantId;
    }

    private String resolveTenantId(String tenantId) {

        return Objects.nonNull(tenantId) && !SAP_PROVISIONING_TENANT_ID.equals(tenantId)
                ? tenantId
                : DEFAULT_TENANT_SCHEMA;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }

}
