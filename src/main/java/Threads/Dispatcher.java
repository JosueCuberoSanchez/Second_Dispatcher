package Threads;

import DataContainers.Maps;

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

    public Dispatcher(){
    }

    /**
     * Starts the dispatcher server
     */
    public void startDispatcher(){
        Thread thread = new Thread(new DispatcherService());
        thread.start();
    }
}
