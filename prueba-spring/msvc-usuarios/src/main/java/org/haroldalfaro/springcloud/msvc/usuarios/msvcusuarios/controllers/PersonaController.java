package org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.controllers;

import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.dto.PersonaDTO;
import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona_juridica")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PersonaDTO personaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.guardar(personaDTO));
    }
}
