package cl.catalogo.msCatalogo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.catalogo.msCatalogo.dto.ModificacionDTO;

@FeignClient(name = "modificacion", url = "")
public interface ModificacionClient {
    @GetMapping("api/v1/modificacion/{id}")
    ModificacionDTO buscarDTO(Integer id);

}
