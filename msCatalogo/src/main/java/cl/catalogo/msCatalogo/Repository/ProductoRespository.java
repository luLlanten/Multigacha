package cl.catalogo.msCatalogo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.catalogo.msCatalogo.model.Producto;
@Repository
public interface ProductoRespository extends JpaRepository <Producto,Integer>{

}
