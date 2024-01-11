package com.api.treino.application.usecases;

import com.api.treino.application.gateway.CriarAlunoGateway;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import com.api.treino.core.domain.usecases.CriarAluno;

public class CriarAlunoImpl implements CriarAluno {

  private final CriarAlunoGateway criarAlunoGateway;

  public CriarAlunoImpl(CriarAlunoGateway criarAlunoGateway) {
    this.criarAlunoGateway = criarAlunoGateway;
  }

  @Override
  public Aluno exec(UsuarioData usuario, AlunoData info) throws Exception {
    Aluno aluno = this.criarAlunoGateway.criar(usuario, info);

    if (aluno == null || aluno.usuario() == null)
      throw new Exception("Nao foi possivel criar o usuario");

    return aluno;
  }
}
