package com.api.treino.infrastructure.mappers;

import org.springframework.stereotype.Component;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.entities.PersonalEntity;

@Component
public class PersonalMapper {

  public static PersonalEntity toPersonalEntity(UsuarioData usuario) {
    PersonalEntity personal = new PersonalEntity(usuario.getId());

    personal.setNome(usuario.getNome());
    personal.setSobrenome(usuario.getSobrenome());
    personal.setEmail(usuario.getEmail());
    personal.setSenha(usuario.getSenha());

    return personal;
  }

  public static Personal toPersonal(PersonalEntity personalEntity) {
    UsuarioData usuario = new UsuarioData(personalEntity.getId(), personalEntity.getNome(),
        personalEntity.getSobrenome(), personalEntity.getEmail(), personalEntity.getSenha());

    Personal personal = new Personal(usuario);

    return personal;
  }
}
