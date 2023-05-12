package com.enamduateknologi.teknikaltest;

import com.enamduateknologi.teknikaltest.config.ApiKeysConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiKeysConfig.class)
public class TeknikalTestEnamDuaTeknologiFandiSudrajatApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeknikalTestEnamDuaTeknologiFandiSudrajatApplication.class, args);
    }

}
