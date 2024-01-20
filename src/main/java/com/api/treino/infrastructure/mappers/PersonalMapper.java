package com.api.treino.infrastructure.mappers;

import org.springframework.stereotype.Component;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.entities.PersonalEntity;

@Component
public class PersonalMapper {

  public PersonalEntity toPersonalEntity(UsuarioData usuario) {
    PersonalEntity personal = new PersonalEntity();

    personal.setNome(usuario.getNome());
    personal.setSobrenome(usuario.getSobrenome());
    personal.setEmail(usuario.getEmail());
    personal.setSenha(usuario.getSenha());

    return personal;
  }

  public Personal toPersonal(PersonalEntity personalEntity) {
    UsuarioData usuario = new UsuarioData(personalEntity.getNome(), personalEntity.getSobrenome(),
        personalEntity.getEmail(), null);

    Personal personal = new Personal(usuario);

    return personal;
  }
}
