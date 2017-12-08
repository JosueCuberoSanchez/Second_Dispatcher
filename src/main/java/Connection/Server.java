package Connection;

import DataContainers.Maps;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Universidad de Costa Rica
 * Facultad de Ingeniería
 * Escuela de Ciencias de la Computación e Informática
 * Profesora: Gabriela Barrantes
 * Autores:
 * Abellán Jiménez Mariana B50031
 * Brenes Solano Silvia B41133
 * Cubero Sánchez Josué B42190
 */
public class Server extends Connection {
    private Maps maps;

    public Server(){
        this.maps = new Maps();
    }

    /**
     * Listens to the socket for incomming messages from routers or terminal nodes
     * @throws IOException
     */
    public void startServer() throws IOException {
        super.createSocket("server", 9999, "localhost");
        try {
            while (true) {
                /*PRUEBA
                String message = "1\n5\n2\nlocalhost\n3000";
                Connection.Connection.Client clientt = new Connection.Connection.Client(this.maps);
                clientt.startClient(message);
                PRUEBA*/
                System.out.println("\nServidor de dispatcher esperando...");
                this.cs = this.ss.accept();
                System.out.println("Alguien se conectó con el dispatcher");
                this.outClient = new DataInputStream(this.cs.getInputStream());
                String newMessage = this.outClient.readUTF();
                System.out.println("MENSAJE NUEVO!\n"+newMessage+"\n"); //comentar
                Client client = new Client(this.maps);
                client.startClient(newMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
