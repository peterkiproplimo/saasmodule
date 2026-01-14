package com.example.saasapis.services;


import com.example.saasapis.models.Tenant;
import com.example.saasapis.models.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate; // Connected to central registry DB

    /**
     * Provision all unprovisioned tenants
     */
    public void provisionTenants() {
        List<Tenant> tenants = tenantRepository.findByProvisionedFalse();
        for (Tenant tenant : tenants) {
            try {
                createTenantDatabase(tenant);
                tenant.setProvisioned(true);
                tenantRepository.save(tenant);
                System.out.println("Provisioned tenant: " + tenant.getClientName());
            } catch (Exception e) {
                System.err.println("Error provisioning tenant " + tenant.getClientName() + ": " + e.getMessage());
            }
        }
    }

    /**
     * Create the tenant database dynamically
     */
    private void createTenantDatabase(Tenant tenant) {
        // Adjust SQL for your DBMS
        String sql = "CREATE DATABASE " + tenant.getDbName();
        jdbcTemplate.execute(sql);

        // Optional: run initial setup scripts for tables, etc.
        // For example:
        // runTenantInitScript(tenant.getDbName());
    }

    // Optional method to run SQL script on tenant DB
    // private void runTenantInitScript(String dbName) { ... }
}
