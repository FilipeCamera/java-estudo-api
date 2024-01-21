package com.api.treino.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercicios")
public class ExercicioEntity {

  @Column(name = "id", nullable = false)
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = true)
  private String instrucao;

  @Column(nullable = false)
  private Integer carga;

  @Column(nullable = false)
  private Integer serie;

  @Column(nullable = false)
  private Integer repeticao;

  @ManyToOne(cascade = CascadeType.MERGE)
  private PersonalEntity personal;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime criadoEm;

  @UpdateTimestamp
  @Column(nullable = true)
  private LocalDateTime atualizadoEm;

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

  public int getCarga() {
    return carga;
  }

  public void setCarga(int carga) {
    this.carga = carga;
  }

  public int getSerie() {
    return serie;
  }

  public void setSerie(int serie) {
    this.serie = serie;
  }

  public int getRepeticao() {
    return repeticao;
  }

  public void setRepeticao(int repeticao) {
    this.repeticao = repeticao;
  }

  public PersonalEntity getPersonal() {
    return personal;
  }

  public void setPersonal(PersonalEntity personal) {
    this.personal = personal;
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
