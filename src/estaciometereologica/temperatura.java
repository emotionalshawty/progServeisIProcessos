package estaciometereologica;


public class temperatura extends sensor {
    public temperatura() {
        super("Temperatura", "°C");
    }

    protected temperatura(String name, String unit) {
        super(name, unit);
    }



    @Override
    public void updateReading() {
        // Simula una lectura entre -10.0 i 40.0
        this.value = -10 + 50 * random.nextDouble();
    }
}