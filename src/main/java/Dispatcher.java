import javafx.util.Pair;

import java.util.HashMap;
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

public class Dispatcher {
    public Map<String,IpData> ipTableJosue;
    public Map<String,IpData> ipTableSilvia;
    public Map<String,Pair<String,String>> oneToOneRelation;

    public Dispatcher(){
        this.ipTableJosue = new HashMap<String,IpData>();
        this.ipTableJosue.put("12.0.0.0",new IpData("127.0.0.1", "12.0.0.8", "165.8.0.6", 1,8888));//banderas
        this.ipTableJosue.put("200.5.0.0",new IpData("192.168.100.16", "200.5.0.2", "165.8.0.6",2,0));//paletas
        this.ipTableJosue.put("140.90.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 2,0));//bolinchas
        this.ipTableJosue.put("201.6.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 1,0));//legos
        this.ipTableJosue.put("25.0.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.0.6", 0,2525));//luces

        this.ipTableSilvia = new HashMap<String,IpData>();
        this.ipTableSilvia.put("12.0.0.0",new IpData("127.0.0.1", "12.0.0.8", "165.8.25.6", 0,8888));//banderas
        this.ipTableSilvia.put("200.5.0.0",new IpData("192.168.100.16", "200.5.0.2", "165.8.25.6",1,0));//paletas
        this.ipTableSilvia.put("140.90.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.25.6", 2,0));//bolinchas
        this.ipTableSilvia.put("201.6.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.25.6", 2,0));//legos
        this.ipTableSilvia.put("25.0.0.0",new IpData("192.168.100.16", "12.0.0.8", "165.8.25.6", 1,2525));//luces

        this.oneToOneRelation = new HashMap<String, Pair<String,String>>();
        this.oneToOneRelation.put("165.8.0.6",new Pair<String,String>("127.0.0.1","7777"));//cambiar luego!
        this.oneToOneRelation.put("165.8.25.6",new Pair<String,String>("127.0.0.1","5555"));
    }

    /**
     * Starts the dispatcher server
     */
    public void startDispatcher(){
        Thread thread = new Thread(new DispatcherService(this.ipTableJosue,this.ipTableSilvia,this.oneToOneRelation));
        thread.start();
    }
}
