package com.cibertec.demo.rest;

import com.cibertec.demo.Services.ITipoConsultaServices;
import com.cibertec.demo.Services.IUsuarioServices;
import com.cibertec.demo.model.tipoConsulta;
import com.cibertec.demo.model.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class usuarioController {
    IUsuarioServices dataServices;

    @Autowired
    public usuarioController(IUsuarioServices dataServices) {
        this.dataServices=dataServices;
    }

    @GetMapping("/usuario")
    public List<usuario> getAll() {
        return dataServices.listarUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public usuario getAll(@PathVariable int id) {
        return dataServices.BuscarUsuario(id);
    }


    @GetMapping("/responsable/{rol}")
    public List<usuario> getRol(@PathVariable String rol) {
        return dataServices.BuscarUsuarioRol(rol);
    }


    @GetMapping("/usuario/{correo}/{contrasena}")
    public List<usuario> getcorreocontrasena(@PathVariable String correo, @PathVariable String contrasena) {
        return dataServices.BuscarUsuarioCorreoContrasena(correo, contrasena);
    }


    @PostMapping("/usuario")
    public usuario savePet(@RequestBody usuario entity) {
        return dataServices.crearUsuario(entity);
    }

    @PutMapping("/usuario")
    public usuario updatePet(@RequestBody usuario entity) {
        return dataServices.actualizarUsuario(entity);
    }

    @DeleteMapping("/usuario/{id}")
    public usuario deletePetById(@PathVariable int id) {
        return dataServices.EliminarUsuario(id);
    }
}
