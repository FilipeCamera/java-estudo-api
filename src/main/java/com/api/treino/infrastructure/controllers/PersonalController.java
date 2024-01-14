package com.api.treino.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.treino.application.usecases.CriarPersonalImpl;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.controllers.dtos.UsuarioDTORequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/personals")
public class PersonalController {

  private CriarPersonalImpl criarPersonalImpl;

  public PersonalController(CriarPersonalImpl criarPersonalImpl) {
    this.criarPersonalImpl = criarPersonalImpl;
  }

  @PostMapping
  public ResponseEntity<Personal> criarPersonal(
      @RequestBody @Valid UsuarioDTORequest usuarioRequest) throws Exception {
    UsuarioData usuario = usuarioRequest.toUsuarioData();

    Personal personal = this.criarPersonalImpl.exec(usuario, null);

    return ResponseEntity.status(HttpStatus.CREATED).body(personal);
  }
}
