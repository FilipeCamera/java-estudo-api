package com.api.treino.core.domain.usecases;

import java.util.List;
import java.util.UUID;
import com.api.treino.core.domain.aluno.Aluno;

public interface BuscarAluno {
  List<Aluno> buscar() throws Exception;

  Aluno buscar(UUID id) throws Exception;
}
