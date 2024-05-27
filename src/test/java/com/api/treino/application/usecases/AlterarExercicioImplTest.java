package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.IAlterarExercicioGatewayTest;
import com.api.treino.core.domain.personal.Exercicio;

public class AlterarExercicioImplTest {

  @Test
  public void alterarExercicio() {
    IAlterarExercicioGatewayTest alterarExercicioGateway = new IAlterarExercicioGatewayTest();
    AlterarExercicioImpl alterarExercicioImpl = new AlterarExercicioImpl(alterarExercicioGateway);

    Exercicio exercicioAntes = alterarExercicioGateway.bd.get(0);
    Exercicio exercicioNovo =
        new Exercicio(exercicioAntes.getId(), "testNovo", "test", null, 4, 5, 6);
    try {

      Exercicio exercicio = alterarExercicioImpl.alterar(exercicioAntes, exercicioNovo);

      assertEquals(exercicioNovo.getNome(), exercicio.getNome());

    } catch (Exception e) {
      //
    }
  }
}
