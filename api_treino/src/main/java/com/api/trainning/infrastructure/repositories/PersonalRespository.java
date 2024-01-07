package com.api.trainning.infrastructure.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.trainning.infrastructure.entities.PersonalEntity;

public interface PersonalRespository extends JpaRepository<PersonalEntity, UUID> {

}
