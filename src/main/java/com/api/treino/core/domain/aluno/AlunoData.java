package com.api.treino.core.domain.aluno;

public class AlunoData {
	  private int idade;
	  private Double altura;
	  private Double peso;

	  public AlunoData() {

	  }

	  public AlunoData(int idade, Double altura, Double peso) {
	    this.idade = idade;
	    this.altura = altura;
	    this.peso = peso;
	  }

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
	}
