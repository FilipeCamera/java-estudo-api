package com.api.treino.core.domain.personal;

import java.util.List;

import com.api.treino.core.domain.UsuarioData;

public record Personal(UsuarioData usuario, List<Treino> treinos) {

}
