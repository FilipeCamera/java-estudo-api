package com.api.treino.infrastructure.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.treino.infrastructure.entities.AlunoEntity;

public interface AlunoRepository extends JpaRepository<AlunoEntity, UUID> {

}
