package com.api.trainning.core.domain.personal;

import java.util.List;
import com.api.trainning.core.domain.aluno.Aluno;

public record Treino(List<Exercicio> exercicios, Aluno aluno) {

}
