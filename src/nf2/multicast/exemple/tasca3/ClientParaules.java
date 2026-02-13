package nf2.multicast.exemple.tasca3;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Client que es subscriu al servei multicast de paraules
 * i compta quantes vegades ha rebut cada paraula
 */
public class ClientParaules {

    private boolean continueRunning = true;
    private MulticastSocket socket;
    private InetAddress multicastIP;
    private int port;
    private NetworkInterface netIf;
    private InetSocketAddress group;

    // Mapa per comptar les vegades que apareix cada paraula
    private Map<String, Integer> comptadorParaules;

    public ClientParaules(int portValue, String strIp) throws IOException {
        multicastIP = InetAddress.getByName(strIp);
        port = portValue;
        socket = new MulticastSocket(port);
        netIf = socket.getNetworkInterface();
        group = new InetSocketAddress(strIp, portValue);
        comptadorParaules = new HashMap<>();
    }

    /**
     * Executa el client, escoltant paraules del servidor multicast
     */
    public void runClient() throws IOException {
        DatagramPacket packet;
        byte[] receivedData = new byte[1024];

        // Unir-se al grup multicast
        socket.joinGroup(group, netIf);
        System.out.println("═══════════════════════════════════════════════════");
        System.out.printf("Connectat a %s:%d%n", group.getAddress(), group.getPort());
        System.out.println("Escoltant paraules...");
        System.out.println("═══════════════════════════════════════════════════\n");

        while (continueRunning) {
            packet = new DatagramPacket(receivedData, receivedData.length);
            socket.setSoTimeout(10000); // Timeout de 10 segons

            try {
                socket.receive(packet);
                processData(packet.getData(), packet.getLength());
            } catch (SocketTimeoutException e) {
                System.out.println("\n⚠ S'ha perdut la connexió amb el servidor (timeout).");
                continueRunning = false;
            }
        }

        // Sortir del grup i tancar el socket
        socket.leaveGroup(group, netIf);
        socket.close();

        // Mostrar resum final
        mostrarResum();
    }

    /**
     * Processa les dades rebudes (paraula) i actualitza el comptador
     */
    private void processData(byte[] data, int length) {
        String paraula = new String(data, 0, length);

        // Actualitzar el comptador
        comptadorParaules.put(paraula, comptadorParaules.getOrDefault(paraula, 0) + 1);

        // Mostrar la paraula rebuda i el seu comptador
        int vegades = comptadorParaules.get(paraula);
        System.out.printf("➤ Rebuda: %-15s | Vegades: %d%n", paraula, vegades);
    }

    /**
     * Mostra un resum amb totes les paraules rebudes i els seus comptadors
     */
    private void mostrarResum() {
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("           RESUM DE PARAULES REBUDES");
        System.out.println("═══════════════════════════════════════════════════");

        if (comptadorParaules.isEmpty()) {
            System.out.println("No s'han rebut paraules.");
        } else {
            // Calcular el total de paraules rebudes
            int total = comptadorParaules.values().stream().mapToInt(Integer::intValue).sum();

            // Mostrar cada paraula i el seu comptador
            comptadorParaules.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Ordenar per vegades (descendent)
                    .forEach(entry -> {
                        String paraula = entry.getKey();
                        int vegades = entry.getValue();
                        double percentatge = (vegades * 100.0) / total;
                        System.out.printf("  %-15s | %3d vegades | %5.1f%%%n",
                                paraula, vegades, percentatge);
                    });

            System.out.println("───────────────────────────────────────────────────");
            System.out.printf("  TOTAL: %d paraules rebudes%n", total);
        }

        System.out.println("═══════════════════════════════════════════════════");
    }

    public static void main(String[] args) {
        try {
            // Utilitzar el mateix IP i port que el servidor
            ClientParaules client = new ClientParaules(5558, "224.0.12.112");
            client.runClient();
            System.out.println("\nClient finalitzat.");
        } catch (IOException e) {
            System.err.println("Error al client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

