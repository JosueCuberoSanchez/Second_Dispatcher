import javafx.util.Pair;

import java.io.IOException;
import java.util.Map;

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
public class DispatcherService implements Runnable {
    private Maps maps;
    private Server server;

    public DispatcherService(Maps maps){
        this.maps = maps;
    }

    public void run() {
        this.server = new Server(this.maps);
        try {
            this.server.startServer();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
