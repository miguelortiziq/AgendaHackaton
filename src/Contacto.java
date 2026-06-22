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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override // Indicamos que estamos sobrescribiendo el método equals.
    public boolean equals(Object obj) { // Método para comparar si dos contactos son iguales.
        if (this == obj) { // Verificamos si ambos objetos son exactamente el mismo.
            return true; // Si son el mismo objeto, retornamos true.
        }

        if (obj == null || getClass() != obj.getClass()) { // Validamos que el objeto no sea null y sea Contacto.
            return false; // Si no cumple, retornamos false.
        }

        Contacto contacto = (Contacto) obj; // Convertimos el objeto recibido a tipo Contacto.

        return this.nombre.equalsIgnoreCase(contacto.nombre); // Comparamos los nombres ignorando mayúsculas y minúsculas.
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

