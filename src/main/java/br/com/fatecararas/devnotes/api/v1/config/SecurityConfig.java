package br.com.fatecararas.devnotes.api.v1.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity


@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()  // Allow access to public endpoints
                .anyRequest().authenticated()          // Require authentication for other endpoints
                .and()
                .formLogin()  // Enable form-based login
                .permitAll();
    }
}
