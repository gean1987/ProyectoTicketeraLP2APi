package com.cibertec.demo.rest;

import com.cibertec.demo.Services.ITipoConsultaServices;
import com.cibertec.demo.model.tipoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class tipoConsultaController {

    ITipoConsultaServices dataServices;

    @Autowired
    public tipoConsultaController(ITipoConsultaServices dataServices) {
        this.dataServices=dataServices;
    }

    @GetMapping("/tipoConsulta")
    public List<tipoConsulta> getAll() {
        return dataServices.listartipoConsulta();
    }

    @GetMapping("/tipoConsulta/{id}")
    public tipoConsulta getAll(@PathVariable int id) {
        return dataServices.BuscartipoConsulta(id);
    }

    @PostMapping("/tipoConsulta")
    public tipoConsulta savePet(@RequestBody tipoConsulta entity) {
        return dataServices.creartipoConsulta(entity);
    }

    @PutMapping("/tipoConsulta")
    public tipoConsulta updatePet(@RequestBody tipoConsulta entity) {
        return dataServices.actualizartipoConsulta(entity);
    }

    @DeleteMapping("/tipoConsulta/{id}")
    public tipoConsulta deletePetById(@PathVariable int id) {
        return dataServices.EliminartipoConsulta(id);
    }

}
