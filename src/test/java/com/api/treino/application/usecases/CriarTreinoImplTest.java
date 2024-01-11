package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.CriarTreinoGatewayTest;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Treino;

public class CriarTreinoImplTest {

  @Test
  public void criarTreino() {
    CriarTreinoGatewayTest criarTreinoGatewayTest = new CriarTreinoGatewayTest();
    CriarTreinoImpl criarTreinoImpl = new CriarTreinoImpl(criarTreinoGatewayTest);

    Aluno aluno = new Aluno(
        new UsuarioData("teste_aluno", "teste_aluno@email.com", "teste_aluno", "teste_aluno"),
        new AlunoData(22, 1.69, 51.8));
    Exercicio exercicio1 = new Exercicio("supino reto", null, 12, 3, 18);
    Exercicio exercicio2 = new Exercicio("supino inclinado", null, 12, 3, 18);
    Exercicio exercicio3 = new Exercicio("supino com halteres", null, 12, 3, 18);

    List<Exercicio> exercicios = new ArrayList<>();

    exercicios.add(exercicio1);
    exercicios.add(exercicio2);
    exercicios.add(exercicio3);

    try {
      Treino treino = criarTreinoImpl.exec(exercicios, aluno);

      assertEquals(treino.exercicios(), exercicios);
      assertEquals(treino.aluno(), aluno);
      assertTrue(treino.exercicios().get(0).equals(exercicio1));
    } catch (Exception e) {

    }
  }

  @Test
  public void gerarErroAoCriarUmTreinoSemDados() {
    CriarTreinoGatewayTest criarTreinoGatewayTest = new CriarTreinoGatewayTest();
    CriarTreinoImpl criarTreinoImpl = new CriarTreinoImpl(criarTreinoGatewayTest);

    try {
      criarTreinoImpl.exec(null, null);

    } catch (Exception e) {
      assertEquals(e.getMessage(), "Nao foi possivel criar o treino");
      assertTrue(e.getMessage().equals("Nao foi possivel criar o treino"));
    }
  }
}
