package com.api.treino.infrastructure.services;

import com.api.treino.application.gateway.CriarAlunoGateway;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import com.api.treino.infrastructure.entities.AlunoEntity;
import com.api.treino.infrastructure.mappers.AlunoMapper;
import com.api.treino.infrastructure.repositories.AlunoRepository;

public class CriarAlunoGatewayImpl implements CriarAlunoGateway {
  private AlunoRepository alunoRepository;
  private AlunoMapper alunoMapper;

  public CriarAlunoGatewayImpl(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
    this.alunoRepository = alunoRepository;
    this.alunoMapper = alunoMapper;
  }

  @Override
  public Aluno criar(UsuarioData usuario, AlunoData info) {

    AlunoEntity alunoEntity = this.alunoMapper.toAlunoEntity(usuario, info);

    Aluno aluno = this.alunoMapper.toAluno(this.alunoRepository.save(alunoEntity));

    return aluno;
  }

}
