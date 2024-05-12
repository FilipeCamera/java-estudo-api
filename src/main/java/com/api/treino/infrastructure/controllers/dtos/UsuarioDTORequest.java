package com.api.treino.infrastructure.controllers.dtos;

import com.api.treino.core.domain.UsuarioData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTORequest {

  @NotBlank(message = "Nome nao pode esta em branco ou nulo")
  private String nome;

  @NotBlank(message = "Sobrenome nao pode esta em branco ou nulo")
  private String sobrenome;

  @NotBlank(message = "Email nao pode esta em branco ou nulo")
  @Email(message = "Precisa ser um email valido")
  private String email;

  @NotBlank(message = "Senha nao pode esta em branco ou nulo")
  @Size(min = 8, message = "Senha precisa ter pelo menos 8 caracteres")
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
