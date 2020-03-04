package llamada;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Llamada {
    private String nTelefono;
    private LocalDate fechaLlamada;
    private LocalDateTime horaLlamada;
    private double duración; //Duración de la llamada en minutos

    public Llamada(String nTelefono, LocalDate fechaLlamada, LocalDateTime horaLlamada, double duración) {
        this.nTelefono = nTelefono;
        this.fechaLlamada = fechaLlamada;
        this.horaLlamada = horaLlamada;
        this.duración = duración;
    }


    public String getnTelefono() {
        return nTelefono;
    }

    public LocalDate getFecha() {
        return fechaLlamada;
    }

    public LocalDateTime getHoraLlamada() {
        return horaLlamada;
    }

    public double getDuración() {
        return duración;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "nTelefono='" + nTelefono + '\'' +
                ", fechaLlamada=" + fechaLlamada +
                ", horaLlamada=" + horaLlamada +
                ", duración=" + duración +
                '}';
    }
}
