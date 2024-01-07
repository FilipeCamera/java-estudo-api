package com.api.trainning.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercicios")
public class ExercicioEntity {

  @Column(nullable = false, name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "treino_id", referencedColumnName = "id")
  private TreinoEntity treino;

  @Column(nullable = false, name = "name")
  private String nome;

  @Column(nullable = true, name = "instruction")
  private String instrucao;

  @Column(nullable = false, name = "repetition")
  private int repeticao;

  @Column(nullable = false, name = "serie")
  private int serie;

  @Column(nullable = false, name = "weight")
  private int carga;

  @Column(nullable = false, name = "created_at")
  private LocalDateTime criadoEm;

  @Column(name = "updated_at")
  private LocalDateTime atualizadoEm;

  public UUID getId() {
    return id;
  }

  public TreinoEntity getTreino() {
    return treino;
  }

  public void setTreino(TreinoEntity treino) {
    this.treino = treino;
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
    this.repeticao = repeticao;
  }

  public int getSerie() {
    return serie;
  }

  public void setSerie(int serie) {
    this.serie = serie;
  }

  public int getCarga() {
    return carga;
  }

  public void setCarga(int carga) {
    this.carga = carga;
  }

  public LocalDateTime getCriadoEm() {
    return criadoEm;
  }

  public void setCriadoEm(LocalDateTime criadoEm) {
    this.criadoEm = criadoEm;
  }

  public LocalDateTime getAtualizadoEm() {
    return atualizadoEm;
  }

  public void setAtualizadoEm(LocalDateTime atualizadoEm) {
    this.atualizadoEm = atualizadoEm;
  }
}
