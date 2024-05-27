package com.api.treino.application.usecases;

import com.api.treino.application.gateway.IAlterarExercicioGateway;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.usecases.AlterarExercicio;

public class AlterarExercicioImpl implements AlterarExercicio {

  private IAlterarExercicioGateway alterarExercicioGateway;

  public AlterarExercicioImpl(IAlterarExercicioGateway alterarExercicioGateway) {
    this.alterarExercicioGateway = alterarExercicioGateway;
  }

  @Override
  public Exercicio alterar(Exercicio exercicio, Exercicio exercicioNovo) throws Exception {

    if (!exercicio.getNome().equalsIgnoreCase(exercicioNovo.getNome())) {
      exercicio.setNome(exercicioNovo.getNome());
    } else if (!exercicio.getInstrucao().equalsIgnoreCase(exercicioNovo.getInstrucao())) {
      exercicio.setInstrucao(exercicioNovo.getInstrucao());
    } else if (exercicio.getCarga() != exercicioNovo.getCarga()) {
      exercicio.setCarga(exercicioNovo.getCarga());
    } else if (exercicio.getSerie() != exercicioNovo.getSerie()) {
      exercicio.setSerie(exercicioNovo.getSerie());
    } else if (exercicio.getRepeticao() != exercicioNovo.getRepeticao()) {
      exercicio.setRepeticao(exercicioNovo.getRepeticao());
    }

    Exercicio exercicioAlterado = this.alterarExercicioGateway.alterar(exercicio);


    return exercicioAlterado;
  }

}
