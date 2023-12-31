package com.api.trainning.application.gateway;

import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.aluno.AlunoData;

public interface CriarAlunoGateway {
  Aluno criar(UsuarioData usuario, AlunoData info);
}
