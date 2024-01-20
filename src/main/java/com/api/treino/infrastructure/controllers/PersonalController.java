package com.api.treino.infrastructure.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.usecases.CriarPersonal;
import com.api.treino.infrastructure.controllers.dtos.UsuarioDTORequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/personals")
public class PersonalController {

  private CriarPersonal criarPersonal;

  public PersonalController(CriarPersonal criarPersonal) {
    this.criarPersonal = criarPersonal;
  }

  @GetMapping
  public ResponseEntity<List<Personal>> retornarPersonals() {
    List<Personal> personals = new ArrayList<>();

    return ResponseEntity.status(HttpStatus.OK).body(personals);
  }

  @PostMapping
  public ResponseEntity<Personal> criarPersonal(
      @RequestBody @Valid UsuarioDTORequest usuarioRequest) throws Exception {
    UsuarioData usuario = usuarioRequest.toUsuarioData();

    Personal personal = this.criarPersonal.exec(usuario);

    return ResponseEntity.status(HttpStatus.CREATED).body(personal);
  }
}
