package com.api.treino.infrastructure.services;

import com.api.treino.application.gateway.ICriarAlunoGateway;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import com.api.treino.infrastructure.entities.AlunoEntity;
import com.api.treino.infrastructure.mappers.AlunoMapper;
import com.api.treino.infrastructure.repositories.AlunoRepository;

public class CriarAlunoGatewayImpl implements ICriarAlunoGateway {
  private AlunoRepository alunoRepository;

  public CriarAlunoGatewayImpl(AlunoRepository alunoRepository) {
    this.alunoRepository = alunoRepository;
  }

  @Override
  public Aluno criar(UsuarioData usuario, AlunoData info) {

    AlunoEntity alunoEntity = AlunoMapper.toAlunoEntity(usuario, info);

    Aluno aluno = AlunoMapper.toAluno(this.alunoRepository.save(alunoEntity));

    return aluno;
  }

}
