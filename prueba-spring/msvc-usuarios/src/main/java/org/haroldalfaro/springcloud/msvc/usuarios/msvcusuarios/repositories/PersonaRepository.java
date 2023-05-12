package org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.repositories;

import jakarta.persistence.Id;
import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.models.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
}
