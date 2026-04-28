package cl.catalogo.msCatalogo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.catalogo.msCatalogo.model.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

}
