package com.api.treino.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.treino.application.gateway.IBuscarAlunoGateway;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.infrastructure.entities.AlunoEntity;
import com.api.treino.infrastructure.mappers.AlunoMapper;
import com.api.treino.infrastructure.repositories.AlunoRepository;

public class BuscarAlunoGatewayImpl implements IBuscarAlunoGateway {

  private AlunoRepository alunoRepository;

  public BuscarAlunoGatewayImpl(AlunoRepository alunoRepository) {
    this.alunoRepository = alunoRepository;
  }

  @Override
  public List<Aluno> buscar() {
    List<AlunoEntity> alunosEntities = this.alunoRepository.findAll();

    List<Aluno> alunos =
        alunosEntities.stream().map((alunoEntity) -> AlunoMapper.toAluno(alunoEntity)).toList();
    return alunos;
  }

  @Override
  public Aluno buscar(UUID id) {
    Optional<AlunoEntity> alunoEntity = this.alunoRepository.findById(id);

    return AlunoMapper.toAluno(alunoEntity.get());
  }

}
