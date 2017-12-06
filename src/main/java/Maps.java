import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;


public class Maps {

    private HashMap<String, String> routing1;
    private HashMap<String, String> routing2;
    private HashMap<String, String> routing3;
    private HashMap<String, String> routing4;
    private HashMap<String, String> routing5;
    private HashMap<String, String> routing6;
    private HashMap<String, String> routing7;



    public Maps(){
        this.routing1 = new HashMap<String, String>();
        this.routing2 = new HashMap<String, String>();
        this.routing3 = new HashMap<String, String>();
        this.routing4 = new HashMap<String, String>();
        this.routing5 = new HashMap<String, String>();
        this.routing6 = new HashMap<String, String>();
        this.routing7 = new HashMap<String, String>();
    }

    public void filRoutingTables(){
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

}
