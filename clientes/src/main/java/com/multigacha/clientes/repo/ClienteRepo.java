package com.multigacha.clientes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multigacha.clientes.model.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {

}
