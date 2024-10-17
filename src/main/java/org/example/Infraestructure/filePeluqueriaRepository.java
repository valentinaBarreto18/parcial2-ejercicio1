package org.example.Infraestructure;

import org.example.Domain.ServicioPeluqueria;
import org.example.Interfaces.ServicioPeluqueriaRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class filePeluqueriaRepository implements ServicioPeluqueriaRepository {
    private static final String FILE_NAME = "ServiciosPeluqueria.dat";

    @Override
    public void save(ServicioPeluqueria servicio) {
        List<ServicioPeluqueria> servicios = findAll();
        servicios.add(servicio);
        saveAll(servicios);
    }

    @Override
    public List<ServicioPeluqueria> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<ServicioPeluqueria>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public ServicioPeluqueria findById(int id) {
        return findAll().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(ServicioPeluqueria servicio) {
        List<ServicioPeluqueria> servicios = findAll();
        servicios.removeIf(e -> e.getId() == servicio.getId());
        saveAll(servicios);
    }

    @Override
    public void update(ServicioPeluqueria servicio) {
        List<ServicioPeluqueria> servicios = findAll();
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getId() == servicio.getId()) {
                servicios.set(i, servicio);
                break;
            }
        }
        saveAll(servicios);
    }

    private void saveAll(List<ServicioPeluqueria> servicios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(servicios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}