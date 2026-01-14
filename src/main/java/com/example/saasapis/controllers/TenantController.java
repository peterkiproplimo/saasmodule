package com.example.saasapis.controllers;

import com.example.saasapis.services.TenantService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/provision")
    public String provisionTenants() {
        tenantService.provisionTenants();
        return "Tenant provisioning started";
    }
}
