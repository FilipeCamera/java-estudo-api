package com.api.treino.infrastructure.services;

import com.api.treino.application.gateway.CriarExercicioGateway;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.entities.ExercicioEntity;
import com.api.treino.infrastructure.mappers.ExercicioMapper;
import com.api.treino.infrastructure.repositories.ExercicioRepository;

public class CriarExercicioGatewayImpl implements CriarExercicioGateway {

  private ExercicioRepository exercicioRepository;
  private ExercicioMapper exercicioMapper;

  public CriarExercicioGatewayImpl(ExercicioRepository exercicioRepository,
      ExercicioMapper exercicioMapper) {
    this.exercicioRepository = exercicioRepository;
    this.exercicioMapper = exercicioMapper;
  }

  @Override
  public Exercicio criar(String nome, String instrucao, Personal personal, int repeticao, int serie,
      int carga) {

    Exercicio exercicio = new Exercicio(nome, instrucao, personal, carga, serie, repeticao);

    ExercicioEntity exercicioEntity = this.exercicioMapper.toExercicioEntity(exercicio);

    ExercicioEntity exercicioResponse = this.exercicioRepository.save(exercicioEntity);

    return this.exercicioMapper.toExercicio(exercicioResponse);
  }

}
