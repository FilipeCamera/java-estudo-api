package com.api.trainning.domain.entities;

import java.util.List;

public record Personal(UsuarioData usuario, List<Treino> treinos) {

}
