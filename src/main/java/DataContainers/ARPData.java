package DataContainers;

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
    private int internalInterfacePort;

    public ARPData(String externalInterface, String externalInterfaceIp, int externalInterfacePort,int internalInterfacePort) {
        this.externalInterface = externalInterface;
        this.externalInterfaceIp = externalInterfaceIp;
        this.externalInterfacePort = externalInterfacePort;
        this.internalInterfacePort = internalInterfacePort;
    }

    public String getExternalInterface() {
        return this.externalInterface;
    }

    public String getExternalInterfaceIp() {
        return this.externalInterfaceIp;
    }

    public int getExternalInterfacePort() {
        return this.externalInterfacePort;
    }

    public int getInternalInterfacePort() {
        return this.internalInterfacePort;
    }
}
