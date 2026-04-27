package com.multigacha.intercambio.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multigacha.intercambio.model.InterCliente;
import com.multigacha.intercambio.model.Intercambio;

public interface InterClienteRepo extends JpaRepository<InterCliente, Integer> {
    List<InterCliente> findByIdCliente(Integer id);

    Intercambio findIntercambioById(Integer id);

    Integer findIdClienteById(Integer id);
}
