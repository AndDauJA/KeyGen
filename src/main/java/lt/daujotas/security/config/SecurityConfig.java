package lt.daujotas.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/",
                                "/client/**",
                                "/cart/**",
                                "/user/**",
                                "/clientaccountform/**"

                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
//                .formLogin(Customizer.withDefaults())
                .formLogin(loginConfig -> loginConfig
                        .permitAll()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/clientaccountform", true)
                        .usernameParameter("username")
                        .passwordParameter("password")
                )
//                .logout(LogoutConfigurer::permitAll)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(

                        PathRequest.toStaticResources().atCommonLocations()
                );
    }
}


