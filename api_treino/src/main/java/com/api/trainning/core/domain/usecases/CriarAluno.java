package com.api.trainning.core.domain.usecases;

import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.Aluno.Aluno;
import com.api.trainning.core.domain.Aluno.AlunoData;

public interface CriarAluno {
  Aluno exec(UsuarioData usuario, AlunoData info);
}
