package com.api.treino.infrastructure.services;

import java.util.Optional;
import com.api.treino.application.gateway.IAlterarExercicioGateway;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.infrastructure.entities.ExercicioEntity;
import com.api.treino.infrastructure.mappers.ExercicioMapper;
import com.api.treino.infrastructure.repositories.ExercicioRepository;

public class AlterarExercicioGatewayImpl implements IAlterarExercicioGateway {

  private ExercicioRepository exercicioRepository;

  public AlterarExercicioGatewayImpl(ExercicioRepository exercicioRepository) {
    this.exercicioRepository = exercicioRepository;
  }

  @Override
  public Exercicio alterar(Exercicio exercicio) {
    Optional<ExercicioEntity> exercicioOptional =
        this.exercicioRepository.findById(exercicio.getId());

    ExercicioEntity exercicioEntity = exercicioOptional.get();

    exercicioEntity.setNome(exercicio.getNome());
    exercicioEntity.setInstrucao(exercicio.getInstrucao());
    exercicioEntity.setCarga(exercicio.getCarga());
    exercicioEntity.setSerie(exercicio.getSerie());
    exercicioEntity.setRepeticao(exercicio.getRepeticao());

    ExercicioEntity exercicioAlterado = this.exercicioRepository.save(exercicioEntity);
    return ExercicioMapper.toExercicio(exercicioAlterado);
  }

}
