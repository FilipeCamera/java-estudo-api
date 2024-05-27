package com.api.treino.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.treino.application.gateway.IBuscarAlunoGateway;
import com.api.treino.application.gateway.ICriarAlunoGateway;
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
  ICriarAlunoGateway criarAlunoGateway(AlunoRepository alunoRepository) {
    return new CriarAlunoGatewayImpl(alunoRepository);
  }

  @Bean
  CriarAluno criarAluno(ICriarAlunoGateway criarAlunoGateway) {
    return new CriarAlunoImpl(criarAlunoGateway);
  }

  @Bean
  IBuscarAlunoGateway buscarAlunoGateway(AlunoRepository alunoRepository) {
    return new BuscarAlunoGatewayImpl(alunoRepository);
  }

  @Bean
  BuscarAluno buscarAluno(IBuscarAlunoGateway buscarAlunoGateway) {
    return new BuscarAlunoImpl(buscarAlunoGateway);
  }
}
