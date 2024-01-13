package com.api.treino.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

public class AlunoEntity {

  @Column(name = "id", nullable = false)
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String sobrenome;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String senha;

  @Column(nullable = false)
  private int idade;

  @Column(nullable = false)
  private Double peso;

  @Column(nullable = false)
  private Double altura;

  @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private TreinoEntity treino;

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

  public TreinoEntity getTreino() {
    return treino;
  }

  public void setTreino(TreinoEntity treino) {
    this.treino = treino;
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
