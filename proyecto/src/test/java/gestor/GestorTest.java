package gestor;

import cliente.Cliente;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
import factura.Factura;
import llamada.Llamada;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.uji.www.GeneradorDatosINE;
import tarifa.Tarifa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestorTest {
    static Gestor gestor;
    static Cliente particular;
    static Cliente empresa;
    static Llamada llamada1;
    static Llamada llamada2;
    static Factura factura1;
    static Factura factura2;

    @BeforeAll
    static void inicializarDatos() {
        gestor = new Gestor();
        GeneradorDatosINE generador = new GeneradorDatosINE();
        Direccion direccion = new Direccion(12345, generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        particular = new Particular(generador.getNombre(), generador.getNIF(), generador.getApellido()+"@uji.es", LocalDate.now(), direccion, new Tarifa(5), generador.getApellido());
        empresa = new Empresa(generador.getNombre(), generador.getNIF(), generador.getNombre() + "@uji.es", LocalDate.now(), direccion, new Tarifa(7));
        llamada1 = new Llamada("123456789", LocalDate.now(), LocalDateTime.now(), 150);
        llamada2 = new Llamada("987654321", LocalDate.now(), LocalDateTime.now(), 85);
    }
    @BeforeEach
    void inializarGestor(){
        gestor.altaCliente(particular);
        gestor.altaCliente(empresa);
    }

    @Test
    void altaCliente() {
        gestor.borrarCliente(particular.getNif());
        gestor.borrarCliente(empresa.getNif());
        assertEquals(false,gestor.containsCliente(particular.getNif()));
        gestor.altaCliente(particular);
        assertEquals(true,gestor.containsCliente(particular.getNif()));

        assertEquals(false,gestor.containsCliente(empresa.getNif()));
        gestor.altaCliente(empresa);
        assertEquals(true,gestor.containsCliente(empresa.getNif()));
    }

    @Test
    void actualizarTarifaCliente() {

        assertEquals(5, gestor.recuperarDatos(particular.getNif()).getTarifa().getFactor());
        gestor.recuperarDatos(particular.getNif()).setTarifa(new Tarifa(8));
        assertEquals(8, gestor.recuperarDatos(particular.getNif()).getTarifa().getFactor());

        assertEquals(7, gestor.recuperarDatos(empresa.getNif()).getTarifa().getFactor());
        gestor.recuperarDatos(empresa.getNif()).setTarifa(new Tarifa(5));
        assertEquals(5, gestor.recuperarDatos(empresa.getNif()).getTarifa().getFactor());
    }

    @Test
    void recuperarDatos() {
        assertEquals(particular, gestor.recuperarDatos(particular.getNif()));
        assertEquals(empresa, gestor.recuperarDatos(empresa.getNif()));
    }

    @Test
    void listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        lista.add(particular);
        lista.add(empresa);
        System.out.println(lista.toString());
        System.out.println(gestor.listarClientes().toString());
        assertEquals(true, gestor.listarClientes().containsAll(lista));
        assertEquals(lista.size(), gestor.listarClientes().size());

    }

    @Test
    void listarLlamadasCliente() {
        gestor.recuperarDatos(particular.getNif()).darAltaLlamada(llamada1);
        gestor.recuperarDatos(particular.getNif()).darAltaLlamada(llamada2);

        List<Llamada> lista = new ArrayList<>();
        lista.add(llamada1);
        lista.add(llamada2);
        assertEquals(true, lista.equals(gestor.recuperarDatos(particular.getNif()).getLlamadas()));
        assertEquals(true, gestor.recuperarDatos(particular.getNif()).getLlamadas().containsAll(lista));
        assertEquals(lista.size(), gestor.recuperarDatos(particular.getNif()).getLlamadas().size());


    }

    @Test
    void emitirFactura() {
        factura1 = gestor.emitirFactura(particular.getNif());
        assertEquals(true,gestor.containsFactura(factura1.getCodigo()));

    }

    @Test
    void getFactura() {
        factura2 = gestor.emitirFactura(particular.getNif());
        assertEquals(factura2, gestor.getFactura(factura2.getCodigo()));
    }

    @Test
    void facturasCliente() {
        List<Factura> lista = new ArrayList<>();
        lista.add(factura2);
        lista.add(factura1);


        System.out.println(lista.toString());
        System.out.println(gestor.facturasCliente(particular.getNif()).toString());

        assertEquals(true, lista.equals(gestor.facturasCliente(particular.getNif())));

        assertEquals(true, gestor.facturasCliente(particular.getNif()).containsAll(lista));
        assertEquals(lista.size(), gestor.facturasCliente(particular.getNif()).size());


    }


    @Test
    void borrarCliente() {

        assertEquals(true,gestor.containsCliente(particular.getNif()));
        gestor.borrarCliente(particular.getNif());
        assertEquals(false,gestor.containsCliente(particular.getNif()));

        assertEquals(true,gestor.containsCliente(empresa.getNif()));
        gestor.borrarCliente(empresa.getNif());
        assertEquals(false,gestor.containsCliente(empresa.getNif()));

    }
}