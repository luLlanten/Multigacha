package com.multigacha.intercambio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multigacha.intercambio.client.ClienteClient;
import com.multigacha.intercambio.dto.ClienteDTO;
import com.multigacha.intercambio.dto.InterClienteDTO;
import com.multigacha.intercambio.dto.IntercambioDTO;
import com.multigacha.intercambio.model.InterCliente;
import com.multigacha.intercambio.model.Intercambio;
import com.multigacha.intercambio.repo.InterClienteRepo;
import com.multigacha.intercambio.repo.IntercambioRepo;

@Service
public class IntercambioService {
    @Autowired
    private IntercambioRepo repo1;
    @Autowired
    private InterClienteRepo repo2;
    @Autowired
    private ClienteClient cliente;

    public List<Intercambio> listarIntercambios() {
        return repo1.findAll();
    }

    public List<InterCliente> listarIntercambiosPorCliente(Integer idCliente) {
        ClienteDTO clienteDTO = cliente.buscarDTO(idCliente);
        List<InterCliente> lista = repo2.findByIdCliente(clienteDTO.getId());
        return lista;
    }

    public Intercambio buscarIntercambioPorInterCliente(Integer id) {// desde cliente
        return repo2.findIntercambioById(id);
    }

    public Intercambio buscarIntercambioPorIntercambio(Integer id) {// desde empleado
        return repo1.findById(id).get();
    }

    public Intercambio crearIntercambio(Intercambio intercambio) {
        // para poder crear un intercambio entre clientes es necesario
        // crear una entidad "ProductoPropio" que sea del cliente o algo asi
        // de tal forma que cada ciente tenga su inventario, se debera hacer en
        // el API de Cliente, ya que es un inventario propio de cada Cliente creado
        return repo1.save(intercambio);
    }

    public InterClienteDTO detalleIntercambio(Integer id) {
        ClienteDTO clienteDTO = cliente.buscarDTO(repo2.findIdClienteById(id));
        Intercambio intercambio = repo2.findIntercambioById(id);
        IntercambioDTO intercambioDTO = new IntercambioDTO(intercambio.getId(), intercambio.getFecha(),
                intercambio.isEstadoInter());
        InterClienteDTO detalle = new InterClienteDTO();
        detalle.setId(id);
        detalle.setClienteId(clienteDTO);
        detalle.setIntercambioId(intercambioDTO);
        return detalle;
    }

}
