package cliente;

import java.time.LocalDate;
import java.util.*;

public abstract class Cliente {
    private String nombre;
    private String nif;
    private String correo;
    private LocalDate fecha;
    private Direccion direccion;
    private Tarifa tarifa;
    private List<Llamada> llamadas;


    public Cliente(String nombre, String nif, String correo, LocalDate fecha, Direccion direccion, Tarifa tarifa) {
        this.nombre = nombre;
        this.nif = nif;
        this.correo = correo;
        this.fecha = fecha;
        this.direccion = direccion;
        this.tarifa = tarifa;
        this.llamadas = new ArrayList<Llamada>();
    }


    public void darAltaLlamada(Llamada llam){
        if(llam!=null)
            llamadas.add(llam);
    }
    public List<Llamada> getLlamadas() {
        return llamadas;
    }


    public String getNombre() {
        return nombre;
    }
    public String getNif() {
        return nif;
    }
    public String getCorreo() {
        return correo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public Tarifa getTarifa() {
        return tarifa;
    }
    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", nif='" + nif + '\'' +
                ", correo='" + correo + '\'' +
                ", fecha=" + fecha +
                ", direccion=" + direccion.toString() +
                ", tarifa=" + tarifa + '}';
    }

}
