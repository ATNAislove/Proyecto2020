package factura;

import tarifa.Tarifa;

import java.time.LocalDate;

public class Factura {
    private int codigo;
    private String nif; //Queremos saber de qué cliente es la factura
    private Tarifa tarifa;
    private LocalDate fechaEmision;
    private LocalDate ultimaFecha; //Periodo en días de la anterior factura a la actual
    private double importe;


    public Factura(int codigo, String nif, Tarifa tarifa, LocalDate fechaEmision, LocalDate ultimaFecha, double importe) {
        this.codigo = codigo;
        this.nif = nif;
        this.tarifa = tarifa;
        this.fechaEmision = fechaEmision;
        this.ultimaFecha = ultimaFecha;
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

    public LocalDate getUltimaFecha() {
        return ultimaFecha;
    }

    public void setUltimaFecha(LocalDate ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }
}
