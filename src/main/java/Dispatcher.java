import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by josue on 07/11/17.
 */
public class Dispatcher {
    public Map<String,IpData> ipTableJosue;
    public Map<String,IpData> ipTableSilvia;
    public Map<String,Pair<String,String>> oneToOneRelation;

    public Dispatcher(){

        this.ipTableJosue = new HashMap<String,IpData>();
                        //key is network ip      computer ip                                 through
        this.ipTableJosue.put("12.0.0.0",new IpData("127.0.0.1", "12.0.0.8", "12.0.0.7", 1,8888));//banderas
        this.ipTableJosue.put("200.5.0.0",new IpData("192.168.100.16", "200.5.0.2", "12.0.0.7",2,0));//paletas
        this.ipTableJosue.put("140.90.0.0",new IpData("192.168.100.16", "12.0.0.8", "12.0.0.7", 2,0));//bolinchas
        this.ipTableJosue.put("201.6.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 1,0));//legos
        this.ipTableJosue.put("25.0.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 0,5555));//luces
        this.ipTableSilvia = new HashMap<String,IpData>();
        //key is network ip      computer ip                                 through
        this.ipTableSilvia.put("12.0.0.0",new IpData("127.0.0.1", "12.0.0.8", "12.0.0.7", 0,8888));//banderas
        this.ipTableSilvia.put("200.5.0.0",new IpData("192.168.100.16", "200.5.0.2", "12.0.0.7",1,0));//paletas
        this.ipTableSilvia.put("140.90.0.0",new IpData("192.168.100.16", "12.0.0.8", "12.0.0.7", 2,0));//bolinchas
        this.ipTableSilvia.put("201.6.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 2,0));//legos
        this.ipTableSilvia.put("25.0.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 1,5555));//luces

        this.oneToOneRelation = new HashMap<String, Pair<String,String>>();
        this.oneToOneRelation.put("165.8.0.6",new Pair<String,String>("127.0.0.1","6666"));//cambiar luego!
        this.oneToOneRelation.put("165.8.25.6",new Pair<String,String>("127.0.0.1","5555"));
    }

    public void startDispatcher(){
        Thread thread = new Thread(new DispatcherService(this.ipTableJosue,this.ipTableSilvia,this.oneToOneRelation));
        thread.start();
    }
}
