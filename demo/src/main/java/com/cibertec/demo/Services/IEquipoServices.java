package com.cibertec.demo.Services;
import com.cibertec.demo.model.equipo;


import java.util.List;

public interface IEquipoServices {
    List<equipo> listarequipo();
    equipo crearequipo(equipo entity);
    equipo actualizarequipo(equipo entity);
    equipo Buscarequipo(int id);
    equipo Eliminarequipo(int id);
}
