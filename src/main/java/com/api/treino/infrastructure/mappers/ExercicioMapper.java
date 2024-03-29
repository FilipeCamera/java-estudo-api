package com.api.treino.infrastructure.mappers;

import org.springframework.stereotype.Component;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.infrastructure.entities.ExercicioEntity;

@Component
public class ExercicioMapper {

  public static ExercicioEntity toExercicioEntity(Exercicio exercicio) {
    ExercicioEntity exercicioEntity = new ExercicioEntity();

    exercicioEntity.setNome(exercicio.getNome());
    exercicioEntity.setInstrucao(exercicio.getInstrucao());
    exercicioEntity.setPersonal(PersonalMapper.toPersonalEntity(exercicio.getPersonal().usuario()));
    exercicioEntity.setCarga(exercicio.getCarga());
    exercicioEntity.setSerie(exercicio.getSerie());
    exercicioEntity.setRepeticao(exercicio.getRepeticao());

    return exercicioEntity;
  }

  public static Exercicio toExercicio(ExercicioEntity exercicioEntity) {

    Exercicio exercicio = new Exercicio(exercicioEntity.getId(), exercicioEntity.getNome(),
        exercicioEntity.getInstrucao(),
        PersonalMapper.toPersonalExercicio(exercicioEntity.getPersonal()),
        exercicioEntity.getCarga(), exercicioEntity.getSerie(), exercicioEntity.getRepeticao());

    return exercicio;
  }
}
