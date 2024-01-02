package com.api.trainning.application.gateway;

import java.util.List;
import com.api.trainning.core.domain.aluno.Aluno;
import com.api.trainning.core.domain.personal.Exercicio;
import com.api.trainning.core.domain.personal.Treino;

public interface CriarTreinoGateway {
  Treino criar(List<Exercicio> exercicios, Aluno aluno);
}
