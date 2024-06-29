package com.cibertec.demo.repository;
import  com.cibertec.demo.model.equipo;
import com.cibertec.demo.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IEquipoRepository  extends  JpaRepository<equipo,Integer> {
}
