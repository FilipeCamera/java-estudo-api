package com.api.treino.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.treino.application.gateway.CriarAlunoGateway;
import com.api.treino.application.usecases.CriarAlunoImpl;
import com.api.treino.core.domain.usecases.CriarAluno;
import com.api.treino.infrastructure.mappers.AlunoMapper;
import com.api.treino.infrastructure.repositories.AlunoRepository;
import com.api.treino.infrastructure.services.CriarAlunoGatewayImpl;

@Configuration
public class AlunoConfig {

  @Bean
  CriarAlunoGateway criarAlunoGateway(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
    return new CriarAlunoGatewayImpl(alunoRepository, alunoMapper);
  }

  @Bean
  CriarAluno criarAluno(CriarAlunoGateway criarAlunoGateway) {
    return new CriarAlunoImpl(criarAlunoGateway);
  }
}
