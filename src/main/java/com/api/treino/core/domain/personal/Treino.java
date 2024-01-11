package com.api.treino.core.domain.personal;

import java.util.List;

import com.api.treino.core.domain.aluno.Aluno;

public record Treino(List<Exercicio> exercicios, Aluno aluno) {

}
