package com.api.treino.core.domain.personal;

import java.util.UUID;

public class Exercicio {

  private UUID id;
  private String nome;
  private String instrucao;
  private Personal personal;
  private int repeticao;
  private int serie;
  private int carga;

  public Exercicio(UUID id, String nome, String instrucao, Personal personal, int repeticao,
      int serie, int carga) {
    this.id = id;
    this.nome = nome;
    this.instrucao = instrucao;
    this.personal = personal;
    this.repeticao = repeticao;
    this.serie = serie;
    this.carga = carga;
  }

  public Exercicio(String nome, String instrucao, Personal personal, int repeticao, int serie,
      int carga) {
    this.nome = nome;
    this.instrucao = instrucao;
    this.personal = personal;
    this.repeticao = repeticao;
    this.serie = serie;
    this.carga = carga;
  }

  public UUID getId() {
    return id;
  }

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

  public int getRepeticao() {
    return repeticao;
  }

  public void setRepeticao(int repeticao) {
    if (repeticao <= 0) {
      this.repeticao = 12;
    }
    this.repeticao = repeticao;
  }

  public int getSerie() {
    return serie;
  }

  public void setSerie(int serie) {
    if (serie <= 0) {
      this.serie = 1;
    }
    this.serie = serie;
  }

  public int getCarga() {
    return carga;
  }

  public void setCarga(int carga) {
    if (carga <= 0) {
      this.carga = 5;
    }
    this.carga = carga;
  }

  public Personal getPersonal() {
    return personal;
  }

  public void setPersonal(Personal personal) {
    this.personal = personal;
  }

}
