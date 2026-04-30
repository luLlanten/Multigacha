package com.multigacha.modificacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multigacha.modificacion.client.ContactoClient;
import com.multigacha.modificacion.client.ProductoClient;
import com.multigacha.modificacion.model.Empleado;
import com.multigacha.modificacion.model.Modificacion;
import com.multigacha.modificacion.repo.EmpleadoRepo;
import com.multigacha.modificacion.repo.ModificacionRepo;

@Service
public class ModificacionService {
    @Autowired
    private EmpleadoRepo repo1;
    @Autowired
    private ModificacionRepo repo2;
    @Autowired
    private ContactoClient cliente;
    @Autowired
    private ProductoClient producto;

    public List<Empleado> listarEmpleados() {
        return repo1.findAll();
    }

    public List<Modificacion> listarModificaciones() {
        return repo2.findAll();
    }

}
