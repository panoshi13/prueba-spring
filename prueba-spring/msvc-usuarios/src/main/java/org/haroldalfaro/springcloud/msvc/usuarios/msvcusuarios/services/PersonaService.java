package org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.services;

import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.dto.PersonaDTO;
import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.models.entity.Persona;


public interface PersonaService {
    Persona guardar(PersonaDTO persona);
}
