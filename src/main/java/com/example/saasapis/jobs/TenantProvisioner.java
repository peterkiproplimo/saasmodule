package com.example.saasapis.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TenantProvisioner {

    @Scheduled(cron = "0 0 * * * *") // Every hour
    public void provisionTenants() {
        // Check tenant queue and create databases
    }
}
