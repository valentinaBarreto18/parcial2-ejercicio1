package org.example.Aplicacion.Service;

import org.example.Domain.Cliente;
import org.example.Interfaces.ClienteService;

public class Main {

        public static void main(String[] args) {
            ClienteService service = new ClienteServiceImpl();


            service.registrarCliente(new Cliente(1, "santiago", "Corte de cabello"));
            service.registrarCliente(new Cliente(2, "ana", "Manicure, pestañas"));


            System.out.println("\nLista de clientes:");
            service.mostrarClientes();


            System.out.println("\nBuscar cliente con ID 1:");
            service.obtenerClientePorId(1);

            System.out.println("\nEliminar cliente con ID 2:");
            service.eliminarCliente(2);


            System.out.println("\nLista de clientes después de eliminación:");
            service.mostrarClientes();
        }
    }

