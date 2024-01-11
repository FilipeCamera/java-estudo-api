package com.api.treino.core.domain.usecases;

import com.api.treino.core.domain.personal.Exercicio;

public interface CriarExercicio {
	  Exercicio exec(String nome, String instrucao, int repeticao, int serie, int carga)
	      throws Exception;
}
