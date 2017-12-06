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
    private String label;
    private String physicalAddress;
    private String realIp;
    private int port;

    public ARPData(String label,String physicalAddress,String realIp,int port){
        this.label = label;
        this.physicalAddress = physicalAddress;
        this.realIp = realIp;
        this.port = port;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhysicalAddress() {
        return this.physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getRealIp() {
        return this.realIp;
    }

    public void setRealIp(String realIp) {
        this.realIp = realIp;
    }
}
