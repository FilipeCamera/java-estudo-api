package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.ICriarPersonalGatewayTest;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;

public class CriarPersonalImplTest {

  @Test
  public void CriarPersonal() {
    ICriarPersonalGatewayTest criarPersonalGatewayTest = new ICriarPersonalGatewayTest();
    CriarPersonalImpl criarPersonalImpl = new CriarPersonalImpl(criarPersonalGatewayTest);

    UsuarioData usuario = new UsuarioData("teste", "personal", "teste@email.com", "teste");

    try {
      Personal personal = criarPersonalImpl.exec(usuario);

      assertEquals("teste", personal.usuario().getNome());
      assertEquals("teste@email.com", personal.usuario().getEmail());
      assertEquals("personal", personal.usuario().getSobrenome());
      assertEquals("teste", personal.usuario().getSenha());

    } catch (Exception e) {
      //
    }

  }

  @Test
  public void gerarErroAoCriarPersonal() {
    ICriarPersonalGatewayTest criarPersonalGatewayTest = new ICriarPersonalGatewayTest();
    CriarPersonalImpl criarPersonalImpl = new CriarPersonalImpl(criarPersonalGatewayTest);

    try {
      criarPersonalImpl.exec(null);

    } catch (Exception e) {
      assertEquals("Nao foi possivel criar o usuario", e.getMessage());
    }

  }
}
