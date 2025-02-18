package com.example.java_tutorial.service;


public interface TenantDBSchemaService {

    void subscribeTenant(String tenantId);

    void unsubscribeTenant(String tenantId);
}
