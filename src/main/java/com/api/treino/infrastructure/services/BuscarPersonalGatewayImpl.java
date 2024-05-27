package com.api.treino.infrastructure.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.api.treino.application.gateway.IBuscarPersonalGateway;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.infrastructure.entities.PersonalEntity;
import com.api.treino.infrastructure.mappers.PersonalMapper;
import com.api.treino.infrastructure.repositories.PersonalRepository;

public class BuscarPersonalGatewayImpl implements IBuscarPersonalGateway {

  private PersonalRepository personalRepository;

  public BuscarPersonalGatewayImpl(PersonalRepository personalRepository) {
    this.personalRepository = personalRepository;
  }

  @Override
  public Personal buscar(UUID id) {
    Optional<PersonalEntity> personal = this.personalRepository.findById(id);
    return PersonalMapper.toPersonal(personal.get());
  }

  @Override
  public List<Personal> buscar() {
    List<PersonalEntity> personalsEntity = this.personalRepository.findAll();

    List<Personal> personals = new ArrayList<>();

    for (PersonalEntity personalEntity : personalsEntity) {
      personals.add(PersonalMapper.toPersonal(personalEntity));
    }
    // TODO Auto-generated method stub
    return personals;
  }

}
