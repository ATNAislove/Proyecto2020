package factura;

import tarifa.Tarifa;

import java.time.LocalDate;

public class Factura {
    private int codigo;
    private String nif; //Queremos saber de qué cliente es la factura
    private Tarifa tarifa;
    private LocalDate fechaEmision;
    private LocalDate fechaInicio; //Periodo en días de la anterior factura a la actual
    private double importe;


    public Factura(int codigo, String nif, Tarifa tarifa, LocalDate fechaEmision, LocalDate fechaInicio, double importe) {
        this.codigo = codigo;
        this.nif = nif;
        this.tarifa = tarifa;
        this.fechaEmision = fechaEmision;
        this.fechaInicio = fechaInicio;
        this.importe = importe;
    }


    public int getCodigo() {
        return codigo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public LocalDate getFecha() {
        return fechaEmision;
    }


    public double getImporte() {
        return importe;
    }

    public String getNif() {
        return nif;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", nif='" + nif + '\'' +
                ", tarifa=" + tarifa +
                ", fechaEmision=" + fechaEmision +
                ", fechaInicio=" + fechaInicio +
                ", importe=" + importe +
                '}';
    }
}
