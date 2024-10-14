package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.api.treino.application.gateway.ICriarAlunoGatewayTest;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CriarAlunoImplTest {

    CriarAlunoImpl criarAlunoImpl;

    @BeforeEach
    public void carregarDados() {
        ICriarAlunoGatewayTest criarAlunoGatewayTest = new ICriarAlunoGatewayTest();
        this.criarAlunoImpl = new CriarAlunoImpl(criarAlunoGatewayTest);
    }

    @Test
    public void criarAluno() {
        UsuarioData usuario = new UsuarioData("teste", "aluno", "teste@email.com", "teste");
        AlunoData info = new AlunoData(22, 1.65, 58.6);

        try {
            Aluno aluno = criarAlunoImpl.exec(usuario, info);

            assertEquals("teste", aluno.usuario().getNome());
            assertEquals("teste@email.com", aluno.usuario().getEmail());
            assertEquals("aluno", aluno.usuario().getSobrenome());
            assertEquals("teste", aluno.usuario().getSenha());
        } catch (Exception e) {
            // nao pega o erro
        }
    }

    @Test
    public void gerarErroAoCriarAluno() {
        try {
            criarAlunoImpl.exec(null, null);
        } catch (Exception e) {
            assertEquals("Nao foi possivel criar o usuario", e.getMessage());
        }
    }
}
