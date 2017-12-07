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
public class DispatcherService implements Runnable {
    private Maps maps;
    private Connection.Server server;

    public DispatcherService(Maps maps){
        this.maps = maps;
    }

    public void run() {
        this.server = new Connection.Server(this.maps);
        try {
            this.server.startServer();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
