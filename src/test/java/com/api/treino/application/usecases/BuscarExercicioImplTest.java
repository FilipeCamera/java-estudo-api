package com.api.treino.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.api.treino.application.gateway.IBuscarExercicioGatewayTest;
import com.api.treino.core.domain.personal.Exercicio;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuscarExercicioImplTest {

    private IBuscarExercicioGatewayTest buscarExercicioGatewayTest;
    private BuscarExercicioImpl buscarExercicioImpl;

    @BeforeEach
    public void carregarDados() {
        buscarExercicioGatewayTest = new IBuscarExercicioGatewayTest();
        buscarExercicioImpl = new BuscarExercicioImpl(buscarExercicioGatewayTest);
    }

    @Test
    public void buscarExercicios() {
        try {
            List<Exercicio> exercicios = buscarExercicioImpl.buscar(buscarExercicioGatewayTest.personal);

            assertEquals(3, exercicios.size());
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void buscarExercicioPorId() {
        try {
            Exercicio exercicio = buscarExercicioImpl.buscar(
                buscarExercicioGatewayTest.personal,
                buscarExercicioGatewayTest.id
            );

            assertEquals("test", exercicio.getNome());
            assertEquals(buscarExercicioGatewayTest.id, exercicio.getId());
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void erroAoBuscarExercicio() {
        try {
            buscarExercicioGatewayTest.limparBanco();
            buscarExercicioImpl.buscar(null);
        } catch (Exception e) {
            assertEquals("Nenhum exercicio encontrado", e.getMessage());
        }
    }

    @Test
    public void erroAoBuscarExercicioPorId() {
        try {
            buscarExercicioGatewayTest.limparBanco();
            buscarExercicioImpl.buscar(buscarExercicioGatewayTest.personal, null);
        } catch (Exception e) {
            assertEquals("Nao foi encontrado o exercicio", e.getMessage());
        }
    }
}
