package com.multigacha.modificacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.multigacha.modificacion.dto.ProductoDTO;

@FeignClient(name = "producto", url = "http://localhost:3308")
public interface ProductoClient {
    @GetMapping("api/v1/productos/{id}")
    ProductoDTO buscarDTO(@PathVariable("id") Integer id);

    @PutMapping("api/v1/productos/mod")
    void mandarModificacion(@RequestBody ProductoDTO productoDTO);
}
