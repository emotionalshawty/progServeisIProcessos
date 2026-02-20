package nf2.unicast.apunts.act1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPSocketServer {
    static final int PORT=9090;
    private boolean end=false;

    public void listen(){
        ServerSocket serverSocket=null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor escoltant en el port " + PORT);

            while(!end){
                clientSocket = serverSocket.accept();
                System.out.println("Client connectat: " + clientSocket.getInetAddress());
//processem la petició del client
                proccesClientRequest(clientSocket);
//tanquem el sòcol temporal per atendre el client
                closeClient(clientSocket);
            }
//tanquem el sòcol principal
            if(serverSocket!=null && !serverSocket.isClosed()){
                serverSocket.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(TCPSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void proccesClientRequest(Socket clientSocket){
        boolean farewellMessage=false;
        String clientMessage="";
        BufferedReader in=null;
        PrintStream out=null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out= new PrintStream(clientSocket.getOutputStream());
            do{
                //processem el missatge del client i generem la resposta. Si
                //clientMessage és buida generarem el missatge de benvinguda
                String dataToSend = processData(clientMessage);
                out.println(dataToSend);
                out.flush();
                clientMessage=in.readLine();
                farewellMessage = isFarewellMessage(clientMessage);
            }while((clientMessage)!=null && !farewellMessage);
        } catch (IOException ex) {
            Logger.getLogger(TCPSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String processData(String clientMessage) {
        if (clientMessage == null || clientMessage.isEmpty()) {
            return "Benvingut al servidor! Envia les teves peticions.";
        }
        System.out.println("Missatge rebut del client: " + clientMessage);
        return "Servidor ha rebut: " + clientMessage;
    }

    private boolean isFarewellMessage(String clientMessage) {
        return clientMessage != null && clientMessage.equalsIgnoreCase("exit");
    }

    private void closeClient(Socket clientSocket){
        //si falla el tancament no podem fer gaire cosa, només enregistrar
        //el problema
        try {
            //tancament de tots els recursos
            if(clientSocket!=null && !clientSocket.isClosed()){
                if(!clientSocket.isInputShutdown()){
                    clientSocket.shutdownInput();
                }
                if(!clientSocket.isOutputShutdown()){
                    clientSocket.shutdownOutput();
                }
                clientSocket.close();
            }
            System.out.println("Client desconnectat");
        } catch (IOException ex) {
            //enregistrem l'error amb un objecte Logger
            Logger.getLogger(TCPSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        TCPSocketServer server = new TCPSocketServer();
        server.listen();
    }
}
