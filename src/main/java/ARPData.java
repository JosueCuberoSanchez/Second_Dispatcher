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
