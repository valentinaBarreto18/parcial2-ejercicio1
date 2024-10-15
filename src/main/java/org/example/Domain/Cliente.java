package org.example.Domain;

    import java.io.Serializable;

    public class Cliente implements Serializable {
        private static final long serialVersionUID = 1L;
        private int id;
        private String nombre;
        private String servicio;

        public Cliente(int id, String nombre, String servicio) {
            this.id = id;
            this.nombre = nombre;
            this.servicio = servicio;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getServicio() {
            return servicio;
        }

        @Override
        public String toString() {
            return "Cliente{id=" + id + ", nombre='" + nombre + "', servicio='" + servicio + "'}";
        }
    }

