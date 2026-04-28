package cl.catalogo.msCatalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.catalogo.msCatalogo.Service.CatalogoService;
import cl.catalogo.msCatalogo.dto.ProductoDTO;
import cl.catalogo.msCatalogo.model.Categoria;
import cl.catalogo.msCatalogo.model.Producto;

@RestController
@RequestMapping("/api/v1/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService service;

    @PostMapping("/expansion")
    public ResponseEntity<Categoria> crearExpansion(@RequestBody Categoria categoria) {
        try {
            return ResponseEntity.ok(service.guardarExpansion(categoria));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/carta")
    public ResponseEntity<Producto> agregarCarta(@RequestBody ProductoDTO dto) {
        try {
            Producto producto = service.agregarCarta(dto);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todo")
    public ResponseEntity<List<Categoria>> listarTodo() {
        List<Categoria> lista = service.obtenerTodo();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }

}
