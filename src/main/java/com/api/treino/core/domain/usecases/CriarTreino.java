package com.api.treino.core.domain.usecases;

import java.util.List;

import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Treino;

public interface CriarTreino {
	  Treino exec(List<Exercicio> exercicios, Aluno aluno) throws Exception;
	}
