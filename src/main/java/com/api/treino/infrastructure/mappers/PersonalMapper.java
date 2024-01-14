package com.api.treino.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.personal.Treino;
import com.api.treino.infrastructure.entities.PersonalEntity;

public class PersonalMapper {

  public PersonalEntity toPersonalEntity(UsuarioData usuario, List<Treino> treinos) {
    PersonalEntity personal = new PersonalEntity();

    personal.setNome(usuario.getNome());
    personal.setSobrenome(usuario.getSobrenome());
    personal.setEmail(usuario.getEmail());
    personal.setSenha(usuario.getSenha());

    if (treinos.isEmpty()) {
      personal.setTreinos(new ArrayList<>());
    }

    return personal;
  }

  public Personal toPersonal(PersonalEntity personalEntity) {
    UsuarioData usuario = new UsuarioData();
    List<Treino> treinos = new ArrayList<>();

    usuario.setNome(personalEntity.getNome());
    usuario.setSobrenome(personalEntity.getSobrenome());
    usuario.setEmail(personalEntity.getEmail());

    Personal personal = new Personal(usuario, treinos);


    return personal;
  }
}
