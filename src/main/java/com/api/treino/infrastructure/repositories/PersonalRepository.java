package com.api.treino.infrastructure.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.treino.infrastructure.entities.PersonalEntity;

public interface PersonalRepository extends JpaRepository<PersonalEntity, UUID> {

}
