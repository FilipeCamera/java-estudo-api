package com.api.treino.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.treino.application.gateway.AlterarExercicioGateway;
import com.api.treino.application.gateway.BuscarExercicioGateway;
import com.api.treino.application.gateway.BuscarPersonalGateway;
import com.api.treino.application.gateway.CriarExercicioGateway;
import com.api.treino.application.gateway.CriarPersonalGateway;
import com.api.treino.application.usecases.AlterarExercicioImpl;
import com.api.treino.application.usecases.BuscarExercicioImpl;
import com.api.treino.application.usecases.BuscarPersonalImpl;
import com.api.treino.application.usecases.CriarExercicioImpl;
import com.api.treino.application.usecases.CriarPersonalImpl;
import com.api.treino.core.domain.usecases.AlterarExercicio;
import com.api.treino.core.domain.usecases.BuscarExercicio;
import com.api.treino.core.domain.usecases.BuscarPersonal;
import com.api.treino.core.domain.usecases.CriarExercicio;
import com.api.treino.core.domain.usecases.CriarPersonal;
import com.api.treino.infrastructure.repositories.ExercicioRepository;
import com.api.treino.infrastructure.repositories.PersonalRepository;
import com.api.treino.infrastructure.services.AlterarExercicioGatewayImpl;
import com.api.treino.infrastructure.services.BuscarExercicioGatewayImpl;
import com.api.treino.infrastructure.services.BuscarPersonalGatewayImpl;
import com.api.treino.infrastructure.services.CriarExercicioGatewayImpl;
import com.api.treino.infrastructure.services.CriarPersonalGatewayImpl;

@Configuration
public class PersonalConfig {

  @Bean
  CriarPersonalGateway criarPersonalGateway(PersonalRepository personalRepository) {
    return new CriarPersonalGatewayImpl(personalRepository);
  }

  @Bean
  CriarPersonal criarPersonal(CriarPersonalGateway criarPersonalGateway) {
    return new CriarPersonalImpl(criarPersonalGateway);
  }

  @Bean
  BuscarPersonalGateway buscarPersonalGateway(PersonalRepository personalRepository) {
    return new BuscarPersonalGatewayImpl(personalRepository);
  }

  @Bean
  BuscarPersonal buscarPersonal(BuscarPersonalGateway buscarPersonalGateway) {
    return new BuscarPersonalImpl(buscarPersonalGateway);
  }

  @Bean
  CriarExercicioGateway criarExercicioGateway(ExercicioRepository exercicioRepository) {
    return new CriarExercicioGatewayImpl(exercicioRepository);
  }

  @Bean
  CriarExercicio criarExercicio(CriarExercicioGateway criarExercicioGateway) {
    return new CriarExercicioImpl(criarExercicioGateway);
  }

  @Bean
  BuscarExercicioGateway buscarExercicioGateway(ExercicioRepository exercicioRepository) {
    return new BuscarExercicioGatewayImpl(exercicioRepository);
  }

  @Bean
  BuscarExercicio buscarExercicio(BuscarExercicioGateway buscarExercicioGateway) {
    return new BuscarExercicioImpl(buscarExercicioGateway);
  }

  @Bean
  AlterarExercicioGateway alterarExercicioGateway(ExercicioRepository exercicioRepository) {
    return new AlterarExercicioGatewayImpl(exercicioRepository);
  }

  @Bean
  AlterarExercicio alterarExercicio(AlterarExercicioGateway alterarExercicioGateway) {
    return new AlterarExercicioImpl(alterarExercicioGateway);
  }
}
