package com.api.treino.core.domain.personal;

public class Exercicio {
	  private String nome;
	  private String instrucao;
	  private int repeticao;
	  private int serie;
	  private int carga;

	  public Exercicio(String nome, String instrucao, int repeticao, int serie, int carga) {
	    this.nome = nome;
	    this.instrucao = instrucao;
	    this.repeticao = repeticao;
	    this.serie = serie;
	    this.carga = carga;
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
	}
