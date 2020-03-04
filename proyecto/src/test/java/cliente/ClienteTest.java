package cliente;

import es.uji.www.GeneradorDatosINE;
import llamada.Llamada;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tarifa.Tarifa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    static Cliente particular;
    static Cliente empresa;
    static Llamada llamada1;
    static Llamada llamada2;

    @BeforeAll
    static void inicializarDatos(){
        GeneradorDatosINE generador = new GeneradorDatosINE();
        Direccion direccion = new Direccion(12345, generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        particular = new Particular(generador.getNombre(), generador.getNIF(), generador.getApellido()+"@uji.es", LocalDate.now(), direccion, new Tarifa(5), generador.getApellido());
        empresa = new Empresa(generador.getNombre(), generador.getNIF(), generador.getNombre() + "@uji.es", LocalDate.now(), direccion, new Tarifa(7));
        llamada1 = new Llamada("123456789", LocalDate.now(), LocalDateTime.now(), 150);
        llamada2 = new Llamada("987654321", LocalDate.now(), LocalDateTime.now(), 85);
    }

    @Test
    void darAltaLlamada() {
        assertEquals(false, particular.containsLlamada(llamada1));
        particular.darAltaLlamada(llamada1);
        assertEquals(true, particular.containsLlamada(llamada1));

        assertEquals(false, empresa.containsLlamada(llamada2));
        empresa.darAltaLlamada(llamada2);
        assertEquals(true, empresa.containsLlamada(llamada2));
    }
}