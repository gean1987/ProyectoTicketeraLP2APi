package com.cibertec.demo.Services.Impl;
import com.cibertec.demo.model.ticket;
import com.cibertec.demo.repository.IEquipoRepository;
import com.cibertec.demo.Services.IEquipoServices;
import com.cibertec.demo.model.equipo;

import com.cibertec.demo.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EquipoServices implements IEquipoServices {

    IEquipoRepository _equipoRepository;

    @Autowired
    public EquipoServices(IEquipoRepository equipoRepository) {
        _equipoRepository = equipoRepository;
    }

    @Override
    public List<equipo> listarequipo() {
        return _equipoRepository.findAll();
    }

    @Override
    public equipo crearequipo(equipo entity) {
        equipo equipoSaved = _equipoRepository.save(entity);
        return equipoSaved;

    }

    @Override
    public equipo actualizarequipo(equipo entity) {
        Optional<equipo> rowInDB = _equipoRepository.findById(entity.getIdEquipo());
        if(rowInDB.isPresent()) {
            equipo dataToUpdate = rowInDB.get();
            //
            dataToUpdate.setDescripcion(entity.getDescripcion());

            return _equipoRepository.save(dataToUpdate);
        }
        else{
            return new equipo();
        }
    }

    @Override
    public equipo Buscarequipo(int id) {
        Optional<equipo> rowInDB =_equipoRepository.findById(id);
        if(rowInDB.isPresent())
            return rowInDB.get();
        else
            return new equipo();
    }

    @Override
    public equipo Eliminarequipo(int id) {
        Optional<equipo> rowInDB = _equipoRepository.findById(id);
        if (rowInDB.isPresent()) {
            equipo dataToDelete = rowInDB.get();
            _equipoRepository.delete(dataToDelete);
            return dataToDelete;
        } else {
            //
            return new equipo();
        }
    }
}
