package cl.catalogo.msCatalogo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.catalogo.msCatalogo.model.Producto;

public interface ProductoRespository extends JpaRepository <Producto,Integer>{

}
