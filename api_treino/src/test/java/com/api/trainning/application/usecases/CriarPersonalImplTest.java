package com.api.trainning.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.api.trainning.application.gateway.CriarPersonalGatewayTest;
import com.api.trainning.core.domain.UsuarioData;
import com.api.trainning.core.domain.personal.Personal;
import com.api.trainning.core.domain.personal.Treino;

public class CriarPersonalImplTest {

  @Test
  public void CriarPersonal() {
    CriarPersonalGatewayTest criarPersonalGatewayTest = new CriarPersonalGatewayTest();
    CriarPersonalImpl criarPersonalImpl = new CriarPersonalImpl(criarPersonalGatewayTest);

    UsuarioData usuario = new UsuarioData();
    List<Treino> treinos = new ArrayList<Treino>();

    usuario.setNome("teste");
    usuario.setEmail("teste@email.com");
    usuario.setSobrenome("personal");
    usuario.setSenha("teste");

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
