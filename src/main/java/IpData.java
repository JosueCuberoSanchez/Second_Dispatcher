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
public class IpData {
    private String finalDestinyIp;
    private String exitInterface;
    private int exitPort;
    private String nextInterface;

    public IpData(String finalDestinyIp,String exitInterface, int exitPort, String nextInterface){
        this.finalDestinyIp = finalDestinyIp;
        this.exitInterface = exitInterface;
        this.exitPort = exitPort;
        this.nextInterface = nextInterface;
    }

}