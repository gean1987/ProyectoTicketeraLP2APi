package com.cibertec.demo.Services;
import com.cibertec.demo.model.ticket;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
public interface ITicketServices {
    List<ticket> obtenerTickets();
    ticket obtenerTicketid(int id);
    ticket addTicket(ticket ticket);
    ticket updateTicket(ticket ticket);
    List<ticket> searchTicket(int idEstado,  int tipoFecha, Date fechainicio, Date fechafin);

}
