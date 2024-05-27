package com.api.treino.application.gateway;

import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;

public interface ICriarAlunoGateway {
	  Aluno criar(UsuarioData usuario, AlunoData info);
}
