import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by josue on 07/11/17.
 */
public class Dispatcher {
    public Map<String,IpData> ipTable;
    public Map<String,Pair<String,String>> oneToOneRelation;

    public Dispatcher(){
        this.ipTable = new HashMap<String,IpData>(); //silvia

                        //key is network ip      computer ip                                 through
        this.ipTable.put("12.0.0.0",new IpData("127.0.0.1", "12.0.0.8", "165.8.6.25", 0,8888));//banderas
        this.ipTable.put("200.5.0.0",new IpData("192.168.100.16", "200.5.0.2", "165.8.6.25",1,0));//paletas
        this.ipTable.put("140.90.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.6.25", 2,0));//bolinchas

        this.ipTable.put("200.5.0.0",new IpData("192.168.100.16", "200.5.0.2", "165.8.0.6",3,0));//paletas
        this.ipTable.put("201.6.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 1,0));//legos
        this.ipTable.put("25.0.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 0,5555));//luces

        this.oneToOneRelation = new HashMap<String, Pair<String,String>>();
        this.oneToOneRelation.put("165.8.0.6",new Pair<String,String>("127.0.0.1","7777"));
        this.oneToOneRelation.put("165.8.6.25",new Pair<String,String>("127.0.0.1","5555"));
    }

    public void startDispatcher(){
        Thread thread = new Thread(new DispatcherService(this.ipTable,this.oneToOneRelation));
        thread.start();
    }
}
