package com.cibertec.demo.repository;

import com.cibertec.demo.model.ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ITicketRepository extends JpaRepository<ticket, Integer> {
    List<ticket> findByIdEstadoAndFechaGeneracionBetween(int idEstado, Date fechaInicio, Date fechaFin);

    List<ticket> findByIdEstadoAndFechaAsignacionBetween(int idEstado, Date fechaInicio, Date fechaFin);

    List<ticket> findByIdEstadoAndFechaCierreBetween(int idEstado, Date fechaInicio, Date fechaFin);
}
