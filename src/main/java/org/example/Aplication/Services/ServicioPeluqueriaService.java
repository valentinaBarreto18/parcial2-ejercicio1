package org.example.Aplication.Services;

import org.example.Domain.ServicioPeluqueria;
import org.example.Interfaces.ServicioPeluqueriaRepository;

import java.util.List;

public class ServicioPeluqueriaService {
    private final ServicioPeluqueriaRepository repository;

    public ServicioPeluqueriaService(ServicioPeluqueriaRepository repository) {
        this.repository = repository;
    }

    public void crearServicio(ServicioPeluqueria servicio) {
        repository.save(servicio);
    }

    public List<ServicioPeluqueria> listarServicios() {
        return repository.findAll();
    }

    public ServicioPeluqueria buscarServicioPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarServicio(ServicioPeluqueria servicio) {
        repository.update(servicio);
    }

    public void eliminarServicio(ServicioPeluqueria servicio) {
        repository.delete(servicio);
    }

    public ServicioPeluqueria obtenerServicio(int id) {
        return repository.findById(id);
    }
}

