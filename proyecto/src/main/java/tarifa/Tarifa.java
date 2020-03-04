package tarifa;

public class Tarifa {

    private int factor; //Precio en centimos minuto

    public Tarifa(int factor){
        this.factor=factor;
    }


    public int getFactor() {
        return factor;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "factor=" + factor +
                '}';
    }
}
