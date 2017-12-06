import javafx.util.Pair;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

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

    public Server(Maps maps){
       this.maps = maps;
    }

    /**
     * Listens to the socket for incomming messages from routers or terminal nodes
     * @throws IOException
     */
    public void startServer() throws IOException {
        super.createSocket("server", 9999, "localhost");
        try {
            while (true) {
                System.out.println("\nServidor  esperando...");
                this.cs = this.ss.accept();
                System.out.println("Cliente conectado en el servidor ");
                this.outClient = new DataInputStream(this.cs.getInputStream());
                String newMessage = this.outClient.readUTF();
                System.out.println("MENSAJE NUEVO\n"+newMessage);
                Client client = new Client(this.maps);
                //client.startClient(newMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
