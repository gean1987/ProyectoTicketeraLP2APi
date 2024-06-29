package com.cibertec.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicket;
    private Date fechaGeneracion;
    private String asunto;
    private int equipo;
    private int tipoConsulta;
    private Date fechaAsignacion;
    private String correoEmisor;
    private String correoReceptor;
    private int idEstado;
    private Date fechaCierre;
    @Column(columnDefinition = "VARCHAR(MAX)")
    private String cuerpoTicket;

    @Column(columnDefinition = "VARCHAR(MAX)")
    private String respuestaTicket;


}
