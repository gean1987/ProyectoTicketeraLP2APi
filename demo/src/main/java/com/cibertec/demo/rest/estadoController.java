package com.cibertec.demo.rest;
import com.cibertec.demo.Services.IEstadoServices;
import com.cibertec.demo.model.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class estadoController {
    IEstadoServices estadoServices;

    @Autowired
    public estadoController(IEstadoServices estadoServices) {
        this.estadoServices = estadoServices;
    }

    @GetMapping("/estado")
    public List<estado> getEstados() {
        return estadoServices.listarestado();
    }
}
