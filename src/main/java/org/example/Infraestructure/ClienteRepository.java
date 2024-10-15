package org.example.Infraestructure;
import org.example.Domain.Cliente;
import org.example.Interfaces.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


    public class ClienteRepository implements Repository {
        private final String archivo = "clientes.dat";

        @Override
        public void guardar(Cliente cliente) {
            List<Cliente> clientes = obtenerTodos();
            clientes.add(cliente);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                oos.writeObject(clientes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public List<Cliente> obtenerTodos() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (List<Cliente>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                return new ArrayList<>();
            }
        }

        @Override
        public Cliente buscarPorId(int id) {
            return obtenerTodos().stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        }

        @Override
        public void eliminar(int id) {
            List<Cliente> clientes = obtenerTodos();
            clientes.removeIf(c -> c.getId() == id);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                oos.writeObject(clientes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

