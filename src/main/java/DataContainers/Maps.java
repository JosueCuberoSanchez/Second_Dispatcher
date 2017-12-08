package DataContainers;

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

    private Map<String, String> routing1;
    private Map<String, String> routing2;
    private Map<String, String> routing3;
    private Map<String, String> routing4;
    private Map<String, String> routing5;
    private Map<String, String> routing6;
    private Map<String, String> routing7;


    private Map<String, ARPData> arp1;
    private Map<String,ARPData> arp2;
    private Map<String,ARPData> arp3;
    private Map<String,ARPData> arp4;
    private Map<String,ARPData> arp5;
    private Map<String,ARPData> arp6;
    private Map<String,ARPData> arp7;

    public Maps(){
        this.routing1 = new HashMap<String, String>();
        this.routing2 = new HashMap<String, String>();
        this.routing3 = new HashMap<String, String>();
        this.routing4 = new HashMap<String, String>();
        this.routing5 = new HashMap<String, String>();
        this.routing6 = new HashMap<String, String>();
        this.routing7 = new HashMap<String, String>();
        this.fillRoutingTables();

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

    public void fillRoutingTables() {
        routing1.put("197.197.197.0", "127.7.1.6");
        routing1.put("10.4.2.0", "127.7.1.6");
        routing1.put("192.118.1.0", "192.118.1.50");
        routing1.put("178.20.2.0", "192.118.1.2");
        routing1.put("123.7.2.0", "123.7.2.50");

        routing2.put("197.197.197.0", "178.20.2.4");
        routing2.put("10.4.2.0", "192.118.1.30");
        routing2.put("192.118.1.10", "192.118.1.50");
        routing2.put("178.20.2.0", "178.20.2.50");
        routing2.put("123.7.2.0", "123.7.2.50");

        routing3.put("197.197.197.0", "10.4.2.5");
        routing3.put("10.4.2.0", "10.4.2.50");
        routing3.put("192.118.1.10", "192.118.1.50");
        routing3.put("178.20.2.0", "178.20.2.50");
        routing3.put("123.7.2.0", "123.7.2.50");

        routing4.put("197.197.197.0", "197.197.197.50");
        routing4.put("10.4.2.0", "10.4.2.50");
        routing4.put("192.118.1.10", "10.4.2.3");
        routing4.put("178.20.2.0", "178.20.2.50");
        routing4.put("123.7.2.0", "10.4.2.3");

        routing5.put("197.197.197.0", "197.197.197.50");
        routing5.put("10.4.2.0", "10.4.2.50");
        routing5.put("192.118.1.10", "10.4.2.30");
        routing5.put("178.20.2.0", "197.197.197.4");
        routing5.put("123.7.2.0", "10.4.2.30");

        routing6.put("197.197.197.0", "10.4.2.4");
        routing6.put("10.4.2.0", "10.4.2.50");
        routing6.put("192.118.1.10", "123.7.2.3");
        routing6.put("178.20.2.0", "10.4.2.4");
        routing6.put("123.7.2.0", "123.7.2.50");

        routing7.put("197.197.197.0", "178.20.2.4");
        routing7.put("10.4.2.0", "178.20.2.4");
        routing7.put("192.118.1.10", "178.20.2.20");
        routing7.put("178.20.2.0", "178.20.2.50");
        routing7.put("123.7.2.0", "178.20.2.20");
    }

    //formato: Destino + a traves + Ip Real + Puerto
    public void fillTerminalNodeTable() {
        //197.197.197.0
        this.terminalNode1.put("123.7.2.0", new NodeData("197.197.197.4", "127.0.0.1" , 7501));
        this.terminalNode1.put("192.118.1.0",new NodeData("197.197.197.5", "127.0.0.1" , 7004));
        this.terminalNode1.put("178.20.2.0",new NodeData("197.197.197.5", "127.0.0.1" , 7004));
        this.terminalNode1.put("10.4.2.0",new NodeData("197.197.197.4", "127.0.0.1" , 7501));

        //192.118.1.0
        this.terminalNode2.put("123.7.2.0", new NodeData("192.118.1.2", "127.0.0.1" , 5501));
        this.terminalNode2.put("197.197.197.0",new NodeData("192.118.1.20", "127.0.0.1" , 6502));
        this.terminalNode2.put("178.20.2.0",new NodeData("192.118.1.30", "127.0.0.1" , 6003));
        this.terminalNode2.put("10.4.2.0",new NodeData("192.118.1.20", "127.0.0.1" , 6502));

        //178.20.2.0
        this.terminalNode3.put("197.197.197.0", new NodeData("178.20.2.2", "127.0.0.1" , 7001));
        this.terminalNode3.put("123.7.2.0",new NodeData("178.20.2.7", "127.0.0.1" , 7005));
        this.terminalNode3.put("10.4.2.0",new NodeData("178.20.2.2", "127.0.0.1" , 7001));
        this.terminalNode3.put("192.118.1.0",new NodeData("178.20.2.4", "127.0.0.1" , 8503));

        //123.7.2.0
        this.terminalNode4.put("197.197.197.0", new NodeData("123.7.13.3", "127.0.0.1" , 8002));
        this.terminalNode4.put("192.118.1.0",new NodeData("123.7.2.6", "192.168.56.1" , 5503));
        this.terminalNode4.put("178.20.2.0",new NodeData("123.7.2.1", "127.0.0.1" , 6501));
        this.terminalNode4.put("10.4.2.0",new NodeData("123.7.13.3", "127.0.0.1" , 8002));

        //10.4.2.0
        this.terminalNode5.put("197.197.197.0",new NodeData("10.4.2.30", "127.0.0.1" , 7502));
        this.terminalNode5.put("123.7.2.0",new NodeData("10.4.2.40", "127.0.0.1" , 8001));
        this.terminalNode5.put("192.118.1.0",new NodeData("10.4.2.5", "127.0.0.1" , 6505));
        this.terminalNode5.put("178.20.2.0",new NodeData("10.4.2.3", "127.0.0.1" , 7002));

    }
    public void fillARPTables(){
        this.arp1.put("192.118.1.2",new ARPData("192.118.1.25","192.168.56.1",6002,5501));
        this.arp1.put("123.7.2.3",new ARPData("123.7.2.1","10.1.130.141",6501,5502));
        this.arp1.put("123.7.2.6",new ARPData("123.7.13.3","10.1.130.141",8002,5503));
        this.arp1.put("192.118.1.50",new ARPData("192.118.1.50","10.1.130.130",9005,5501));
        this.arp1.put("123.7.2.50",new ARPData("123.7.2.50","10.1.152.70",9004,5503));

        this.arp2.put("192.118.1.25",new ARPData("192.118.1.2","192.168.56.1",5501,6001));
        this.arp2.put("178.20.2.4",new ARPData("178.20.2.20","192.168.56.1",8501,6002));
        this.arp2.put("192.118.1.30",new ARPData("192.118.1.20","192.168.56.1",6502,6003));
        this.arp2.put("192.118.1.50",new ARPData("192.118.1.50","10.1.130.130",9005,6001));
        this.arp2.put("178.20.2.50",new ARPData("178.20.2.50","10.1.130.117",9003,6002));

        this.arp3.put("123.7.2.1",new ARPData("123.7.2.3","10.1.130.110",5502,6501));
        this.arp3.put("192.118.1.20",new ARPData("192.118.1.30","10.1.130.110",6003,6502));
        this.arp3.put("178.20.2.7",new ARPData("178.20.2.30","10.1.130.110",8502,6503));
        this.arp3.put("10.4.2.4",new ARPData("10.4.2.3","10.1.130.110",7002,6504));
        this.arp3.put("10.4.2.5",new ARPData("10.4.1.30","10.1.130.110",7502,6505));
        this.arp3.put("123.7.2.50",new ARPData("123.7.2.50","10.1.152.70",9004,6501));
        this.arp3.put("192.118.1.50",new ARPData("192.118.1.50","10.1.130.130",9005,6502));
        this.arp3.put("178.20.2.50",new ARPData("178.20.2.50","10.1.130.117",9003,6503));
        this.arp3.put("10.4.2.0",new ARPData("10.4.2.0","localhost",9002,6505));

        //this.arp4.put("178.20.2.2",new ARPData("178.20.2.4","localhost",6002));
        this.arp4.put("10.4.2.3",new ARPData("10.4.2.4","localhost",6504,7002));
        this.arp4.put("10.4.2.6",new ARPData("10.4.2.40","localhost",8001,7003));
        this.arp4.put("197.197.197.5",new ARPData("197.197.197.4","localhost",7501,7004));
        this.arp4.put("178.20.2.7",new ARPData("178.20.2.4","localhost",8503,7005));
        this.arp4.put("178.20.2.50",new ARPData("178.20.2.50","localhost",9003,7001));
        this.arp4.put("197.197.197.50",new ARPData("197.197.197.50","localhost",9001,7004));
        this.arp4.put("10.4.2.50",new ARPData("10.4.2.50","localhost",9002,7003));

        this.arp5.put("197.197.197.4",new ARPData("197.197.197.5","localhost",7004,7501));
        this.arp5.put("10.4.2.30",new ARPData("10.4.2.5","localhost",6505,7502));
        this.arp5.put("10.4.2.50",new ARPData("10.4.2.50","localhost",9002,7502));
        this.arp5.put("197.197.197.50",new ARPData("197.197.197.50","localhost",9001,7501));

        this.arp6.put("10.4.2.40",new ARPData("10.4.2.6","localhost",7003,8001));
        this.arp6.put("123.7.13.3",new ARPData("127.7.1.6","localhost",5503,8002));
        this.arp6.put("10.4.2.50",new ARPData("10.4.2.50","localhost",9002,8001));
        this.arp6.put("123.7.2.50",new ARPData("123.7.2.50","localhost",9004,8002));

        this.arp7.put("178.20.2.20",new ARPData("178.20.2.4","localhost",6002,8501));
        this.arp7.put("178.20.2.30",new ARPData("178.20.2.7","localhost",6503,8502));
        this.arp7.put("178.20.2.4",new ARPData("178.20.2.7","localhost",7005,8503));
        this.arp7.put("178.20.2.50",new ARPData("178.20.2.50","localhost",9003,8502));
    }

    public Map<String, NodeData> getTerminalNode1() {
        return this.terminalNode1;
    }

    public Map<String, NodeData> getTerminalNode2() {
        return this.terminalNode2;
    }

    public Map<String, NodeData> getTerminalNode3() {
        return this.terminalNode3;
    }

    public Map<String, NodeData> getTerminalNode4() {
        return this.terminalNode4;
    }

    public Map<String, NodeData> getTerminalNode5() {
        return this.terminalNode5;
    }

    public Map<String, String> getRouting1() {
        return this.routing1;
    }

    public Map<String, String> getRouting2() {
        return this.routing2;
    }

    public Map<String, String> getRouting3() {
        return this.routing3;
    }

    public Map<String, String> getRouting4() {
        return this.routing4;
    }

    public Map<String, String> getRouting5() {
        return this.routing5;
    }

    public Map<String, String> getRouting6() {
        return this.routing6;
    }

    public Map<String, String> getRouting7() {
        return this.routing7;
    }

    public Map<String, ARPData> getArp1() {
        return this.arp1;
    }

    public Map<String, ARPData> getArp2() {
        return this.arp2;
    }

    public Map<String, ARPData> getArp3() {
        return this.arp3;
    }

    public Map<String, ARPData> getArp4() {
        return this.arp4;
    }

    public Map<String, ARPData> getArp5() {
        return this.arp5;
    }

    public Map<String, ARPData> getArp6() {
        return this.arp6;
    }

    public Map<String, ARPData> getArp7() {
        return this.arp7;
    }
}
