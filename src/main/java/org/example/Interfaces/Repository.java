package org.example.Interfaces;

import org.example.Domain.Cliente;

import java.util.List;

public interface Repository {
    void guardar(Cliente cliente);
    List<Cliente> obtenerTodos();
    Cliente buscarPorId(int id);
    void eliminar(int id);
}
