package estaciometereologica;

public class humitat extends sensor {
    public humitat() {
        super("Humitat", "%");
    }

    @Override
    public void updateReading() {
        // Simula una lectura entre 0.0 i 100.0
        this.value = 100 * random.nextDouble();
    }
}
//yeag