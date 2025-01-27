package io.quantics.multitenant.oauth2.config;

import org.junit.jupiter.api.Order;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@TestConfiguration
class MultiTenantHeaderTestConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Usage of securityMatcher to replace the multiTenantHeaderFilterChain bean
        //See https://github.com/spring-projects/spring-security/issues/15220
        http.securityMatcher("/**");
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers("/").permitAll()
        );

        return http.build();
    }

}
