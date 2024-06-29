package com.cibertec.demo.repository;
import com.cibertec.demo.model.ticket;
import  com.cibertec.demo.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IUsuarioRepository  extends  JpaRepository<usuario,Integer> {
    List<usuario> findByRol(String rol);
    List<usuario> findByNombre(String nombre);
    List<usuario> findByCorreoAndContraseña(String correo, String contraseña);

}
