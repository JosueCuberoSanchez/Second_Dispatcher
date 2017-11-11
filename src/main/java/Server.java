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
 * Garita Centeno Alonso B42791
 */
public class Server extends Connection {
    private Map<String, IpData> ipTableJosue;
    private Map<String, IpData> ipTableSilvia;
    private Map<String,Pair<String,String>> oneToOneRelation;

    public Server(Map<String, IpData> ipTableJosue,Map<String, IpData> ipTableSilvia,Map<String,Pair<String,String>> oneToOneRelation){
        this.ipTableJosue = ipTableJosue;
        this.ipTableSilvia = ipTableSilvia;
        this.oneToOneRelation = oneToOneRelation;
    }

    public void startServer() throws IOException {
        super.createSocket("server", 9999, "localhost");
        try {
            while (true) {
                System.out.println("\nServidor  esperando...");
                this.cs = this.ss.accept();
                System.out.println("Cliente conectado en el servidor ");
                this.outClient = new DataInputStream(this.cs.getInputStream());
                String newMessage = this.outClient.readUTF();
                //System.out.println(newMessage);
                Client client = new Client(this.ipTableJosue,this.ipTableSilvia,this.oneToOneRelation);
                client.startClient(newMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
