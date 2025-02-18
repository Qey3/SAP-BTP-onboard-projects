package com.example.java_tutorial.controller;

import com.example.java_tutorial.service.TenantDBSchemaService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/callback/v1/tenants/{tenantId}")
public class TenantController {

    private static final String APP_ROUTER_DOMAIN_NAME = "-web-multitenant.cfapps.us10-001.hana.ondemand.com";
    private static final String HTTPS = "https://";
    private static final String SUBSCRIBED_SUBDOMAIN_JSON_FIELD = "subscribedSubdomain";

    private final TenantDBSchemaService tenantDBSchemaService;

    @PutMapping()
    public ResponseEntity<String> callback(@RequestBody JsonNode requestBody, @PathVariable("tenantId") String tenantId) {
        log.info("Tenant callback service was called with method PUT for tenant {}.", tenantId);
        String subdomain = requestBody.get(SUBSCRIBED_SUBDOMAIN_JSON_FIELD).asText();

        tenantDBSchemaService.subscribeTenant(tenantId);
        String link = HTTPS + subdomain + APP_ROUTER_DOMAIN_NAME;

        return ResponseEntity.ok(link);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteCallback(@PathVariable("tenantId") String tenantId) {
        log.info("Tenant callback service was called with method DELETE for tenant {}.", tenantId);
        tenantDBSchemaService.unsubscribeTenant(tenantId);

        return ResponseEntity.ok().build();
    }

}
