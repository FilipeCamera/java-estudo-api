package com.api.trainning.core.domain.usecases;

import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.aluno.AlunoData;

public interface CriarAluno {
  Aluno exec(UsuarioData usuario, AlunoData info);
}
