package Menu;

public enum OpcionesMenu {

    DAR_ALTA_CLIENTE("Dar de alta un nuevo cliente."),
    BORRAR_CLIENTE("Borrar un cliente."),
    CAMBIAR_TARIFA_CLIENTE("Cambiar la tarifa de un cliente."),
    DATOS_CLIENTE("Recuperar los datos de un cliente a partir de su NIF."),
    LISTA_CLIENTES("Recuperar el listado de todos los clientes."),
    DAR_ALTA_LLAMADA("Dar de alta una llamada."),
    LISTA_LLAMADAS_CLIENTE("Listar todas las llamadas de un cliente."),
    EMITIR_FACTURA("Emitir una factura para un cliente."),
    DATOS_FACTURA("Recuperar los datos de una factura a partir de su codigo."),
    FACTURAS_CLIENTE("Recuperar todas las facturas de un cliente."),
    SALIR("Salir");

    private String descripcion;
    OpcionesMenu(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public static OpcionesMenu getOpcion(int posicion) {
        return values()[posicion];
    }
    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (OpcionesMenu opcion : OpcionesMenu.values()) {
            sb.append(opcion.ordinal() + 1);
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }

}
