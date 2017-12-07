package Connection;

import DataContainers.ARPData;
import DataContainers.Maps;
import DataContainers.NodeData;

import java.io.DataOutputStream;
import java.util.HashMap;
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
    private Maps maps;
    private String[] arrayMessage;
    private String finalMessage;

    public  Client(Maps maps){
        this.maps = maps;
        this.finalMessage = "";
    }

    /**
     * Checks if the message is for a terminal node or a router and parse the corresponding table.
     * Sends an answer message processing for router o terminal node.
     * @param message The message received from the listening socket
     */
    public void startClient(String message){
        this.arrayMessage = message.split("\n");
        if(this.arrayMessage[0].equalsIgnoreCase("0")){ //es de un terminal
            this.parseMapsForNode();
        } else if(this.arrayMessage[0].equalsIgnoreCase("1")){ //es de un router
            this.parseMapsForRouter();
        } else {
            System.out.println("Invalid message detected!!!");
            return;
        }
        try {
            System.out.println("Sending an answer to: "+this.arrayMessage[3]+" on port "+
                    this.arrayMessage[4] + ":\n"+this.finalMessage);
            super.createSocket("client", Integer.parseInt(this.arrayMessage[4]),this.arrayMessage[3]); //Cambiar a IP real
            this.outServer = new DataOutputStream(this.cs.getOutputStream());
            this.outServer.writeUTF(this.finalMessage);
            this.cs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Parse a physical address table into a String
     */
    private void parseMapsForNode(){
        HashMap<String, NodeData> nodeTable = (HashMap<String, NodeData>) this.getNodeTable(Integer.parseInt(this.arrayMessage[2]));
        Iterator nodeTableIterator = nodeTable.entrySet().iterator();
        while (nodeTableIterator.hasNext()) {
            Map.Entry pair = (Map.Entry)nodeTableIterator.next();
            NodeData nodeData = (NodeData) pair.getValue();
            this.finalMessage = this.finalMessage + pair.getKey() + "," + nodeData.getPath() + "," +
                    nodeData.getRealIp() + "," + nodeData.getPort() + "\n";
            nodeTableIterator.remove(); // avoids a ConcurrentModificationException
        }
    }

    /**
     * Parse a routing table and an ARP table into a String
     */
    private void parseMapsForRouter(){
        HashMap<String,String> routing = (HashMap<String,String>) this.getRoutingTable(Integer.parseInt(this.arrayMessage[2]));
        HashMap<String, ARPData> arp = (HashMap<String, ARPData>) this.getARPTable(Integer.parseInt(this.arrayMessage[2]));
        Iterator arpIterator = arp.entrySet().iterator();
        while (arpIterator.hasNext()) {
            Map.Entry pair = (Map.Entry)arpIterator.next();
            ARPData arpData = (ARPData) pair.getValue();
            this.finalMessage = this.finalMessage + pair.getKey() + "," + arpData.getExternalInterface()
                    + "," + arpData.getExternalInterfaceIp() + "," + arpData.getExternalInterfacePort() + "\n";
            arpIterator.remove(); // avoids a ConcurrentModificationException
        }
        this.finalMessage = this.finalMessage + "-";
        Iterator routingIterator = routing.entrySet().iterator();
        while (routingIterator.hasNext()) {
            Map.Entry pair = (Map.Entry)routingIterator.next();
            this.finalMessage = this.finalMessage + pair.getKey() + "," + pair.getValue() + "\n";
            routingIterator.remove(); // avoids a ConcurrentModificationException
        }
    }

    /**
     * Gets the corresponding Node map depending on host number
     * @param host the host number
     * @return the map
     */
    private Map<String, NodeData> getNodeTable(int host) {
        Map<String, NodeData> map = null;
        switch (host) {
            case 1:
                map = this.maps.getTerminalNode1();
                break;
            case 2:
                map = this.maps.getTerminalNode2();
                break;
            case 3:
                map = this.maps.getTerminalNode3();
                break;
            case 4:
                map = this.maps.getTerminalNode4();
                break;
            case 5:
                map = this.maps.getTerminalNode5();
                break;
        }
        return map;
    }

    /**
     * Gets the corresponding Routing map depending on host number
     * @param host the host number
     * @return the map
     */
    private Map<String, String> getRoutingTable(int host) {
        Map<String, String> map = null;
        switch (host) {
            case 1:
                map = this.maps.getRouting1();
                break;
            case 2:
                map = this.maps.getRouting2();
                break;
            case 3:
                map = this.maps.getRouting3();
                break;
            case 4:
                map = this.maps.getRouting4();
                break;
            case 5:
                map = this.maps.getRouting5();
                break;
            case 6:
                map = this.maps.getRouting6();
                break;
            case 7:
                map = this.maps.getRouting7();
                break;
        }
        return map;
    }

    /**
     * Gets the corresponding ARP map depending on host number
     * @param host the host number
     * @return the map
     */
    private Map<String, ARPData> getARPTable(int host) {
        Map<String, ARPData> map = null;
        switch (host) {
            case 1:
                map = this.maps.getArp1();
                break;
            case 2:
                map = this.maps.getArp2();
                break;
            case 3:
                map = this.maps.getArp3();
                break;
            case 4:
                map = this.maps.getArp4();
                break;
            case 5:
                map = this.maps.getArp5();
                break;
            case 6:
                map = this.maps.getArp6();
                break;
            case 7:
                map = this.maps.getArp7();
                break;
        }
        return map;
    }
}