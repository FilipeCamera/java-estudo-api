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
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.usecases.BuscarPersonal;
import com.api.treino.core.domain.usecases.CriarExercicio;
import com.api.treino.core.domain.usecases.CriarPersonal;
import com.api.treino.infrastructure.controllers.dtos.ExercicioDTORequest;
import com.api.treino.infrastructure.controllers.dtos.UsuarioDTORequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/personals")
public class PersonalController {

  private CriarPersonal criarPersonal;
  private BuscarPersonal buscarPersonal;
  private CriarExercicio criarExercicio;

  public PersonalController(CriarPersonal criarPersonal, BuscarPersonal buscarPersonal,
      CriarExercicio criarExercicio) {
    this.criarPersonal = criarPersonal;
    this.criarExercicio = criarExercicio;
    this.buscarPersonal = buscarPersonal;
  }

  @GetMapping
  public ResponseEntity<List<Personal>> retornarPersonals() throws Exception {
    List<Personal> personals = this.buscarPersonal.buscar();

    return ResponseEntity.status(HttpStatus.OK).body(personals);
  }

  @PostMapping
  public ResponseEntity<Personal> criarPersonal(
      @RequestBody @Valid UsuarioDTORequest usuarioRequest) throws Exception {
    UsuarioData usuario = usuarioRequest.toUsuarioData();

    Personal personal = this.criarPersonal.exec(usuario);

    return ResponseEntity.status(HttpStatus.CREATED).body(personal);
  }

  @PostMapping("/{id}/exercicios")
  public ResponseEntity<Exercicio> criarExercicio(
      @RequestBody @Valid ExercicioDTORequest exercicioRequest,
      @PathVariable(value = "id") UUID personalId) throws Exception {

    Personal personal = this.buscarPersonal.buscar(personalId);

    Exercicio exercicio = this.criarExercicio.exec(exercicioRequest.getNome(),
        exercicioRequest.getInstrucao(), personal, exercicioRequest.getCarga(),
        exercicioRequest.getSerie(), exercicioRequest.getRepeticao());

    return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
  }
}
