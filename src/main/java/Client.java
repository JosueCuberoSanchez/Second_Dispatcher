import javafx.util.Pair;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/*/**
 * Universidad de Costa Rica
 * Facultad de Ingeniería
 * Escuela de Ciencias de la Computación e Informática
 * Profesora: Gabriela Barrantes
 * Autores:
 * Abellán Jiménez Mariana B50031
 * Brenes Solano Silvia B41133
 * Cubero Sánchez Josué B42190
 */
public class Client extends Connection {
    private Map<String, IpData> ipTableJosue;
    private Map<String, IpData> ipTableSilvia;
    private Map<String,Pair<String,String>> oneToOneRelation;

    public  Client(Map<String,IpData> ipTableJosue,Map<String,IpData> ipTableSilvia,Map<String,Pair<String,String>> oneToOneRelation){
        this.ipTableJosue = ipTableJosue;
        this.ipTableSilvia = ipTableSilvia;
        this.oneToOneRelation = oneToOneRelation;
    }

    /**
     * Checks if the message is for a terminal node or a router and parse the corresponding table.
     * Sends an answer message processing for router o terminal node.
     * @param message The message received from the listening socket
     */
    public void startClient(String message){
        try {
            String[] messageArray = message.split("\n");
            String[] parsedTable = new String[3];
            parsedTable[0] = "";
            if(messageArray[0].equalsIgnoreCase("1")) {
                if(messageArray[3].equalsIgnoreCase("CRR6")) { //es josue
                    System.out.println("HOLA");
                    parsedTable = this.parseTableForRouter(parsedTable, messageArray,true);
                } else {
                    parsedTable = this.parseTableForRouter(parsedTable, messageArray,false);
                }
            } else {
                parsedTable = this.parseTableForNode(parsedTable,messageArray);
            }
            super.createSocket("client",Integer.parseInt(parsedTable[1]),parsedTable[2]);
            this.outServer = new DataOutputStream(this.cs.getOutputStream());
            System.out.println("Enviando\n" + parsedTable[0] + "a: " + parsedTable[1] + ", " + parsedTable[2]);
            this.outServer.writeUTF(parsedTable[0]);
            this.cs.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Parse a physical address table into a String
     * @param parsedTable a 3 position array to store destiny ip, destiny port and the final message
     * @param messageArray the message received from the socket split by \n
     * @return the parsedTable received by parameter, filled
     */
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

    /**
     * Parse a routing table into a String
     * @param parsedTable a 3 position array to store destiny ip, destiny port and the final message
     * @param messageArray the message received from the socket split by \n
     * @param router a boolean that defines to which router the table is going
     * @return the parsedTable received by parameter, filled
     */
    public String[] parseTableForRouter(String[] parsedTable,String[] messageArray, boolean router){
        Map<String,IpData> temporalMap;
        if(router){
            temporalMap = this.ipTableJosue;
        } else {
            temporalMap = this.ipTableSilvia;
        }
        Iterator iterator = temporalMap.entrySet().iterator();
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

    /**
     * Fills the missing fields from the message array (ip and port)
     * @param parsedTable a 3 position array to store destiny ip, destiny port and the final message
     * @param messageArray the message received from the socket split by \n
     */
    public void getPortAndIp(String[] messageArray,String[] parsedTable){
        parsedTable[1] = messageArray[4];
        parsedTable[2] = messageArray[2];
    }
}