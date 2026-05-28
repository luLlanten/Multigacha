package com.multigacha.intercambio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.multigacha.intercambio.dto.ProductoDTO;

@FeignClient(name = "catalogo", url = "http://localhost:8081/api/v1/catalogo")
public interface ProductoClient {
    @GetMapping("/{id}")
    ProductoDTO buscarDTO(@PathVariable("id") Integer id);
}
