package com.api.treino.infrastructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.treino.infrastructure.entities.ExercicioEntity;
import com.api.treino.infrastructure.entities.PersonalEntity;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, UUID> {
  Optional<ExercicioEntity> findByPersonalAndId(PersonalEntity personal, UUID id);

  List<ExercicioEntity> findByPersonal(PersonalEntity personal);
}
