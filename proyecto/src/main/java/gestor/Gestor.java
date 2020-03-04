package gestor;

import cliente.Cliente;
import factura.Factura;
import llamada.Llamada;
import tarifa.Tarifa;

import java.time.LocalDate;
import java.util.*;

public class Gestor {
    private Map<String, Cliente> clientes;
    private Map<Integer, Factura> facturas;

    public Gestor(){
        this.clientes = new HashMap<String, Cliente>();
        this.facturas = new HashMap<Integer, Factura>();
    }

    public void altaCliente(Cliente cliente){
        clientes.put(cliente.getNif(), cliente);
    }

    public void borrarCliente(String nif){
        clientes.remove(nif);
    }

    public void actualizarTarifaCliente(Tarifa tarifa, String nif){
        Cliente cliente = clientes.get(nif);
        cliente.setTarifa(tarifa);
        clientes.put(nif, cliente);
    }
    public boolean containsCliente(String nif){
        if(clientes.get(nif) != null){
            return true;
        }else
            return false;
    }

    public Cliente recuperarDatos(String nif){
        if(clientes.get(nif) != null){
            return clientes.get(nif);
        }else
            return null;
    }

    public List<Cliente> listarClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Iterator<String> iter = clientes.keySet().iterator();
        while (iter.hasNext()){
            Cliente cliente = clientes.get(iter.next());
            listaClientes.add(cliente);
        }
        return listaClientes;
    }

    public List<Llamada> listarLlamadasCliente(String nif){
        Cliente cliente = recuperarDatos(nif);
        if(cliente != null){
            return cliente.getLlamadas();
        }else
            return null;
    }

    public Factura emitirFactura(String nif){
        int codigo = facturas.keySet().size();
        Cliente cliente = clientes.get(nif);
        Tarifa tarifa = cliente.getTarifa();
        LocalDate fechaEmision = LocalDate.now().minusDays(1);
        LocalDate fechaUltimaFactura;
        //Encontrar la fecha de la última factura de cliente
        Iterator<Integer> iter = facturas.keySet().iterator();
        Factura ultimaFacturaCliente = null;
        while (iter.hasNext()){
            Factura aux = facturas.get(iter.next());
            if(aux.getNif().equals(nif)){
                ultimaFacturaCliente = aux;
            }
        }
        if (ultimaFacturaCliente != null){
            fechaUltimaFactura = ultimaFacturaCliente.getFecha().plusDays(1);
        }else{
            fechaUltimaFactura = cliente.getFecha();
        }
        double duracion = 0.0;
        List<Llamada> llamadas = clientes.get(nif).getLlamadas();
        Iterator<Llamada> iter2 = llamadas.iterator();
        while (iter2.hasNext()){
            Llamada aux = iter2.next();
            if(aux.getFecha().compareTo(fechaEmision)<0 || aux.getFecha().compareTo(fechaUltimaFactura) >= 0){
                duracion+=aux.getDuración();
            }
        }
        double importe = (duracion*tarifa.getFactor())/100;
        Factura factura = new Factura(codigo, nif, tarifa, fechaEmision, fechaUltimaFactura, importe);
        facturas.put(codigo, factura);
        return factura;
    }

    public boolean containsFactura(int cod){
        if(facturas.get(cod)!=null){
            return true;
        }else
            return false;
    }

    public Factura getFactura(int codigo){
        return facturas.get(codigo);
    }

    public List<Factura> facturasCliente(String nif){
        List<Factura> facturasCli = new ArrayList<>();
        Iterator<Integer> iter = facturas.keySet().iterator();

        while (iter.hasNext()){
            Factura aux = facturas.get(iter.next());
            if(aux.getNif().equals(nif)){
                facturasCli.add(aux);
            }
        }
        return facturasCli;
    }

}
