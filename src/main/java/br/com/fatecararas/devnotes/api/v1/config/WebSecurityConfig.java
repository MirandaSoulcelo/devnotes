package br.com.fatecararas.devnotes.api.v1.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity


public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Recursos que não precisarão de autenticação
    final String[] PUBLIC_MATCHERS = { "/h2-console/**", "/api/v1/categorias" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()  // Liberar recursos listados
                .anyRequest().authenticated()            // Requer autenticação para outros recursos
                .and()
                .httpBasic()                              // Utilizar autenticação básica
                .and()
                .csrf()
                .disable()                               // Desabilitar CSRF
                .and()
                .headers()
                .frameOptions().disable();               // Habilitar o uso de frames para H2
    }
}
