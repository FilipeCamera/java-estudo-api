package com.api.treino.infrastructure.controllers.dtos;

import com.api.treino.core.domain.personal.Exercicio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ExercicioDTORequest {

  @NotEmpty
  @NotBlank
  private String nome;

  private String instrucao;

  @NotNull
  private Integer carga;

  @NotNull
  private Integer serie;

  @NotNull
  private Integer repeticao;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getInstrucao() {
    return instrucao;
  }

  public void setInstrucao(String instrucao) {
    this.instrucao = instrucao;
  }

  public Integer getCarga() {
    return carga;
  }

  public void setCarga(Integer carga) {
    this.carga = carga;
  }

  public Integer getSerie() {
    return serie;
  }

  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  public Integer getRepeticao() {
    return repeticao;
  }

  public void setRepeticao(Integer repeticao) {
    this.repeticao = repeticao;
  }

  public Exercicio toExercicio() {
    return new Exercicio(this.nome, this.instrucao, null, this.carga, this.serie, this.repeticao);
  }
}
