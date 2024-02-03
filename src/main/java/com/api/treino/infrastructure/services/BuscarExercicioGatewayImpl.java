package com.api.treino.infrastructure.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.treino.application.gateway.BuscarExercicioGateway;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.entities.ExercicioEntity;
import com.api.treino.infrastructure.mappers.ExercicioMapper;
import com.api.treino.infrastructure.mappers.PersonalMapper;
import com.api.treino.infrastructure.repositories.ExercicioRepository;

public class BuscarExercicioGatewayImpl implements BuscarExercicioGateway {

  private ExercicioRepository exercicioRepository;


  public BuscarExercicioGatewayImpl(ExercicioRepository exercicioRepository) {
    this.exercicioRepository = exercicioRepository;
  }

  @Override
  public Exercicio buscar(Personal personal, UUID id) {
    Optional<ExercicioEntity> exer = this.exercicioRepository
        .findByPersonalAndId(PersonalMapper.toPersonalEntity(personal.usuario()), id);

    ExercicioEntity exercicio = exer.get();

    return ExercicioMapper.toExercicio(exercicio);
  }

  @Override
  public List<Exercicio> buscar(Personal personal) {
    List<ExercicioEntity> exerciciosEntity = this.exercicioRepository
        .findByPersonal(PersonalMapper.toPersonalEntity(personal.usuario()));
    List<Exercicio> exercicios = new ArrayList<>();
    for (ExercicioEntity exercicioEntity : exerciciosEntity) {
      exercicios.add(ExercicioMapper.toExercicio(exercicioEntity));
    }
    return exercicios;
  }
}
