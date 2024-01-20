package com.api.treino.infrastructure.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.treino.infrastructure.entities.ExercicioEntity;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, UUID> {

}
