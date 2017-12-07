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


public class NodeData {
    private String path;
    private String realIp;
    private int port;

    public NodeData(String path, String realIp, int port){
        this.path = path;
        this.realIp = realIp;
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public String getRealIp() {
        return realIp;
    }

    public int getPort() {
        return port;
    }

}
