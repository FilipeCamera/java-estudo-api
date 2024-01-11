package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.api.treino.application.gateway.CriarPersonalGatewayTest;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.personal.Treino;

public class CriarPersonalImplTest {

  @Test
  public void CriarPersonal() {
    CriarPersonalGatewayTest criarPersonalGatewayTest = new CriarPersonalGatewayTest();
    CriarPersonalImpl criarPersonalImpl = new CriarPersonalImpl(criarPersonalGatewayTest);

    UsuarioData usuario = new UsuarioData("teste", "personal", "teste@email.com", "teste");
    List<Treino> treinos = new ArrayList<Treino>();

    try {
      Personal personal = criarPersonalImpl.exec(usuario, treinos);

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
    CriarPersonalGatewayTest criarPersonalGatewayTest = new CriarPersonalGatewayTest();
    CriarPersonalImpl criarPersonalImpl = new CriarPersonalImpl(criarPersonalGatewayTest);

    try {
      criarPersonalImpl.exec(null, null);

    } catch (Exception e) {
      assertEquals("Nao foi possivel criar o usuario", e.getMessage());
    }

  }
}
