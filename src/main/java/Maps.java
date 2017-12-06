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
public class Maps {

    private Map<String, String> routing1;
    private Map<String, String> routing2;
    private Map<String, String> routing3;
    private Map<String, String> routing4;
    private Map<String, String> routing5;
    private Map<String, String> routing6;
    private Map<String, String> routing7;


    private Map<String,ARPData> arp1;
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
    }

    public void fillRoutingTables() {
        routing1.put("197.197.197.0", "127.7.1.6");
        routing1.put("10.4.2.0", "127.7.1.6");
        routing1.put("192.118.1.10", "192.118.1.50");
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
