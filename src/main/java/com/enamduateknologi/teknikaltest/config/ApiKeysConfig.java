package com.enamduateknologi.teknikaltest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "api")
public class ApiKeysConfig {

    private List<ApiKey> keys;

    public List<ApiKey> getKeys() {
        return keys;
    }

    public void setKeys(List<ApiKey> keys) {
        this.keys = keys;
    }

    public static class ApiKey {
        private String key;
        private String role;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
