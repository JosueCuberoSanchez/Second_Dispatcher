import javafx.util.Pair;

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
public class DispatcherService implements Runnable {
    private Map<String,IpData> ipTableJosue;
    private Map<String,IpData> ipTableSilvia;
    private Map<String,Pair<String,String>> oneToOneRelation;
    private Server server;

    public DispatcherService(Map<String,IpData> ipTableJosue,Map<String,IpData> ipTableSilvia,Map<String,Pair<String,String>> oneToOneRelation){
        this.ipTableJosue = ipTableJosue;
        this.ipTableSilvia = ipTableSilvia;
        this.oneToOneRelation = oneToOneRelation;
    }

    public void run() {
        this.server = new Server(this.ipTableJosue,this.ipTableSilvia,this.oneToOneRelation);
        try {
            this.server.startServer();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
