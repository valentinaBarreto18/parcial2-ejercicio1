package org.example.Aplication.Services;


import org.example.Infraestructure.filePeluqueriaRepository;
import org.example.Interfaces.ServicioPeluqueriaRepository;

public class Main {
    public static void main(String[] args) {
        ServicioPeluqueriaRepository repo = new filePeluqueriaRepository();
        ServicioPeluqueriaService servicio = new ServicioPeluqueriaService(repo);

        Menu m = new Menu(servicio);

        m.run();
    }
}


