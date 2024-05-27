package com.api.treino.application.gateway;

import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.aluno.Aluno;

public interface IBuscarAlunoGateway {
  List<Aluno> buscar();

  Aluno buscar(UUID id);
}
