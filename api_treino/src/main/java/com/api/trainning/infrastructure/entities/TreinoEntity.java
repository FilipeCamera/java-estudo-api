package com.api.trainning.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "treinos")
public class TreinoEntity {

  @Column(nullable = false, name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToMany(mappedBy = "treino")
  private List<ExercicioEntity> exercicios;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id", referencedColumnName = "id")
  private AlunoEntity aluno;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personal_id", referencedColumnName = "id")
  private PersonalEntity personal;

  @Column(nullable = false, name = "created_at")
  private LocalDateTime criadoEm;

  @Column(name = "updated_at")
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

  public AlunoEntity getAluno() {
    return aluno;
  }

  public void setAluno(AlunoEntity aluno) {
    this.aluno = aluno;
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
