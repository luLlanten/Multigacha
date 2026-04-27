package com.multigacha.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multigacha.clientes.model.Cliente;
import com.multigacha.clientes.repo.ClienteRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepo repo;

    public List<Cliente> mostrarClientes() {
        return repo.findAll();
    }

    public Cliente mostrarPorId(Long id) {
        if (repo.findById(id) != null) {
            return repo.findById(id).get();
        } else {
            return null;
        }
    }

    public Cliente agregarCliente(Cliente cliente) {
        return repo.save(cliente);
    }

    public void borrarClientePorId(Long id) {
        repo.deleteById(id);
    }

    public Cliente modificarCliente(Long id, Cliente nuevo) {
        Cliente viejo = repo.findById(id).get();
        viejo.setNombre(nuevo.getNombre());
        viejo.setApellido(nuevo.getApellido());
        viejo.setCorreo(nuevo.getCorreo());
        viejo.setDireccion(nuevo.getDireccion());
        viejo.setTelefono(nuevo.getTelefono());
        viejo.setFech_nac(nuevo.getFech_nac());
        return viejo;
    }
}
