package com.cibertec.demo.rest;

import com.cibertec.demo.Services.ITicketServices;
import com.cibertec.demo.model.ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ticketController {

    ITicketServices ticketServices;

    @Autowired
    public ticketController(ITicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }

    @GetMapping("/ticket")
    public List<ticket> getTickets() {
        return ticketServices.obtenerTickets();
    }

    @GetMapping("/ticket/{id}")
    public ticket getTicket(@PathVariable int id) {
        return ticketServices.obtenerTicketid(id);
    }

    @PostMapping("/ticket")
    public ticket addTicket(@RequestBody ticket ticket) {
        return ticketServices.addTicket(ticket);
    }

    @PutMapping("/ticket")
    public ticket updateTicket(@RequestBody ticket ticket) {
        return ticketServices.updateTicket(ticket);
    }

    @GetMapping("/searchTickets")
    public List<ticket> searchTickets(
            @RequestParam int idEstado,
            @RequestParam int tipoFecha,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        return ticketServices.searchTicket(idEstado, tipoFecha, fechaInicio, fechaFin);
    }

}
