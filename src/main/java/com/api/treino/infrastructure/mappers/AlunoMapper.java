package com.api.treino.infrastructure.mappers;

import org.springframework.stereotype.Component;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.aluno.Aluno;
import com.api.treino.core.domain.aluno.AlunoData;
import com.api.treino.infrastructure.entities.AlunoEntity;

@Component
public class AlunoMapper {

  public AlunoEntity toAlunoEntity(UsuarioData usuario, AlunoData info) {
    AlunoEntity aluno = new AlunoEntity();

    aluno.setNome(usuario.getNome());
    aluno.setSobrenome(usuario.getSobrenome());
    aluno.setEmail(usuario.getEmail());
    aluno.setSenha(usuario.getSenha());
    aluno.setIdade(info.getIdade());
    aluno.setAltura(info.getAltura());
    aluno.setPeso(info.getPeso());

    return aluno;
  }

  public Aluno toAluno(AlunoEntity alunoEntity) {
    UsuarioData usuario = new UsuarioData(alunoEntity.getNome(), alunoEntity.getSobrenome(),
        alunoEntity.getEmail(), null);
    AlunoData info =
        new AlunoData(alunoEntity.getIdade(), alunoEntity.getAltura(), alunoEntity.getPeso());

    Aluno aluno = new Aluno(usuario, info);

    return aluno;
  }
}
