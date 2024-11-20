package model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Clima {
    @SerializedName("name")
    private String nombre;
    private LocalDateTime fechaDeSolicitud;
    @SerializedName("temp")
    private double temperaturaActual;

    @SerializedName("feels_like")
    private  double sensacionTermica;

    @SerializedName("temp_min")
    private double temperaturaMinima;
    @SerializedName("temp_max")
    private double temperaturaMaxima;
    @SerializedName("description")
    private String descripcion;

    public Clima() {
    }

    public Clima(String nombre,
                 double temperaturaActual,
                 double sensacionTermica,
                 double temperaturaMinima,
                 double temperaturaMaxima,
                 String descripcion) {
        this.nombre = nombre;
        this.fechaDeSolicitud = LocalDateTime.now();
        this.temperaturaActual = temperaturaActual;
        this.sensacionTermica = sensacionTermica;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

    public void setFechaDeSolicitud(LocalDateTime fechaDeSolicitud) {
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public double getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(double temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }

    public double getSensacionTermica() {
        return sensacionTermica;
    }

    public void setSensacionTermica(double sensacionTermica) {
        this.sensacionTermica = sensacionTermica;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "ReporteDelClima{" +
                "nombre='" + nombre + '\'' +
                ", fechaDeSolicitud=" + fechaDeSolicitud +
                ", temperaturaActual=" + temperaturaActual +
                ", sensacionTermica=" + sensacionTermica +
                ", temperaturaMinima=" + temperaturaMinima +
                ", temperaturaMaxima=" + temperaturaMaxima +
                ", condicionClimatica='" + descripcion + '\'' +
                '}';
    }
}
