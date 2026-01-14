package com.example.saasapis.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue
    private UUID tenantId;

    @Column(nullable = false, unique = true)
    private String clientName;

    @Column(nullable = false, unique = true)
    private String subdomain;

    @Column(nullable = false)
    private String dbName;

    @Column(nullable = false)
    private String adminEmail;

    @Column(nullable = false)
    private String adminUsername;

    @Column(nullable = false)
    private String adminPassword;

    @Column(nullable = false)
    private boolean provisioned = false;

    // Getters & Setters
    public UUID getTenantId() { return tenantId; }
    public void setTenantId(UUID tenantId) { this.tenantId = tenantId; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public String getSubdomain() { return subdomain; }
    public void setSubdomain(String subdomain) { this.subdomain = subdomain; }
    public String getDbName() { return dbName; }
    public void setDbName(String dbName) { this.dbName = dbName; }
    public String getAdminEmail() { return adminEmail; }
    public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }
    public String getAdminUsername() { return adminUsername; }
    public void setAdminUsername(String adminUsername) { this.adminUsername = adminUsername; }
    public String getAdminPassword() { return adminPassword; }
    public void setAdminPassword(String adminPassword) { this.adminPassword = adminPassword; }
    public boolean isProvisioned() { return provisioned; }
    public void setProvisioned(boolean provisioned) { this.provisioned = provisioned; }
}
