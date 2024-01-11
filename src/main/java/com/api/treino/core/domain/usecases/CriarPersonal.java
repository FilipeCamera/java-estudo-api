package com.api.treino.core.domain.usecases;

import java.util.List;

import com.api.treino.core.domain.UsuarioData;
import com.api.treino.core.domain.personal.Personal;
import com.api.treino.core.domain.personal.Treino;

public interface CriarPersonal {
	  Personal exec(UsuarioData usuario, List<Treino> treinos) throws Exception;
}
