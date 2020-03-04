package cliente;

import tarifa.Tarifa;

import java.time.LocalDate;

public class Empresa extends Cliente{
    public Empresa(String nombre, String nif, String correo, LocalDate fecha, Direccion direccion, Tarifa tarifa) {
        super(nombre, nif, correo, fecha, direccion, tarifa);
    }
}
