package com.api.trainning.core.domain.Personal;

import java.util.List;
import com.api.trainning.core.domain.UsuarioData;

public record Personal(UsuarioData usuario, List<Treino> treinos) {

}
