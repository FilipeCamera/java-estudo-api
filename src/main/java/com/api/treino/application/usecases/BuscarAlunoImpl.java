package com.api.treino.application.usecases;

import java.util.List;
import java.util.UUID;
import com.api.treino.application.gateway.BuscarAlunoGateway;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.exceptions.NotFoundException;
import com.api.treino.core.domain.usecases.BuscarAluno;

public class BuscarAlunoImpl implements BuscarAluno {

  private BuscarAlunoGateway buscarAlunoGateway;

  public BuscarAlunoImpl(BuscarAlunoGateway buscarAlunoGateway) {
    this.buscarAlunoGateway = buscarAlunoGateway;
  }

  @Override
  public List<Aluno> buscar() throws Exception {
    List<Aluno> alunos = this.buscarAlunoGateway.buscar();

    if (alunos.size() == 0) {
      throw new NotFoundException("Nenhum aluno encontrado");
    }
    return alunos;
  }

  @Override
  public Aluno buscar(UUID id) throws Exception {
    Aluno aluno = this.buscarAlunoGateway.buscar(id);

    if (aluno == null) {
      throw new NotFoundException("Aluno nao encontrado");
    }
    return aluno;
  }

}
