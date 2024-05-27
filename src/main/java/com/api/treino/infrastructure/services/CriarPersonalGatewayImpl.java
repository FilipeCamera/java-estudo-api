package com.api.treino.infrastructure.services;

import com.api.treino.application.gateway.ICriarPersonalGateway;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.entities.PersonalEntity;
import com.api.treino.infrastructure.mappers.PersonalMapper;
import com.api.treino.infrastructure.repositories.PersonalRepository;

public class CriarPersonalGatewayImpl implements ICriarPersonalGateway {
  private PersonalRepository personalRepository;

  public CriarPersonalGatewayImpl(PersonalRepository personalRepository) {
    this.personalRepository = personalRepository;
  }

  @Override
  public Personal criar(UsuarioData usuario) {

    PersonalEntity personalEntity = PersonalMapper.toPersonalEntity(usuario);

    PersonalEntity personalResponse = this.personalRepository.save(personalEntity);

    return PersonalMapper.toPersonal(personalResponse);
  }

}
