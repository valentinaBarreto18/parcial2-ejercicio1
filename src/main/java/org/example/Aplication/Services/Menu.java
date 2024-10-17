package org.example.Aplication.Services;


import org.example.Domain.ServicioPeluqueria;

import javax.swing.*;

public class Menu {
    private final ServicioPeluqueriaService servicioPeluqueriaService;

    public Menu(ServicioPeluqueriaService servicioPeluqueriaService) {
        this.servicioPeluqueriaService = servicioPeluqueriaService;
    }

    public void run() {
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido elija una opción: \n1. Registrar servicio \n2. Borrar servicio \n3. Actualizar servicio \n4. Lista de servicios \n5. Buscar servicio \n6. Salir del programa"));
            switch (opcion) {
                case 1:
                    registrarServicio();
                    break;
                case 2:
                    borrarServicio();
                    break;
                case 3:
                    actualizarServicio();
                    break;
                case 4:
                    listaServicios();
                    break;
                case 5:
                    buscarServicio();
                    break;
                case 6:
                    return;
            }
        }
    }

    public void registrarServicio() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Asignele un ID al servicio"));
        String nombreServicio = JOptionPane.showInputDialog("Ingrese el nombre del servicio");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del servicio");
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del servicio (en enteros, sin decimales)"));

        ServicioPeluqueria servicio = new ServicioPeluqueria(id, nombreServicio, descripcion, precio);

        servicioPeluqueriaService.crearServicio(servicio);
        JOptionPane.showMessageDialog(null,"Servicio registrado correctamente");
    }

    public void borrarServicio() {
        int busqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio para borrarlo del sistema"));

        ServicioPeluqueria servicio = servicioPeluqueriaService.buscarServicioPorId(busqueda);

        if (servicio != null) {
            servicioPeluqueriaService.eliminarServicio(servicio);
            JOptionPane.showMessageDialog(null, "Servicio eliminado con éxito");
        } else {
            JOptionPane.showMessageDialog(null,"Servicio no encontrado");
        }
    }

    public void actualizarServicio() {
        int busqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio para actualizarlo en el sistema"));

        ServicioPeluqueria servicio = servicioPeluqueriaService.buscarServicioPorId(busqueda);
        if (servicio != null) {
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del servicio");
            if (!nuevoNombre.isEmpty()) {
                servicio.setNombreServicio(nuevoNombre);
            }
            String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del servicio");
            if (!nuevaDescripcion.isEmpty()) {
                servicio.setDescripcion(nuevaDescripcion);
            }

            int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio del servicio (en enteros, sin decimales): "));
            servicio.setPrecio(nuevoPrecio);

            servicioPeluqueriaService.actualizarServicio(servicio);
            JOptionPane.showMessageDialog(null,"Servicio actualizado con éxito");
        } else {
            JOptionPane.showMessageDialog(null,"Servicio no encontrado");
        }
    }

    public void buscarServicio() {
        String busqueda = JOptionPane.showInputDialog("Ingrese el ID del servicio para buscarlo en el sistema");

        ServicioPeluqueria servicio = servicioPeluqueriaService.buscarServicioPorId(Integer.parseInt(busqueda));

        if (servicio != null) {
            JOptionPane.showMessageDialog(null,"SERVICIO: " + " [ID = " + servicio.getId() + "]" + " [Nombre = " + servicio.getNombreServicio() + "]" + " [Descripción = " + servicio.getDescripcion() + "]" + " [Precio = " + servicio.getPrecio() + "]");
        } else {
            JOptionPane.showMessageDialog(null,"Servicio no encontrado");
        }
    }

    public void listaServicios() {
        System.out.println("Lista de servicios: \n");
        servicioPeluqueriaService.listarServicios().forEach(System.out::println);
    }
}




