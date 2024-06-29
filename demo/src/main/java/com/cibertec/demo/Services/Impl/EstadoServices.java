package com.cibertec.demo.Services.Impl;
import com.cibertec.demo.repository.IEstadoRepository;

import com.cibertec.demo.Services.IEstadoServices;
import com.cibertec.demo.model.estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServices implements IEstadoServices {
    IEstadoRepository _dataRepository;

    @Autowired
    public EstadoServices(IEstadoRepository dataRepository) {
        _dataRepository = dataRepository;
    }

    @Override
    public List<estado> listarestado() {
        return _dataRepository.findAll();
    }
}
