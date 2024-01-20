package com.api.treino.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import com.api.treino.core.domain.usecases.CriarAluno;
import com.api.treino.infrastructure.controllers.dtos.AlunoDTORequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

  private CriarAluno criarAluno;

  public AlunoController(CriarAluno criarAluno) {
    this.criarAluno = criarAluno;
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
