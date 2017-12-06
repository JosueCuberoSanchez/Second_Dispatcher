/**
 * Created by josue on 06/12/17.
 */
public class ARPData {
    private String externalInterface;
    private String externalInterfaceIp;
    private int externalInterfacePort;

    public ARPData(String externalInterface, String externalInterfaceIp, int externalInterfacePort) {
        this.externalInterface = externalInterface;
        this.externalInterfaceIp = externalInterfaceIp;
        this.externalInterfacePort = externalInterfacePort;
    }

    public String getExternalInterface() {
        return this.externalInterface;
    }

    public void setExternalInterface(String externalInterface) {
        this.externalInterface = externalInterface;
    }

    public String getExternalInterfaceIp() {
        return this.externalInterfaceIp;
    }

    public void setExternalInterfaceIp(String externalInterfaceIp) {
        this.externalInterfaceIp = externalInterfaceIp;
    }

    public int getExternalInterfacePort() {
        return this.externalInterfacePort;
    }

    public void setExternalInterfacePort(int externalInterfacePort) {
        this.externalInterfacePort = externalInterfacePort;
    }
}
