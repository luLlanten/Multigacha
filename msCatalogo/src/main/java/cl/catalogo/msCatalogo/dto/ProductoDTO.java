package cl.catalogo.msCatalogo.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private String nombre;
    private Double precio;
    private Integer categoriaId;
}