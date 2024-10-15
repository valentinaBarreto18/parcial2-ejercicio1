package org.example.Interfaces;

import org.example.Domain.Cliente;

public interface ClienteService {
        void registrarCliente(Cliente cliente);
        Cliente obtenerClientePorId(int id);
        void eliminarCliente(int id);
        void mostrarClientes();
    }

