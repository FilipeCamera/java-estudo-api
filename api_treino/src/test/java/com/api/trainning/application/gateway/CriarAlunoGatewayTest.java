package com.api.trainning.application.gateway;

import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.aluno.AlunoData;

public class CriarAlunoGatewayTest implements CriarAlunoGateway {

  @Override
  public Aluno criar(UsuarioData usuario, AlunoData info) {
    Aluno aluno = new Aluno(usuario, info);

    return aluno;
  }

}
