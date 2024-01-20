package com.api.treino.infrastructure.controllers.dtos;

import com.api.treino.core.domain.aluno.AlunoData;
import jakarta.validation.constraints.NotNull;


public class AlunoDTORequest extends UsuarioDTORequest {

  @NotNull
  private Integer idade;

  @NotNull
  private Double altura;

  @NotNull
  private Double peso;

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public AlunoData toAlunoData() {
    return new AlunoData(this.idade, this.altura, this.peso);
  }

}
