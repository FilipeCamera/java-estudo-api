package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.ICriarExercicioGatewayTest;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;

public class CriarExercicioImplTest {

  @Test
  public void criarExercicio() {
    ICriarExercicioGatewayTest criarExercicioGateway = new ICriarExercicioGatewayTest();
    CriarExercicioImpl criarExercicioImpl = new CriarExercicioImpl(criarExercicioGateway);

    UsuarioData usuario = new UsuarioData();
    Personal personal = new Personal(usuario);

    try {
      Exercicio exercicio = criarExercicioImpl.exec("Supino Inclinado", null, personal, 12, 3, 15);

      assertEquals(exercicio.getNome(), "Supino Inclinado");
      assertTrue(exercicio.getCarga() == 15);
      assertTrue(exercicio.getRepeticao() == 12);
      assertTrue(exercicio.getSerie() == 3);
    } catch (Exception e) {

    }
  }

  @Test
  public void erroAoCriarUmExercicioSemTreinador() {
    ICriarExercicioGatewayTest criarExercicioGateway = new ICriarExercicioGatewayTest();
    CriarExercicioImpl criarExercicioImpl = new CriarExercicioImpl(criarExercicioGateway);

    try {
      criarExercicioImpl.exec("Supino Inclinado", null, null, 12, 3, 15);

    } catch (Exception e) {
      assertEquals(e.getMessage(), "O exercicio precisa de um criador(treinador)");
    }
  }

  @Test
  public void errorAoCriarUmExercicioSemDados() {
    ICriarExercicioGatewayTest criarExercicioGateway = new ICriarExercicioGatewayTest();
    CriarExercicioImpl criarExercicioImpl = new CriarExercicioImpl(criarExercicioGateway);

    try {
      criarExercicioImpl.exec(null, null, null, 0, 0, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "O exericio precisa de um titulo");
    }
  }
}
