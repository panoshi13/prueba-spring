package org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.api.client;

import org.haroldalfaro.springcloud.msvc.usuarios.msvcusuarios.dto.RucResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RucServicioCliente", url = "http://wsruc.com")
public interface RucServicioCliente {

    @GetMapping("/Ruc2WS_JSON.php?tipo={tipo}&ruc={ruc}&token={token}")
    RucResponseDTO obtenerRuc(@PathVariable("tipo") String tipo, @PathVariable("ruc") String ruc, @PathVariable("token") String token);
}
