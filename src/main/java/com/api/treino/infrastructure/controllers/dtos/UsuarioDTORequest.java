package com.api.treino.infrastructure.controllers.dtos;

import com.api.treino.core.domain.UsuarioData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UsuarioDTORequest {

  @NotBlank
  @NotEmpty
  private String nome;

  @NotBlank
  @NotEmpty
  private String sobrenome;

  @NotBlank
  @NotEmpty
  @Email
  private String email;

  @NotBlank
  @NotEmpty
  @Size(min = 8)
  private String senha;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public UsuarioData toUsuarioData() {
    return new UsuarioData(this.nome, this.sobrenome, this.email, this.senha);
  }

}
