package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.BuscarPersonalGatewayTest;
import com.api.treino.core.domain.personal.Personal;

public class BuscarPersonalImplTest {

  private BuscarPersonalGatewayTest buscarPersonalGatewayTest = new BuscarPersonalGatewayTest();
  private BuscarPersonalImpl buscarPersonalImpl = new BuscarPersonalImpl(buscarPersonalGatewayTest);

  @Test
  public void buscarPorId() {

    try {
      Personal personal = this.buscarPersonalImpl.buscar(buscarPersonalGatewayTest.id);

      assertEquals(buscarPersonalGatewayTest.id, personal.usuario().getId());
      assertEquals("test", personal.usuario().getNome());
    } catch (Exception e) {

    }
  }

  @Test
  public void buscarTodosPersonal() {
    try {
      List<Personal> personals = this.buscarPersonalImpl.buscar();

      assertTrue(!personals.isEmpty());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void erroAoBuscarPorId() {

    try {
      this.buscarPersonalImpl.buscar(UUID.randomUUID());
    } catch (Exception e) {
      assertEquals("Personal nao encontrado", e.getMessage());
    }
  }

}
