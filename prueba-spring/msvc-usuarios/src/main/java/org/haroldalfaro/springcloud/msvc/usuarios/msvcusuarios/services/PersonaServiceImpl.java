package org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.services;

import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.api.client.RucServicioCliente;
import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.dto.PersonaDTO;
import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.models.entity.Persona;
import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    private  RucServicioCliente rucServicioCliente;

    public PersonaServiceImpl(@Autowired(required = false) RucServicioCliente rucServicioCliente) {
        this.rucServicioCliente = rucServicioCliente;
    }

    private static final String token="cXdlcnR5bGFtYXJja19zYUBob3RtYWlsLmNvbXF3ZXJ0eQ==";

    @Override
    @Transactional
    public Persona guardar(PersonaDTO personaDTO) {
        var rucResponseDTO = rucServicioCliente.obtenerRuc(personaDTO.getTipo(),personaDTO.getRuc(),token);
        Persona persona = new Persona();
        persona.setDepartamento(rucResponseDTO.getDepartamento());
        persona.setDireccion(rucResponseDTO.getDireccion());
        persona.setDistrito(rucResponseDTO.getDistrito());
        persona.setEstado(rucResponseDTO.getEstado());
        persona.setRazon_social(rucResponseDTO.getRazon_social());
        persona.setRuc(rucResponseDTO.getRuc());
        persona.setUbigeo(rucResponseDTO.getUbigeo());
        persona.setProvincia(rucResponseDTO.getProvincia());
        return personaRepository.save(persona);
    }

}
