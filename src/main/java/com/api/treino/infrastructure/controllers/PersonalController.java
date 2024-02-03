package com.api.treino.infrastructure.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Exercicio;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.usecases.AlterarExercicio;
import com.api.treino.core.domain.usecases.BuscarExercicio;
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
  private BuscarExercicio buscarExercicio;
  private AlterarExercicio alterarExercicio;

  public PersonalController(CriarPersonal criarPersonal, BuscarPersonal buscarPersonal,
      CriarExercicio criarExercicio, BuscarExercicio buscarExercicio,
      AlterarExercicio alterarExercicio) {
    this.criarPersonal = criarPersonal;
    this.criarExercicio = criarExercicio;
    this.buscarPersonal = buscarPersonal;
    this.buscarExercicio = buscarExercicio;
    this.alterarExercicio = alterarExercicio;
  }

  @GetMapping
  public ResponseEntity<List<Personal>> retornarPersonals() throws Exception {
    List<Personal> personals = this.buscarPersonal.buscar();

    return ResponseEntity.status(HttpStatus.OK).body(personals);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Personal> retornarPersonal(@PathVariable("id") UUID personalId)
      throws Exception {
    Personal personal = this.buscarPersonal.buscar(personalId);

    return ResponseEntity.status(HttpStatus.OK).body(personal);
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

  @GetMapping("/{id}/exercicios")
  public ResponseEntity<List<Exercicio>> listarExercicios(
      @PathVariable(value = "id") UUID personalId) throws Exception {

    Personal personal = this.buscarPersonal.buscar(personalId);

    List<Exercicio> exercicios = this.buscarExercicio.buscar(personal);

    return ResponseEntity.status(HttpStatus.OK).body(exercicios);
  }

  @GetMapping("/{id}/exercicios/{exercicio_id}")
  public ResponseEntity<Exercicio> listarExercicio(@PathVariable(value = "id") UUID personalId,
      @PathVariable(value = "exercicio_id") UUID exercicioId) throws Exception {

    Personal personal = this.buscarPersonal.buscar(personalId);

    Exercicio exercicio = this.buscarExercicio.buscar(personal, exercicioId);

    return ResponseEntity.status(HttpStatus.OK).body(exercicio);
  }

  @PutMapping("/{id}/exercicios/{exercicio_id}")
  public ResponseEntity<Exercicio> alterarExercicio(@PathVariable(value = "id") UUID personalId,
      @PathVariable(value = "exercicio_id") UUID exercicioId,
      @RequestBody @Valid ExercicioDTORequest exercicioBody) throws Exception {

    Personal personal = this.buscarPersonal.buscar(personalId);
    Exercicio exercicio = this.buscarExercicio.buscar(personal, exercicioId);

    Exercicio exercicioAlterado =
        this.alterarExercicio.alterar(exercicio, exercicioBody.toExercicio());

    return ResponseEntity.status(HttpStatus.OK).body(exercicioAlterado);
  }
}
