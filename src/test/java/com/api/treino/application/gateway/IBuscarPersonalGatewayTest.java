package com.api.treino.application.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;

public class IBuscarPersonalGatewayTest implements IBuscarPersonalGateway {

  private List<Personal> bd = new ArrayList<>();

  public UUID id = UUID.randomUUID();

  public IBuscarPersonalGatewayTest() {
    Personal personal1 = new Personal(new UsuarioData(id, "test", "1", "test", "test"));
    Personal personal2 =
        new Personal(new UsuarioData(UUID.randomUUID(), "test", "2", "test", "test"));
    Personal personal3 =
        new Personal(new UsuarioData(UUID.randomUUID(), "test", "3", "test", "test"));

    bd.add(personal1);
    bd.add(personal2);
    bd.add(personal3);
  }

  @Override
  public Personal buscar(UUID id) {
    Personal personal = null;
    for (Personal persona : bd) {
      if (persona.usuario().getId().equals(id)) {
        personal = persona;
      }
    }
    return personal;
  }

  @Override
  public List<Personal> buscar() {

    return bd;
  }

}
