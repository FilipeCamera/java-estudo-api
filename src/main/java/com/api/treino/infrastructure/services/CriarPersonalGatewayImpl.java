package com.api.treino.infrastructure.services;

import java.util.List;
import com.api.treino.application.gateway.CriarPersonalGateway;
import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.personal.Treino;
import com.api.treino.infrastructure.entities.PersonalEntity;
import com.api.treino.infrastructure.mappers.PersonalMapper;
import com.api.treino.infrastructure.repositories.PersonalRepository;

public class CriarPersonalGatewayImpl implements CriarPersonalGateway {
  private PersonalRepository personalRepository;
  private PersonalMapper personalMapper;

  public CriarPersonalGatewayImpl(PersonalRepository personalRepository,
      PersonalMapper personalMapper) {
    this.personalRepository = personalRepository;
    this.personalMapper = personalMapper;
  }

  @Override
  public Personal criar(UsuarioData usuario, List<Treino> treinos) {

    PersonalEntity personalEntity = this.personalMapper.toPersonalEntity(usuario, treinos);

    PersonalEntity personalResponse = this.personalRepository.save(personalEntity);

    return this.personalMapper.toPersonal(personalResponse);
  }

}
