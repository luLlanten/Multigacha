package cl.catalogo.msCatalogo.Service;

import cl.catalogo.msCatalogo.Repository.CategoriaRepository;
import cl.catalogo.msCatalogo.Repository.ProductoRespository;
import cl.catalogo.msCatalogo.dto.ProductoDTO;
import cl.catalogo.msCatalogo.model.Categoria;
import cl.catalogo.msCatalogo.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoService {

    @Autowired
    private CategoriaRepository repo1;

    @Autowired
    private ProductoRespository repo2;

    public Categoria guardarExpansion(Categoria categoria) {
        if (categoria.getProductos() != null) {
            categoria.getProductos().forEach(p -> p.setCategoria(categoria));
        }
        return repo1.save(categoria);
    }

    public Producto agregarCarta(ProductoDTO dto) {
        Categoria categoria = repo1.findById(dto.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Producto nuevo = new Producto();
        nuevo.setNombre(dto.getNombre());
        nuevo.setPrecio(dto.getPrecio());
        nuevo.setCategoria(categoria);

        return repo2.save(nuevo);
    }

    public List<Categoria> obtenerTodo() {
        return repo1.findAll();
    }
}