package com.sifpe.crudsifpe.crud.dto;

import jakarta.validation.constraints.NotBlank;
import org.apache.logging.log4j.message.Message;

public class ActividadDto {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "la descripcion es obligatoria")
    private  String descripcion;
    private String observaciones;
    private String fecha;

    public ActividadDto() {
    }

    public ActividadDto(String nombre, String descripcion, String observaciones, String fecha) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }



    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getFecha() {
        return fecha;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
