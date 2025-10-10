package estaciometereologica;

import java.util.Random;

/**
 * Classe abstracta que representa un sensor genèric per a un entorn d'un sol fil.
 */
public abstract class sensor {
    protected final String name;
    protected final String unit;
    // Ja no cal AtomicReference, un double primitiu és suficient.
    protected double value;
    protected final Random random = new Random();

    public sensor(String name, String unit) {
        this.name = name;
        this.unit = unit;
        this.value = 0.0;
    }




    /**
     * Retorna el nom del sensor.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna la lectura actual formatada amb la seva unitat.
     */
    public String getReading() {
        return String.format("%.2f %s", value, unit);
    }

    /**
     * Mètode per generar una nova lectura aleatòria del sensor.
     */
    public abstract void updateReading();
}