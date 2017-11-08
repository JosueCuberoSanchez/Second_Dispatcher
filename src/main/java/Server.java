import javafx.util.Pair;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by josue on 07/11/17.
 */
public class Server extends Connection {
    private Map<String, IpData> ipTable;
    private Map<String,Pair<String,String>> oneToOneRelation;

    public Server(Map<String, IpData> ipTable,Map<String,Pair<String,String>> oneToOneRelation){
        this.ipTable = ipTable;
        this.oneToOneRelation = oneToOneRelation;
    }

    public void startServer() throws IOException {
        super.createSocket("server", 6666, "localhost");
        try {
            while (true) {
                System.out.println("\nServidor  esperando...");
                this.cs = this.ss.accept();
                System.out.println("Cliente conectado en el servidor ");
                this.outClient = new DataInputStream(this.cs.getInputStream());
                String newMessage = this.outClient.readUTF();
                System.out.println(newMessage);
                Client client = new Client(this.ipTable,this.oneToOneRelation);
                client.startClient(newMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
