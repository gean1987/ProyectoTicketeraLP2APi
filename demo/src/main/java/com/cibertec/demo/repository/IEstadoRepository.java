package com.cibertec.demo.repository;
import  com.cibertec.demo.model.estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoRepository extends  JpaRepository<estado,Integer> {
}
