package com.api.treino.infrastructure.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.treino.infrastructure.entities.ExercicioEntity;

public interface ExercicioRepository extends JpaRepository<ExercicioEntity, UUID> {

}
