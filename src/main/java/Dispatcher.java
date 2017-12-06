import javafx.util.Pair;

import java.util.HashMap;
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

public class Dispatcher {
    private Maps maps;

    public Dispatcher(){
        this.maps = new Maps();
    }

    /**
     * Starts the dispatcher server
     */
    public void startDispatcher(){
        Thread thread = new Thread(new DispatcherService(this.maps));
        thread.start();
    }
}
