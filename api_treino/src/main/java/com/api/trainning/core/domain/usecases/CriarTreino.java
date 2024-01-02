package com.api.trainning.core.domain.usecases;

import java.util.List;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.personal.Exercicio;
import com.api.trainning.core.domain.personal.Treino;

public interface CriarTreino {
  Treino exec(List<Exercicio> exercicios, Aluno aluno) throws Exception;
}
