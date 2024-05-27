package com.api.treino.infrastructure.services;

import com.api.treino.application.gateway.ICriarExercicioGateway;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.entities.ExercicioEntity;
import com.api.treino.infrastructure.mappers.ExercicioMapper;
import com.api.treino.infrastructure.repositories.ExercicioRepository;

public class CriarExercicioGatewayImpl implements ICriarExercicioGateway {

  private ExercicioRepository exercicioRepository;

  public CriarExercicioGatewayImpl(ExercicioRepository exercicioRepository) {
    this.exercicioRepository = exercicioRepository;
  }

  @Override
  public Exercicio criar(String nome, String instrucao, Personal personal, int repeticao, int serie,
      int carga) {

    Exercicio exercicio = new Exercicio(nome, instrucao, personal, carga, serie, repeticao);

    ExercicioEntity exercicioEntity = ExercicioMapper.toExercicioEntity(exercicio);

    ExercicioEntity exercicioResponse = this.exercicioRepository.save(exercicioEntity);

    return ExercicioMapper.toExercicio(exercicioResponse);
  }

}
