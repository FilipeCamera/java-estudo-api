package com.api.treino.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.treino.application.gateway.BuscarAlunoGateway;
import com.api.treino.application.gateway.CriarAlunoGateway;
import com.api.treino.application.usecases.BuscarAlunoImpl;
import com.api.treino.application.usecases.CriarAlunoImpl;
import com.api.treino.core.domain.usecases.BuscarAluno;
import com.api.treino.core.domain.usecases.CriarAluno;
import com.api.treino.infrastructure.repositories.AlunoRepository;
import com.api.treino.infrastructure.services.BuscarAlunoGatewayImpl;
import com.api.treino.infrastructure.services.CriarAlunoGatewayImpl;

@Configuration
public class AlunoConfig {

  @Bean
  CriarAlunoGateway criarAlunoGateway(AlunoRepository alunoRepository) {
    return new CriarAlunoGatewayImpl(alunoRepository);
  }

  @Bean
  CriarAluno criarAluno(CriarAlunoGateway criarAlunoGateway) {
    return new CriarAlunoImpl(criarAlunoGateway);
  }

  @Bean
  BuscarAlunoGateway buscarAlunoGateway(AlunoRepository alunoRepository) {
    return new BuscarAlunoGatewayImpl(alunoRepository);
  }

  @Bean
  BuscarAluno buscarAluno(BuscarAlunoGateway buscarAlunoGateway) {
    return new BuscarAlunoImpl(buscarAlunoGateway);
  }
}
