package cl.catalogo.msCatalogo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.catalogo.msCatalogo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

}
