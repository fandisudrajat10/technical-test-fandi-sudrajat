package com.enamduateknologi.teknikaltest.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class ApiKeyValidationFilter extends OncePerRequestFilter {

    private final ApiKeysConfig apiKeysConfig;

    public ApiKeyValidationFilter(ApiKeysConfig apiKeysConfig) {
        this.apiKeysConfig = apiKeysConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKeyValue = request.getHeader("Api-Key");

        if (isValidApiKey(apiKeyValue)) {
            String role = getRoleByApiKey(apiKeyValue);
            if (role != null) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(apiKeyValue, null, Collections.singletonList(new SimpleGrantedAuthority(role)));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private boolean isValidApiKey(String apiKeyValue) {
        return apiKeysConfig.getKeys().stream().anyMatch(apiKey -> apiKey.getKey().equals(apiKeyValue));
    }

    private String getRoleByApiKey(String apiKeyValue) {
        Optional<ApiKeysConfig.ApiKey> apiKeyOptional = apiKeysConfig.getKeys().stream().filter(apiKey -> apiKey.getKey().equals(apiKeyValue)).findFirst();
        return apiKeyOptional.map(ApiKeysConfig.ApiKey::getRole).orElse(null);
    }
}
