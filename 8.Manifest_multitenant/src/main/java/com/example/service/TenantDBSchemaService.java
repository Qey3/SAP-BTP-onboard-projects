package com.example.service;


public interface TenantDBSchemaService {

    void subscribeTenant(String tenantId);

    void unsubscribeTenant(String tenantId);
}
