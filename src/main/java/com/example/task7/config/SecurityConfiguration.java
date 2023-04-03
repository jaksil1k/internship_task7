package com.example.task7.config;

import com.example.task7.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**")
                .permitAll()
                .requestMatchers("/api/v1/meters/**")
                .hasAnyRole(Role.ADMIN.name(), Role.OPERATOR.name())
                .requestMatchers("/admin/**")
                .hasRole(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
//                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/hello", true)
//                .loginProcessingUrl("/perform_login")
//                .failureUrl("/login?error=true")
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessHandler(logoutSuccessHandler())
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30))
//                    .key("somethingverysecured")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
