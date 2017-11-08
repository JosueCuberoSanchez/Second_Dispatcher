import javafx.util.Pair;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by josue on 07/11/17.
 */
public class Client extends Connection {
    private Map<String, IpData> ipTable;
    private Map<String,Pair<String,String>> oneToOneRelation;

    public  Client(Map<String,IpData> ipTable,Map<String,Pair<String,String>> oneToOneRelation){
        this.ipTable = ipTable;
        this.oneToOneRelation = oneToOneRelation;
    }

    public void startClient(String message){
        try {
            String[] messageArray = message.split("\n");
            String[] parsedTable = new String[3];
            parsedTable[0] = "";
            if(messageArray[0].equalsIgnoreCase("1")) {
                parsedTable = this.parseTableForRouter(parsedTable,messageArray);
            } else {
                parsedTable = this.parseTableForNode(parsedTable,messageArray);
            }
            super.createSocket("client",Integer.parseInt(parsedTable[1]),parsedTable[2]);
            this.outServer = new DataOutputStream(this.cs.getOutputStream());
            this.outServer.writeUTF(parsedTable[0]);
            this.cs.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String[] parseTableForNode(String[] parsedTable,String[] messageArray){
        Iterator iterator = this.oneToOneRelation.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry pair = (Map.Entry) iterator.next();
            parsedTable[0] = parsedTable[0] + pair.getKey().toString() + ",";
            Pair<String,String> par = (Pair<String,String>)pair.getValue();
            parsedTable[0] = parsedTable[0] + par.getKey() + "," + par.getValue() + "\n";
        } //ya aca tiene el campo de mensaje lleno ak7
        this.getPortAndIp(messageArray,parsedTable);
        return parsedTable;
    }

    public String[] parseTableForRouter(String[] parsedTable,String[] messageArray){
        Iterator iterator = this.ipTable.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry pair = (Map.Entry) iterator.next();
            parsedTable[0] = parsedTable[0] + pair.getKey().toString() + ",";
            IpData ipData = (IpData)pair.getValue();
            parsedTable[0] = parsedTable[0] + ipData.getRealIp() + "," + ipData.getFakeIp() + "," +
                    ipData.getFakePath() + "," + ipData.getDistance() + "," + ipData.getPort() + "\n";
        } //ya aca tiene el campo de mensaje lleno ak7
        this.getPortAndIp(messageArray,parsedTable);
        return parsedTable;
    }

    public void getPortAndIp(String[] messageArray,String[] parsedTable){
        parsedTable[1] = messageArray[4];
        parsedTable[2] = messageArray[2];
    }
}