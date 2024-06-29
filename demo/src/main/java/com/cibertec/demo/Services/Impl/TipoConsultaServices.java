package com.cibertec.demo.Services.Impl;
import com.cibertec.demo.model.equipo;
import com.cibertec.demo.model.tipoConsulta;
import com.cibertec.demo.repository.IEquipoRepository;
import com.cibertec.demo.repository.ITipoConsultaRepository;
import com.cibertec.demo.Services.ITipoConsultaServices;

import com.cibertec.demo.repository.ITipoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TipoConsultaServices implements ITipoConsultaServices {

    ITipoConsultaRepository _dataRepository;

    @Autowired
    public TipoConsultaServices(ITipoConsultaRepository dataRepository) {
        _dataRepository = dataRepository;
    }

    @Override
    public List<tipoConsulta> listartipoConsulta() {
        return _dataRepository.findAll();
    }

    @Override
    public tipoConsulta creartipoConsulta(tipoConsulta entity) {
        tipoConsulta dataSaved = _dataRepository.save(entity);
        return dataSaved;
    }

    @Override
    public tipoConsulta actualizartipoConsulta(tipoConsulta entity) {
        Optional<tipoConsulta> rowInDB = _dataRepository.findById(entity.getIdTipoConsulta());
        if(rowInDB.isPresent()) {
            tipoConsulta dataToUpdate = rowInDB.get();
            //
            dataToUpdate.setDescripcion(entity.getDescripcion());

            return _dataRepository.save(dataToUpdate);
        }
        else{
            return new tipoConsulta();
        }
    }

    @Override
    public tipoConsulta BuscartipoConsulta(int id) {
        Optional<tipoConsulta> rowInDB =_dataRepository.findById(id);
        if(rowInDB.isPresent())
            return rowInDB.get();
        else
            return new tipoConsulta();
    }

    @Override
    public tipoConsulta EliminartipoConsulta(int id) {
        Optional<tipoConsulta> rowInDB = _dataRepository.findById(id);
        if (rowInDB.isPresent()) {
            tipoConsulta dataToDelete = rowInDB.get();
            _dataRepository.delete(dataToDelete);
            return dataToDelete;
        } else {
            //
            return new tipoConsulta();
        }       }
}
