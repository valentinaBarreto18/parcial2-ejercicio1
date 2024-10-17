package org.example.Interfaces;

import org.example.Domain.ServicioPeluqueria;

import java.util.List;

public interface ServicioPeluqueriaRepository {
    void save(ServicioPeluqueria servicio);

    List<ServicioPeluqueria> findAll();

    ServicioPeluqueria findById(int id);

    void delete(ServicioPeluqueria servicio);

    void update(ServicioPeluqueria servicio);
}

