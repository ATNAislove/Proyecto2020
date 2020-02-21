package llamada;

import java.time.LocalDate;

public class Llamada {
    private String nTelefono;
    private LocalDate fechaLlamada;
    private LocalDate horaLlamada;
    private double duración; //Duración de la llamada en minutos

    public Llamada(String nTelefono, LocalDate fechaLlamada, LocalDate horaLlamada, double duración) {
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

    public LocalDate getHoraLlamada() {
        return horaLlamada;
    }

    public double getDuración() {
        return duración;
    }
}
