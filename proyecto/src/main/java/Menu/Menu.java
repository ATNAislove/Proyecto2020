package Menu;

import cliente.Cliente;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
import factura.Factura;
import gestor.Gestor;
import llamada.Llamada;
import tarifa.Tarifa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String args[]) {
        Gestor gestor = new Gestor();
        boolean continua = true;

        while (continua) {
            System.out.println(OpcionesMenu.getMenu());
            Scanner scanner = new Scanner(System.in);
            System.out.print("Elija una opcion: ");
            int opcion = scanner.nextInt() - 1;
            OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);
            System.out.println("Ha elegido: " + opcionMenu);

            String nif;
            switch (opcionMenu) {

                case DAR_ALTA_CLIENTE:
                    System.out.print("Introduzca el tipo de cliente (Particular (P) o Empresa (E)): ");
                    char tipo = scanner.next().toUpperCase().charAt(0);
                    if(tipo!='E' && tipo!='P'){
                        System.out.print("No has introducido tipo (Particular (P) o Empresa (E)). ");
                        break;
                    }
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    String apellidos = "";
                    if(tipo == 'P'){
                        System.out.print("Apellidos: ");
                        apellidos = scanner.next();
                    }
                    System.out.print("nif/cif: ");
                    nif = scanner.next();

                    System.out.print("Correo: ");
                    String correo = scanner.next();

                    System.out.println("Dirección: ");
                    System.out.print("Codigo postal: ");
                    int cPostal = scanner.nextInt();
                    System.out.print("Provincia: ");
                    String provincia = scanner.next();
                    System.out.print("Poblacion: ");
                    String poblacion = scanner.next();

                    Direccion direccion = new Direccion(cPostal, provincia, poblacion);

                    System.out.print("Tarifa: ");
                    int factor = scanner.nextInt();

                    Tarifa tarifa = new Tarifa(factor);

                    Cliente cliente = null;

                    if(tipo=='E'){
                        cliente=new Empresa(nombre, nif, correo, LocalDate.now(), direccion, tarifa);
                    } else if (tipo == 'P') {
                        cliente=new Particular(nombre, nif, correo, LocalDate.now(), direccion, tarifa, apellidos);
                    }
                    gestor.altaCliente(cliente);
                    break;

                case BORRAR_CLIENTE:
                    System.out.print("nif/cif: ");
                    nif = scanner.next();
                    Cliente cliente1 = gestor.recuperarDatos(nif);
                    if(cliente1 != null){
                        System.out.print(cliente1.toString());
                        gestor.borrarCliente(nif);
                    }
                    System.out.println("El cliente no existe.");

                    break;
                case CAMBIAR_TARIFA_CLIENTE:

                    System.out.print("nif/cif: ");
                    nif = scanner.next();

                    System.out.print("Introduce nueva tarifa: ");
                    int t = scanner.nextInt();
                    gestor.recuperarDatos(nif).setTarifa(new Tarifa(t));

                    break;
                case DATOS_CLIENTE:
                    System.out.print("nif/cif: ");
                    nif = scanner.next();
                    Cliente cliente2 = gestor.recuperarDatos(nif);
                    if(cliente2 != null){
                        System.out.print(cliente2.toString());
                    }
                    System.out.print("El cliente no existe.");
                    break;

                case LISTA_CLIENTES:
                    List<Cliente> list = gestor.listarClientes();
                    for(Cliente c: list){
                        System.out.println(c.toString());
                    }
                    break;
                case DAR_ALTA_LLAMADA:
                    System.out.print("nif/cif: ");
                    nif = scanner.next();

                    System.out.print("Numero de telefono: ");
                    String nTelefono = scanner.next();

                    System.out.print("Duracion: ");
                    double duracion = scanner.nextDouble();

                    Llamada llamada = new Llamada(nTelefono, LocalDate.now(), LocalDateTime.now(), duracion);
                    gestor.recuperarDatos(nif).darAltaLlamada(llamada);

                    break;
                case LISTA_LLAMADAS_CLIENTE:
                    System.out.print("nif/cif: ");
                    nif = scanner.next();
                    List<Llamada> llamadas = gestor.recuperarDatos(nif).getLlamadas();
                    for(Llamada llam: llamadas){
                        System.out.println(llam.toString());
                    }
                    break;
                case EMITIR_FACTURA:
                    System.out.print("nif/cif: ");
                    nif = scanner.next();
                    System.out.print(gestor.emitirFactura(nif).toString());
                    break;
                case DATOS_FACTURA:
                    System.out.print("Codigo factura: ");
                    int codFact = scanner.nextInt();
                    System.out.print(gestor.getFactura(codFact).toString());
                    break;
                case FACTURAS_CLIENTE:
                    System.out.print("nif/cif: ");
                    nif = scanner.next();
                    List<Factura> facturas = gestor.facturasCliente(nif);
                    for(Factura factura: facturas){
                        System.out.println(factura.toString());
                    }
                    break;
                case SALIR:
                    continua = false;
                    System.out.println("Adios");
                    break;
            }
        }
    }
}
