package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.ICriarAlunoGatewayTest;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;

public class CriarAlunoImplTest {

  @Test
  public void criarAluno() {
    ICriarAlunoGatewayTest criarAlunoGatewayTest = new ICriarAlunoGatewayTest();
    CriarAlunoImpl criarAlunoImpl = new CriarAlunoImpl(criarAlunoGatewayTest);

    UsuarioData usuario = new UsuarioData("teste", "aluno", "teste@email.com", "teste");
    AlunoData info = new AlunoData(22, 1.65, 58.6);

    try {
      Aluno aluno = criarAlunoImpl.exec(usuario, info);

      assertEquals("teste", aluno.usuario().getNome());
      assertEquals("teste@email.com", aluno.usuario().getEmail());
      assertEquals("aluno", aluno.usuario().getSobrenome());
      assertEquals("teste", aluno.usuario().getSenha());
    } catch (Exception e) {

    }
  }

  @Test
  public void gerarErroAoCriarAluno() {
    ICriarAlunoGatewayTest criarAlunoGatewayTest = new ICriarAlunoGatewayTest();
    CriarAlunoImpl criarAlunoImpl = new CriarAlunoImpl(criarAlunoGatewayTest);

    try {
      criarAlunoImpl.exec(null, null);
    } catch (Exception e) {
      assertEquals("Nao foi possivel criar o usuario", e.getMessage());
    }
  }
}
