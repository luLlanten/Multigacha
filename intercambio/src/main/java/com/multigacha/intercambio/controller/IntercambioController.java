package com.multigacha.intercambio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multigacha.intercambio.model.Intercambio;
import com.multigacha.intercambio.model.ProductoCliente;
import com.multigacha.intercambio.service.IntercambioService;

@RestController
@RequestMapping("/api/v1/intercambios")
public class IntercambioController {
    @Autowired
    private IntercambioService service;

    @GetMapping
    public ResponseEntity<List<Intercambio>> listarIntercambios() {
        List<Intercambio> lista = service.listarIntercambios();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/inventarios")
    public ResponseEntity<List<ProductoCliente>> listarInventarios() {
        List<ProductoCliente> lista = service.listarInventarios();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/inventarios/{id}")
    public List<ProductoCliente> listarInventariosPorCliente(@PathVariable Integer id) {
        return service.listarInventariosPorCliente(id);
    }

    @GetMapping("/inventarios/producto/{id}")
    public ProductoCliente getInventario(@PathVariable Integer id) {
        return service.mostrarInventarioPorProducto(id);
    }

}
