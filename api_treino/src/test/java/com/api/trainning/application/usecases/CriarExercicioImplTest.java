package com.api.trainning.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.api.trainning.application.gateway.CriarExercicioGatewayTest;
import com.api.trainning.core.domain.personal.Exercicio;

public class CriarExercicioImplTest {

  @Test
  public void criarExercicio() {
    CriarExercicioGatewayTest criarExercicioGateway = new CriarExercicioGatewayTest();
    CriarExercicioImpl criarExercicioImpl = new CriarExercicioImpl(criarExercicioGateway);

    try {
      Exercicio exercicio = criarExercicioImpl.exec("Supino Inclinado", null, 12, 3, 15);

      assertEquals(exercicio.getNome(), "Supino Inclinado");
      assertTrue(exercicio.getCarga() == 15);
      assertTrue(exercicio.getRepeticao() == 12);
      assertTrue(exercicio.getSerie() == 3);
    } catch (Exception e) {

    }
  }

  @Test
  public void errorAoCriarUmExercicioSemDados() {
    CriarExercicioGatewayTest criarExercicioGateway = new CriarExercicioGatewayTest();
    CriarExercicioImpl criarExercicioImpl = new CriarExercicioImpl(criarExercicioGateway);

    try {
      criarExercicioImpl.exec(null, null, 0, 0, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "Nao foi possivel criar o exercicio");
    }
  }
}
