public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

//Nombres y apellidos no deben estar vacios

/*
Un contacto se considera igual a otro cuando tienen el mismo nombre y
apellido (sin distinguir entre mayúsculas y minúsculas)
*/

    public Contacto(String nombre, String apellido, String telefono) { // Constructor que recibe nombre y teléfono.
        this.nombre = nombre;
        this.apellido=apellido;// Asignamos el nombre recibido al atributo nombre.
        this.telefono = telefono; // Asignamos el teléfono recibido al atributo telefono.

    }


}

