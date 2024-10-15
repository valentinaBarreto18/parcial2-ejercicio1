package escrito;

public interface Persona {
    String getNombre();
    void setNombre(String nombre);
    String getApellido();
    int getEdad();
    void setEdad(int edad);
}
class PersonaImpl implements Persona{
    private String nombre, apellido;
    private int edad;
    PersonaImpl(String nombre,String apellido,int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    public String
}
