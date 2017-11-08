import javafx.util.Pair;

import java.io.IOException;
import java.util.Map;

/**
 * Created by josue on 07/11/17.
 */
public class DispatcherService implements Runnable {
    private Map<String,IpData> ipTable;
    private Map<String,Pair<String,String>> oneToOneRelation;
    private Server server;

    public DispatcherService(Map<String,IpData> ipTable,Map<String,Pair<String,String>> oneToOneRelation){
        this.ipTable = ipTable;
        this.oneToOneRelation = oneToOneRelation;
    }

    public void run() {
        this.server = new Server(this.ipTable,this.oneToOneRelation);
        try {
            this.server.startServer();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
