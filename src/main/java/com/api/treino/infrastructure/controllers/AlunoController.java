package com.api.treino.infrastructure.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import com.api.treino.core.domain.usecases.BuscarAluno;
import com.api.treino.core.domain.usecases.CriarAluno;
import com.api.treino.infrastructure.controllers.dtos.AlunoDTORequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

  private CriarAluno criarAluno;
  private BuscarAluno buscarAluno;

  public AlunoController(CriarAluno criarAluno, BuscarAluno buscarAluno) {
    this.criarAluno = criarAluno;
    this.buscarAluno = buscarAluno;
  }

  @GetMapping
  public ResponseEntity<List<Aluno>> buscarAluno() throws Exception {
    List<Aluno> alunos = this.buscarAluno.buscar();
    return ResponseEntity.status(HttpStatus.OK).body(alunos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Aluno> buscarAluno(@PathVariable("id") UUID alunoId) throws Exception {
    Aluno aluno = this.buscarAluno.buscar(alunoId);

    return ResponseEntity.status(HttpStatus.OK).body(aluno);
  }

  @PostMapping
  public ResponseEntity<Aluno> criarAluno(@RequestBody @Valid AlunoDTORequest alunoRequest)
      throws Exception {
    UsuarioData usuario = alunoRequest.toUsuarioData();
    AlunoData info = alunoRequest.toAlunoData();

    Aluno aluno = this.criarAluno.exec(usuario, info);

    return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
  }
}
