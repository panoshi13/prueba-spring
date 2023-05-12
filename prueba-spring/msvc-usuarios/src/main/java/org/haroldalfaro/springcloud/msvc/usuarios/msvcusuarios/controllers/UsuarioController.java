package org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.controllers;

import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.models.entity.Usuario;
import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Usuario> optionalUsuario = usuarioService.porId(id);
        if (optionalUsuario.isPresent())
            return ResponseEntity.ok(optionalUsuario.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Usuario usuario,@PathVariable Long id){
        Optional<Usuario> o = usuarioService.porId(id);
        if (o.isPresent()){
            Usuario usuario1 = o.get();
            usuario1.setNombre(usuario.getNombre());
            usuario1.setEmail(usuario.getEmail());
            usuario1.setPassword(usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuario1));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Usuario> o = usuarioService.porId(id);
        if (o.isPresent()){
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
