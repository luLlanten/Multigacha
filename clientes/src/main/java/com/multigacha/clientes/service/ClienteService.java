package com.multigacha.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multigacha.clientes.client.ContactoClient;
import com.multigacha.clientes.dto.ClienteDTO;
import com.multigacha.clientes.dto.ContactoDTO;
import com.multigacha.clientes.model.Cliente;
import com.multigacha.clientes.repo.ClienteRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepo repo;

    @Autowired
    private ContactoClient contacto;

    public List<Cliente> mostrarClientes() {
        return repo.findAll();
    }

    public Cliente mostrarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente agregarCliente(Cliente cliente) {
        return repo.save(cliente);
    }

    public void borrarClientePorId(Integer id) {
        repo.deleteById(id);
    }

    public Cliente modificarCliente(Integer idCliente, ClienteDTO nuevo) {
        Cliente viejo = repo.findById(idCliente).get();
        ContactoDTO contactoDTO = contacto.buscarDTO(viejo.getIdContacto());
        viejo.setNombre(nuevo.getNombre());
        viejo.setApellido(nuevo.getApellido());
        viejo.setFechNac(nuevo.getFechNac());
        contactoDTO.setCorreo(nuevo.getContacto().getCorreo());
        contactoDTO.setDireccion(nuevo.getContacto().getDireccion());
        contactoDTO.setTelefono(nuevo.getContacto().getTelefono());
        return viejo;
    }

}
