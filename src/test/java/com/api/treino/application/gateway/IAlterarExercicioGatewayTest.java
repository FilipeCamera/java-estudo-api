package com.api.treino.application.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;

public class IAlterarExercicioGatewayTest implements IAlterarExercicioGateway {

  public List<Exercicio> bd = new ArrayList<>();

  private Personal personal =
      new Personal(new UsuarioData("test", "test", "test@email.com", "test"));

  public IAlterarExercicioGatewayTest() {
    Exercicio exercicio1 = new Exercicio(UUID.randomUUID(), "test", "test", personal, 4, 5, 6);
    Exercicio exercicio2 = new Exercicio(UUID.randomUUID(), "test", "test", personal, 4, 5, 6);
    Exercicio exercicio3 = new Exercicio(UUID.randomUUID(), "test", "test", personal, 4, 5, 6);

    bd.add(exercicio1);
    bd.add(exercicio2);
    bd.add(exercicio3);
  }

  @Override
  public Exercicio alterar(Exercicio exercicio) {

    this.bd.stream().forEach(exercicioBd -> {
      if (exercicioBd.getId().equals(exercicio.getId())) {
        exercicioBd = exercicio;
      }
    });

    Optional<Exercicio> exercicioAlterarBd = this.bd.stream()
        .filter(exercicioBd -> exercicioBd.getId().equals(exercicio.getId())).findFirst();

    return exercicioAlterarBd.get();
  }

}
