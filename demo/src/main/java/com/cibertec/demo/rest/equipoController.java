package com.cibertec.demo.rest;
import com.cibertec.demo.Services.IEquipoServices;
import com.cibertec.demo.model.equipo;
import com.cibertec.demo.Services.Impl.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class equipoController {

    IEquipoServices dataServices;

    @Autowired
    public equipoController(IEquipoServices dataServices) {
        this.dataServices=dataServices;
    }

    @GetMapping("/equipo")
    public List<equipo> getAll() {
        return dataServices.listarequipo();
    }

    @GetMapping("/equipo/{id}")
    public equipo getAll(@PathVariable int id) {
        return dataServices.Buscarequipo(id);
    }

    @PostMapping("/equipo")
    public equipo savePet(@RequestBody equipo entity) {
        return dataServices.crearequipo(entity);
    }

    @PutMapping("/equipo")
    public equipo updatePet(@RequestBody equipo entity) {
        return dataServices.actualizarequipo(entity);
    }

    @DeleteMapping("/equipo/{id}")
    public equipo deletePetById(@PathVariable int id) {
        return dataServices.Eliminarequipo(id);
    }





}
