package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.BuscarExercicioGatewayTest;
import com.api.treino.core.domain.personal.Exercicio;

public class BuscarExercicioImplTest {

  @Test
  public void buscarExercicios() {
    BuscarExercicioGatewayTest buscarExercicioGatewayTest = new BuscarExercicioGatewayTest();
    BuscarExercicioImpl buscarExercicioImpl = new BuscarExercicioImpl(buscarExercicioGatewayTest);

    try {
      List<Exercicio> exercicios = buscarExercicioImpl.buscar(buscarExercicioGatewayTest.personal);

      assertEquals(3, exercicios.size());
    } catch (Exception e) {
      //
    }
  }

  @Test
  public void buscarExercicioPorId() {
    BuscarExercicioGatewayTest buscarExercicioGatewayTest = new BuscarExercicioGatewayTest();
    BuscarExercicioImpl buscarExercicioImpl = new BuscarExercicioImpl(buscarExercicioGatewayTest);

    try {
      Exercicio exercicio = buscarExercicioImpl.buscar(buscarExercicioGatewayTest.personal,
          buscarExercicioGatewayTest.id);

      assertEquals("test", exercicio.getNome());
      assertEquals(buscarExercicioGatewayTest.id, exercicio.getId());
    } catch (Exception e) {
      //
    }
  }

  @Test
  public void erroAoBuscarExercicio() {
    BuscarExercicioGatewayTest buscarExercicioGatewayTest = new BuscarExercicioGatewayTest();
    BuscarExercicioImpl buscarExercicioImpl = new BuscarExercicioImpl(buscarExercicioGatewayTest);

    try {
      buscarExercicioGatewayTest.limparBanco();
      buscarExercicioImpl.buscar(null);
    } catch (Exception e) {
      assertEquals("Nenhum exercicio encontrado", e.getMessage());
    }
  }

  @Test
  public void erroAoBuscarExercicioPorId() {
    BuscarExercicioGatewayTest buscarExercicioGatewayTest = new BuscarExercicioGatewayTest();
    BuscarExercicioImpl buscarExercicioImpl = new BuscarExercicioImpl(buscarExercicioGatewayTest);

    try {
      buscarExercicioGatewayTest.limparBanco();
      buscarExercicioImpl.buscar(buscarExercicioGatewayTest.personal, null);
    } catch (Exception e) {
      assertEquals("Nao foi encontrado o exercicio", e.getMessage());
    }
  }
}
