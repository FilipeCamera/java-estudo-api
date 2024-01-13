package com.api.treino.infrastructure.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.treino.infrastructure.entities.TreinoEntity;

public interface TreinoRepository extends JpaRepository<TreinoEntity, UUID> {

}
