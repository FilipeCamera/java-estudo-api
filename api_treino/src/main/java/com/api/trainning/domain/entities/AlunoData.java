package com.api.trainning.domain.entities;

public class AlunoData {
  private int idade;
  private Double peso;
  private Double altura;
  private Double IMC;

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getIMC() {
    this.IMC = this.peso / Math.pow(this.altura, 2);
    return IMC;
  }
}
