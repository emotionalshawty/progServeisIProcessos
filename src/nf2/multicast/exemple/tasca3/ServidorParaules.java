package nf2.multicast.exemple.tasca3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Servidor Multicast que emet paraules aleatòries d'una llista pre-fabricada
 */
public class ServidorParaules {

    private MulticastSocket socket;
    private InetAddress multicastIP;
    private int port;
    private boolean continueRunning = true;
    private List<String> llistaParaules;
    private Random random;

    public ServidorParaules(int portValue, String strIp) throws IOException {
        socket = new MulticastSocket(portValue);
        multicastIP = InetAddress.getByName(strIp);
        port = portValue;
        random = new Random();

        // Inicialitzar la llista de paraules pre-fabricada
        llistaParaules = new ArrayList<>();
        llistaParaules.add("Java");
        llistaParaules.add("Multicast");
        llistaParaules.add("Socket");
        llistaParaules.add("Thread");
        llistaParaules.add("Network");
        llistaParaules.add("Client");
        llistaParaules.add("Servidor");
        llistaParaules.add("Programació");
        llistaParaules.add("Concurrent");
        llistaParaules.add("Protocol");
        llistaParaules.add("UDP");
        llistaParaules.add("Datagram");
    }

    /**
     * Selecciona una paraula aleatòria de la llista
     */
    private String getParaulaAleatoria() {
        int index = random.nextInt(llistaParaules.size());
        return llistaParaules.get(index);
    }

    /**
     * Executa el servidor, enviant paraules aleatòries
     */
    public void runServer() throws IOException {
        DatagramPacket packet;
        byte[] sendingData;

        System.out.println("Servidor de paraules iniciat a " + multicastIP + ":" + port);
        System.out.println("Enviant paraules aleatòries...\n");

        while (continueRunning) {
            // Agafar una paraula aleatòria
            String paraula = getParaulaAleatoria();

            // Convertir la paraula a bytes
            sendingData = paraula.getBytes();

            // Crear i enviar el paquet
            packet = new DatagramPacket(sendingData, sendingData.length, multicastIP, port);
            socket.send(packet);

            System.out.println("Enviada: " + paraula);

            // Esperar un temps abans d'enviar la següent paraula
            try {
                Thread.sleep(1000); // Enviar cada 1 segon
            } catch (InterruptedException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }

        socket.close();
    }

    public static void main(String[] args) {
        try {
            // Utilitzar IP multicast i port
            ServidorParaules servidor = new ServidorParaules(5558, "224.0.12.112");
            servidor.runServer();
        } catch (IOException e) {
            System.err.println("Error al servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

