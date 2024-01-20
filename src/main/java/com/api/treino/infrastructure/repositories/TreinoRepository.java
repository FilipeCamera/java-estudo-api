package com.api.treino.infrastructure.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.treino.infrastructure.entities.TreinoEntity;

@Repository
public interface TreinoRepository extends JpaRepository<TreinoEntity, UUID> {

}
