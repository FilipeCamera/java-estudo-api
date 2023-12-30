package com.api.trainning.domain.entities;

import java.util.Date;
import java.util.List;

public class TreinoData {
  private List<Exercicio> exercicios;
  private Date dataCriacao;
  private Date dataExpiracao;
  private int quantidadeDeVezes;
  private int vezes;

  public List<Exercicio> getExercicios() {
    return exercicios;
  }

  public void setExercicios(List<Exercicio> exercicios) {
    this.exercicios = exercicios;
  }

  public Date getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(Date dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public Date getDataExpiracao() {
    return dataExpiracao;
  }

  public void setDataExpiracao(Date dataExpiracao) {
    this.dataExpiracao = dataExpiracao;
  }

  public int getQuantidadeDeVezes() {
    return quantidadeDeVezes;
  }

  public void setQuantidadeDeVezes(int quantidadeDeVezes) {
    this.quantidadeDeVezes = quantidadeDeVezes;
  }

  public int getVezes() {
    return vezes;
  }

  public void setVezes(int vezes) {
    this.vezes = vezes;
  }
}
