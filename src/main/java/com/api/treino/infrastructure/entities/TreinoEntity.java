package com.api.treino.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

public class TreinoEntity {

  @Column(nullable = false)
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToMany(mappedBy = "treinos")
  private List<ExercicioEntity> exercicios;

  @ManyToOne
  @JoinColumn(name = "personalId", nullable = false)
  private PersonalEntity personal;

  @OneToOne
  @MapsId
  @JoinColumn(name = "alunoId")
  private AlunoEntity aluno;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime criadoEm;

  @UpdateTimestamp
  @Column(nullable = true)
  private LocalDateTime atualizadoEm;

  public UUID getId() {
    return id;
  }

  public List<ExercicioEntity> getExercicios() {
    return exercicios;
  }

  public void setExercicios(List<ExercicioEntity> exercicios) {
    this.exercicios = exercicios;
  }

  public PersonalEntity getPersonal() {
    return personal;
  }

  public void setPersonal(PersonalEntity personal) {
    this.personal = personal;
  }

  public AlunoEntity getAluno() {
    return aluno;
  }

  public void setAluno(AlunoEntity aluno) {
    this.aluno = aluno;
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
