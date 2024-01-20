package com.api.treino.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.treino.application.gateway.CriarPersonalGateway;
import com.api.treino.application.usecases.CriarPersonalImpl;
import com.api.treino.core.domain.usecases.CriarPersonal;
import com.api.treino.infrastructure.mappers.PersonalMapper;
import com.api.treino.infrastructure.repositories.PersonalRepository;
import com.api.treino.infrastructure.services.CriarPersonalGatewayImpl;

@Configuration
public class PersonalConfig {

  @Bean
  CriarPersonalGateway criarPersonalGateway(PersonalRepository personalRepository,
      PersonalMapper personalMapper) {
    return new CriarPersonalGatewayImpl(personalRepository, personalMapper);
  }

  @Bean
  CriarPersonal criarPersonal(CriarPersonalGateway criarPersonalGateway) {
    return new CriarPersonalImpl(criarPersonalGateway);
  }
}
