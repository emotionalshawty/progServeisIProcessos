package estaciometereologica;

/**
 * Sensor de velocitat del vent (versió d'un sol fil).
 */
public class velocitatvent extends sensor {
    public velocitatvent() {
        super("Velocitat del Vent", "km/h");
    }

    protected velocitatvent(String name, String unit) {
        super(name, unit);
    }

    @Override
    public void updateReading() {
        // Simula una lectura entre 0.0 i 120.0
        this.value = 120 * random.nextDouble();
    }
}