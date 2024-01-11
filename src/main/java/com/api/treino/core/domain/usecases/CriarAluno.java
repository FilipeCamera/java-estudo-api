package com.api.treino.core.domain.usecases;

import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;

public interface CriarAluno {
	  Aluno exec(UsuarioData usuario, AlunoData info) throws Exception;
}
