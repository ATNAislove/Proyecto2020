package cliente;

public class Direccion {
    private int codPostal;
    private String provincia;
    private String poblacion;

    public Direccion(int codPostal, String provincia, String poblacion) {
        this.codPostal = codPostal;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return poblacion + provincia + codPostal;
    }
}
