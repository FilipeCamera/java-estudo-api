package com.api.treino.infrastructure.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.api.treino.application.gateway.IUsuarioAutenticacaoGateway;
import com.api.treino.application.usecases.UsuarioAutenticacaoImpl;
import com.api.treino.core.domain.usecases.UsuarioAutenticacao;
import com.api.treino.infrastructure.services.UsuarioAutenticacaoGatewayImpl;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Value("${api_treino.jwt.public.key}")
  private RSAPublicKey chavePublica;

  @Value("${api_treino.jwt.private.key}")
  private RSAPrivateKey chavePrivada;

  @Bean
  IUsuarioAutenticacaoGateway usuarioAutenticacaoGateway() {
    return new UsuarioAutenticacaoGatewayImpl();
  }

  @Bean
  UsuarioAutenticacao usuarioAutenticacao(IUsuarioAutenticacaoGateway usuarioAutenticacaoGateway) {
    return new UsuarioAutenticacaoImpl(usuarioAutenticacaoGateway);
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(request -> request.requestMatchers("/api/v1/auth/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/v1/personals").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/v1/alunos").permitAll().anyRequest()
            .authenticated())
        .httpBasic(Customizer.withDefaults())
        .oauth2ResourceServer(config -> config.jwt(Customizer.withDefaults()));

    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
