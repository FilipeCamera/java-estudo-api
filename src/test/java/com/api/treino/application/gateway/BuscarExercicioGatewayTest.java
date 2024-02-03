package com.api.treino.application.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;

public class BuscarExercicioGatewayTest implements BuscarExercicioGateway {

  private List<Exercicio> bd = new ArrayList<>();

  public UUID id = UUID.randomUUID();
  public Personal personal =
      new Personal(new UsuarioData("test", "test", "test@email.com", "test"));

  public BuscarExercicioGatewayTest() {
    Exercicio exercicio1 = new Exercicio(id, "test", "test", personal, 4, 5, 6);
    Exercicio exercicio2 = new Exercicio(UUID.randomUUID(), "test", "test", personal, 4, 5, 6);
    Exercicio exercicio3 = new Exercicio(UUID.randomUUID(), "test", "test", personal, 4, 5, 6);

    bd.add(exercicio1);
    bd.add(exercicio2);
    bd.add(exercicio3);
  }

  @Override
  public Exercicio buscar(Personal personal, UUID id) {
    Exercicio exercicio = null;

    for (Exercicio exer : bd) {
      if (exer.getPersonal().equals(personal) && exer.getId().equals(id)) {
        exercicio = exer;
      }
    }
    return exercicio;
  }

  @Override
  public List<Exercicio> buscar(Personal personal) {
    // TODO Auto-generated method stub
    return bd.stream().filter(exercicio -> exercicio.getPersonal().equals(personal)).toList();
  }

  public void limparBanco() {
    bd.clear();
  }

}
