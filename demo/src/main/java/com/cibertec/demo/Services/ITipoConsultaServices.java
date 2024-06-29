package com.cibertec.demo.Services;
import com.cibertec.demo.model.tipoConsulta;
import com.cibertec.demo.model.usuario;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface ITipoConsultaServices {
    List<tipoConsulta> listartipoConsulta();
    tipoConsulta creartipoConsulta(tipoConsulta entity);
    tipoConsulta actualizartipoConsulta(tipoConsulta entity);
    tipoConsulta BuscartipoConsulta(int id);
    tipoConsulta EliminartipoConsulta(int id);

}
