import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by josue on 05/12/17.
 */
public class Maps {

    private Map<String, NodeData> terminalNode1; //197.197.197.0
    private Map<String,NodeData> terminalNode2; //192.118.1.0
    private Map<String,NodeData> terminalNode3; //178.20.2.0
    private Map<String,NodeData> terminalNode4; //123.7.2.0
    private Map<String,NodeData> terminalNode5; //10.4.2.0
    private Map<String,ARPData> arp1;
    private Map<String,ARPData> arp2;
    private Map<String,ARPData> arp3;
    private Map<String,ARPData> arp4;
    private Map<String,ARPData> arp5;
    private Map<String,ARPData> arp6;
    private Map<String,ARPData> arp7;

    public Maps(){
        this.arp1 = new HashMap<String, ARPData>();
        this.arp2 = new HashMap<String, ARPData>();
        this.arp3 = new HashMap<String, ARPData>();
        this.arp4 = new HashMap<String, ARPData>();
        this.arp5 = new HashMap<String, ARPData>();
        this.arp6 = new HashMap<String, ARPData>();
        this.arp7 = new HashMap<String, ARPData>();
        this.fillARPTables();

        this.terminalNode1 = new HashMap<String, NodeData>();
        this.terminalNode2 = new HashMap<String, NodeData>();
        this.terminalNode3 = new HashMap<String, NodeData>();
        this.terminalNode4 = new HashMap<String, NodeData>();
        this.terminalNode5 = new HashMap<String, NodeData>();
        this.fillTerminalNodeTable();
    }

    //formato: Destino + a traves + Ip Real + Puerto
    public void fillTerminalNodeTable() {
        //197.197.197.0
        this.terminalNode1.put("123.7.2.0", new NodeData("197.197.197.4", "127.0.0.1" , 7501));
        this.terminalNode1.put("192.118.1.0",new NodeData("197.197.197.5", "127.0.0.1" , 7004));
        this.terminalNode1.put("178.20.2.0",new NodeData("197.197.197.5", "127.0.0.1" , 7004));
        this.terminalNode1.put("10.4.2.0",new NodeData("197.197.197.4", "127.0.0.1" , 75001));

        //192.118.1.0
        this.terminalNode2.put("123.7.2.0", new NodeData("192.118.1.2", "127.0.0.1" , 5501));
        this.terminalNode2.put("197.197.197.0",new NodeData("192.118.1.20", "127.0.0.1" , 6502));
        this.terminalNode2.put("178.20.2.0",new NodeData("192.118.1.30", "127.0.0.1" , 6003));
        this.terminalNode2.put("10.4.2.0",new NodeData("192.118.1.20", "127.0.0.1" , 6502));

        //178.20.2.0
        this.terminalNode3.put("197.197.197.0", new NodeData("178.20.2.2", "127.0.0.1" , 7001));
        this.terminalNode3.put("123.7.2.0",new NodeData("178.20.2.7", "127.0.0.1" , 6503));
        this.terminalNode3.put("10.4.2.0",new NodeData("178.20.2.2", "127.0.0.1" , 7001));
        this.terminalNode3.put("192.118.1.0",new NodeData("178.20.2.4", "127.0.0.1" , 8502));

        //123.7.2.0
        this.terminalNode4.put("197.197.197.0", new NodeData("123.7.13.3", "127.0.0.1" , 1));
        this.terminalNode4.put("192.118.1.0",new NodeData("123.7.2.6", "127.0.0.1" , 5503));
        this.terminalNode4.put("178.20.2.0",new NodeData("123.7.2.1", "127.0.0.1" , 6501));
        this.terminalNode4.put("10.4.2.0",new NodeData("123.7.13.3", "127.0.0.1" , 8002));

        //10.4.2.0
        this.terminalNode5.put("197.197.197.0",new NodeData("10.4.2.30", "127.0.0.1" , 7502));
        this.terminalNode5.put("123.7.2.0",new NodeData("10.4.2.4", "127.0.0.1" , 8001));
        this.terminalNode5.put("192.118.1.0",new NodeData("10.4.2.5", "127.0.0.1" , 6505));
        this.terminalNode5.put("178.20.2.0",new NodeData("10.4.2.3", "127.0.0.1" , 7002));

    }
    public void fillARPTables(){
        this.arp1.put("192.118.1.2",new ARPData("1.1","1.1","localhost",5501));
        this.arp1.put("123.7.2.3",new ARPData("1.2","1.2","localhost",5502));
        this.arp1.put("123.7.2.6",new ARPData("1.3","1.3","localhost",5503));

        this.arp2.put("192.118.1.2",new ARPData("2.1","2.1","localhost",6001));
        this.arp2.put("178.20.2.2",new ARPData("2.2","2.2","localhost",6002));
        this.arp2.put("192.118.1.30",new ARPData("2.3","2.3","localhost",6003));

        this.arp3.put("123.7.2.1",new ARPData("3.1","3.1","localhost",6501));
        this.arp3.put("192.118.1.20",new ARPData("3.2","3.2","localhost",6502));
        this.arp3.put("178.20.2.7",new ARPData("3.3","3.3","localhost",6503));
        this.arp3.put("10.4.2.4",new ARPData("3.4","3.4","localhost",6504));
        this.arp3.put("10.4.2.5",new ARPData("3.5","3.5","localhost",6505));

        this.arp4.put("178.20.2.2",new ARPData("4.1","4.1","localhost",7001));
        this.arp4.put("10.4.2.3",new ARPData("4.2","4.2","localhost",7002));
        this.arp4.put("10.4.2.6",new ARPData("4.3","4.3","localhost",7003));
        this.arp4.put("197.197.197.5",new ARPData("4.4","4.4","localhost",7004));
        this.arp4.put("178.20.2.7",new ARPData("4.5","4.5","localhost",7005));

        this.arp5.put("197.197.197.4",new ARPData("5.1","5.1","localhost",7501));
        this.arp5.put("10.4.2.30",new ARPData("5.2","5.2","localhost",7502));

        this.arp6.put("192.7.13.1",new ARPData("6.1","6.1","localhost",8001));
        this.arp6.put("192.7.13.2",new ARPData("6.2","6.2","localhost",8002));
        this.arp6.put("192.7.13.3",new ARPData("6.3","6.3","localhost",8003));

        this.arp7.put("178.20.2.30",new ARPData("7.1","7.1","localhost",8501));
        this.arp7.put("178.20.2.4",new ARPData("7.2","7.2","localhost",8502));
        this.arp7.put("178.20.2.20",new ARPData("7.3","7.3","localhost",8503));
    }
}
