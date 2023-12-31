package com.api.trainning.application.usecases;

import com.api.trainning.application.gateway.CriarAlunoGateway;
import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.aluno.AlunoData;
import com.api.trainning.core.domain.usecases.CriarAluno;

public class CriarAlunoImpl implements CriarAluno {

  private final CriarAlunoGateway criarAlunoGateway;

  public CriarAlunoImpl(CriarAlunoGateway criarAlunoGateway) {
    this.criarAlunoGateway = criarAlunoGateway;
  }

  @Override
  public Aluno exec(UsuarioData usuario, AlunoData info) throws Exception {
    Aluno aluno = this.criarAlunoGateway.criar(usuario, info);

    if (aluno == null)
      throw new Exception("Nao foi possivel criar o usuario");

    return aluno;
  }

}
