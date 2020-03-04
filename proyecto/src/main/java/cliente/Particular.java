package cliente;

import tarifa.Tarifa;

import java.time.LocalDate;

public class Particular extends Cliente{
    private String apellidos;

    public Particular(String nombre, String nif, String correo, LocalDate fecha, Direccion direccion, Tarifa tarifa, String apellidos) {
        super(nombre, nif, correo, fecha, direccion, tarifa);
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                "apellidos='" + apellidos + '\'' +
                ", nif='" + getNif() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", fecha=" + getFecha() +
                ", direccion=" + getDireccion().toString() +
                ", tarifa=" + getTarifa().toString() + '}';
    }
}
