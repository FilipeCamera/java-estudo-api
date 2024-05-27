package com.api.treino.application.gateway;

import java.util.List;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Treino;

public interface ICriarTreinoGateway {
  Treino criar(List<Exercicio> exercicios, Aluno aluno);
}
