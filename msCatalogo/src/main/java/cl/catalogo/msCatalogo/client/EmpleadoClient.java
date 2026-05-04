package cl.catalogo.msCatalogo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.catalogo.msCatalogo.dto.EmpleadoDTO;

@FeignClient(name = "empleado", url = "")
public interface EmpleadoClient {
    @GetMapping("api/v1/empleado/{id}")
    EmpleadoDTO buscarDTO(Integer id);

}
