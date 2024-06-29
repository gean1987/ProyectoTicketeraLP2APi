package com.cibertec.demo.Services.Impl;
import com.cibertec.demo.model.tipoConsulta;
import com.cibertec.demo.model.usuario;
import com.cibertec.demo.repository.IUsuarioRepository;
import com.cibertec.demo.Services.IUsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices implements IUsuarioServices {
    IUsuarioRepository _dataRepository;

    @Autowired
    public UsuarioServices(IUsuarioRepository dataRepository) {
        _dataRepository = dataRepository;
    }

    @Override
    public List<usuario> listarUsuarios() {
        return _dataRepository.findAll();
    }

    @Override
    public usuario crearUsuario(usuario entity) {
        usuario dataSaved = _dataRepository.save(entity);
        return dataSaved;     }

    @Override
    public usuario actualizarUsuario(usuario entity) {
        Optional<usuario> rowInDB = _dataRepository.findById(entity.getIdUsuario());
        if(rowInDB.isPresent()) {
            usuario dataToUpdate = rowInDB.get();
            //
            dataToUpdate.setNombre(entity.getNombre());
            dataToUpdate.setApellido(entity.getApellido());
            dataToUpdate.setCorreo(entity.getCorreo());
            dataToUpdate.setContraseña(entity.getContraseña());
            dataToUpdate.setRol(entity.getRol());

            return _dataRepository.save(dataToUpdate);
        }
        else{
            return new usuario();
        }      }

    @Override
    public usuario BuscarUsuario(int id) {
        Optional<usuario> rowInDB =_dataRepository.findById(id);
        if(rowInDB.isPresent())
            return rowInDB.get();
        else
            return new usuario();       }

    @Override
    public usuario EliminarUsuario(int id) {
        Optional<usuario> rowInDB = _dataRepository.findById(id);
        if (rowInDB.isPresent()) {
            usuario dataToDelete = rowInDB.get();
            _dataRepository.delete(dataToDelete);
            return dataToDelete;
        } else {
            //
            return new usuario();
        }         }

    @Override
    public List<usuario> BuscarUsuarioNombre(String nombre) {
        return _dataRepository.findByNombre(nombre);
    }
    @Override
    public List<usuario> BuscarUsuarioRol(String rol) {
        return _dataRepository.findByRol(rol);
    }

    @Override
    public List<usuario> BuscarUsuarioCorreoContrasena(String correo, String contrasena) {
        return _dataRepository.findByCorreoAndContraseña(correo ,contrasena);
    }


}
