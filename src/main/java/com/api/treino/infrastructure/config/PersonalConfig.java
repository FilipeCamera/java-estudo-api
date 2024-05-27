package com.api.treino.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.treino.application.gateway.IAlterarExercicioGateway;
import com.api.treino.application.gateway.IBuscarExercicioGateway;
import com.api.treino.application.gateway.IBuscarPersonalGateway;
import com.api.treino.application.gateway.ICriarExercicioGateway;
import com.api.treino.application.gateway.ICriarPersonalGateway;
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
  ICriarPersonalGateway criarPersonalGateway(PersonalRepository personalRepository) {
    return new CriarPersonalGatewayImpl(personalRepository);
  }

  @Bean
  CriarPersonal criarPersonal(ICriarPersonalGateway criarPersonalGateway) {
    return new CriarPersonalImpl(criarPersonalGateway);
  }

  @Bean
  IBuscarPersonalGateway buscarPersonalGateway(PersonalRepository personalRepository) {
    return new BuscarPersonalGatewayImpl(personalRepository);
  }

  @Bean
  BuscarPersonal buscarPersonal(IBuscarPersonalGateway buscarPersonalGateway) {
    return new BuscarPersonalImpl(buscarPersonalGateway);
  }

  @Bean
  ICriarExercicioGateway criarExercicioGateway(ExercicioRepository exercicioRepository) {
    return new CriarExercicioGatewayImpl(exercicioRepository);
  }

  @Bean
  CriarExercicio criarExercicio(ICriarExercicioGateway criarExercicioGateway) {
    return new CriarExercicioImpl(criarExercicioGateway);
  }

  @Bean
  IBuscarExercicioGateway buscarExercicioGateway(ExercicioRepository exercicioRepository) {
    return new BuscarExercicioGatewayImpl(exercicioRepository);
  }

  @Bean
  BuscarExercicio buscarExercicio(IBuscarExercicioGateway buscarExercicioGateway) {
    return new BuscarExercicioImpl(buscarExercicioGateway);
  }

  @Bean
  IAlterarExercicioGateway alterarExercicioGateway(ExercicioRepository exercicioRepository) {
    return new AlterarExercicioGatewayImpl(exercicioRepository);
  }

  @Bean
  AlterarExercicio alterarExercicio(IAlterarExercicioGateway alterarExercicioGateway) {
    return new AlterarExercicioImpl(alterarExercicioGateway);
  }
}
