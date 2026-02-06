package nf1.estaciometereologica;

import java.util.List;


public class estacio {

    private static final int SIMULATION_DURATION_SECONDS = 30; // Durada total de la simulació
    private static final int SENSOR_UPDATE_INTERVAL_SECONDS = 2; // Els sensors s'actualitzen cada 2s
    private static final int DISPLAY_INTERVAL_SECONDS = 5;       // Les lectures es mostren cada 5s

    public static void main(String[] args) {
        // 1. Creem les instàncies dels nostres sensors.
        temperatura tempSensor = new temperatura();
        humitat humiditySensor = new humitat();
        velocitatvent windSensor = new velocitatvent();

        List<sensor> sensors = List.of(tempSensor, humiditySensor, windSensor);

        System.out.println("Iniciant la simulació de l'estació meteorològica (un sol fil)...");

        // 2. Bucle principal de la simulació.
        for (int second = 1; second <= SIMULATION_DURATION_SECONDS; second++) {

            // 3. Comprovem si toca actualitzar els sensors.
            if (second % SENSOR_UPDATE_INTERVAL_SECONDS == 0) {
                //System.out.printf("[Segon %d: Actualitzant sensors...]\n", second); // Descomenta per veure quan s'actualitza
                for (sensor sensor : sensors) {
                    sensor.updateReading();
                }
            }

            // 4. Comprovem si toca imprimir les lectures.
            if (second % DISPLAY_INTERVAL_SECONDS == 0) {
                System.out.println("----------------------------------------");
                System.out.printf("Lectures al segon %d:\n", second);
                for (sensor sensor : sensors) {
                    System.out.printf("- %s: %s\n", sensor.getName(), sensor.getReading());
                }
                System.out.println("----------------------------------------\n");
            }

            // 5. Esperem un segon per simular el pas del temps.
            try {
                Thread.sleep(1000); // 1000 mil·lisegons = 1 segon
            } catch (InterruptedException e) {
                System.err.println("La simulació ha estat interrompuda.");
                Thread.currentThread().interrupt(); // Restaura l'estat d'interrupció
                break; // Surt del bucle
            }
        }

        System.out.println("Simulació finalitzada.");
    }
}