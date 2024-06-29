package com.cibertec.demo.repository;
import  com.cibertec.demo.model.tipoConsulta;
import com.cibertec.demo.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ITipoConsultaRepository  extends  JpaRepository<tipoConsulta,Integer> {
}
