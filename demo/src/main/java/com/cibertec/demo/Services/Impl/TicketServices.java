package com.cibertec.demo.Services.Impl;

import com.cibertec.demo.repository.ITicketRepository;
import com.cibertec.demo.Services.ITicketServices;
import com.cibertec.demo.model.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServices implements ITicketServices {

    ITicketRepository _ticketRepository;

    @Autowired
    public TicketServices(ITicketRepository ticketRepository) {
        _ticketRepository = ticketRepository;
    }

    @Override
    public List<ticket> obtenerTickets() {
        return _ticketRepository.findAll();
    }

    @Override
    public ticket obtenerTicketid(int id) {
        Optional<ticket> rowInDB = _ticketRepository.findById(id);
        return rowInDB.orElseGet(ticket::new);
    }

    @Override
    public ticket addTicket(ticket ticket) {
        return _ticketRepository.save(ticket);
    }

    public ticket updateTicket(ticket ticket) {
        Optional<ticket> rowInDB = _ticketRepository.findById(ticket.getIdTicket());
        if (rowInDB.isPresent()) {
            ticket ticketToUpdate = rowInDB.get();
            // Actualiza todos los campos necesarios
            ticketToUpdate.setFechaGeneracion(ticket.getFechaGeneracion());
            ticketToUpdate.setAsunto(ticket.getAsunto());
            ticketToUpdate.setEquipo(ticket.getEquipo());
            ticketToUpdate.setTipoConsulta(ticket.getTipoConsulta());
            ticketToUpdate.setFechaAsignacion(ticket.getFechaAsignacion());
            ticketToUpdate.setCorreoEmisor(ticket.getCorreoEmisor());
            ticketToUpdate.setCorreoReceptor(ticket.getCorreoReceptor());
            ticketToUpdate.setIdEstado(ticket.getIdEstado());
            ticketToUpdate.setFechaCierre(ticket.getFechaCierre());
            ticketToUpdate.setCuerpoTicket(ticket.getCuerpoTicket());
            ticketToUpdate.setRespuestaTicket(ticket.getRespuestaTicket());
            return _ticketRepository.save(ticketToUpdate);
        } else {
            return new ticket();
        }
    }

    @Override
    public List<ticket> searchTicket(int idEstado, int tipoFecha, Date fechaInicio, Date fechaFin) {
        switch (tipoFecha) {
            case 1:
                return _ticketRepository.findByIdEstadoAndFechaGeneracionBetween(idEstado, fechaInicio, fechaFin);
            case 2:
                return _ticketRepository.findByIdEstadoAndFechaAsignacionBetween(idEstado, fechaInicio, fechaFin);
            case 3:
                return _ticketRepository.findByIdEstadoAndFechaCierreBetween(idEstado, fechaInicio, fechaFin);
            default:
                return _ticketRepository.findByIdEstadoAndFechaGeneracionBetween(idEstado, fechaInicio, fechaFin);
        }
    }
}
