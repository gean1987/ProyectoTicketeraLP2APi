package com.cibertec.demo.Services;
import com.cibertec.demo.model.usuario;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface IUsuarioServices {

    List<usuario> listarUsuarios();
    usuario crearUsuario(usuario entity);
    usuario actualizarUsuario(usuario entity);
    usuario BuscarUsuario(int id);
    usuario EliminarUsuario(int id);
    List<usuario> BuscarUsuarioNombre(String nombre);
    List<usuario> BuscarUsuarioRol(String rol);
    List<usuario> BuscarUsuarioCorreoContrasena(String correo, String contrasena);
}
