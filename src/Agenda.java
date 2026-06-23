import java.util.*;

public class Agenda {
    private HashMap<String, Contacto> contactos = new HashMap<>();
    static private int contadorContactos; // Variable que cuenta cuántos contactos hay guardados.


    public Agenda() { // Constructor por defecto.

        contactos = new HashMap<>(10);
        // Creamos una agenda con tamaño por defecto de 10.
        this.contadorContactos = 0; // Inicializamos el contador en cero.

    }

    public void añadirContacto(Contacto contacto) {

        // Verificamos si el contacto ya existe en el HashMap.
        if (existeContacto(contacto)) {

            // Mostramos mensaje indicando que el contacto ya está registrado.
            System.out.println("El contacto ya existe en la agenda.");

            // Terminamos la ejecución del método.
            return;
        }

        // Verificamos si la agenda llegó a su capacidad máxima.
        if (agendaLlena()) {

            // Mostramos mensaje indicando que no hay espacio disponible.
            System.out.println("La agenda está llena. No se pueden agregar más contactos.");

            // Terminamos la ejecución del método.
            return;
        }

        // Agregamos el contacto al HashMap.
        // La clave será el nombre del contacto.
        // El valor será el objeto Contacto completo.
        contactos.put(contacto.getNombre(), contacto);

        // Mostramos mensaje de éxito.
        System.out.println("Contacto agregado correctamente.");
    }

    public boolean existeContacto(Contacto contacto) {

        // Obtenemos el nombre del contacto recibido.
        String nombre = contacto.getNombre();

        // Verificamos si existe una clave con ese nombre.
        if (contactos.containsKey(nombre)) {

            // El contacto existe.
            return true;
        }

        // El contacto no existe.
        return false;
    }


    public void agendaLlena(Agenda miAgenda) {
        int limiteMaximo = 10;

        if (contadorContactos>= limiteMaximo) {

            System.out.println("No hay espacio disponible para nuevos contactos. La agenda está llena.");
        }
    }

    public int espacioLibres() { // Método para saber cuántos espacios libres quedan.
        return contactos.length - contadorContactos; // Restamos el tamaño total menos los contactos ocupados.
    }


// Metodo Listar Contacto

    public Map<String, Contacto> listarContactos() {
        //Se crea lista

        List<Map.Entry<String, Contacto>> lista = new ArrayList<>(contactos.entrySet());

        //Se ordena llamando con getNombre

        Collections.sort(lista, new Comparator<Map.Entry<String, Contacto>>() {
            @Override
            public int compare(Map.Entry<String, Contacto> parejaUno, Map.Entry<String, Contacto> parejaDos) {
                return parejaUno.getValue().getNombre().compareToIgnoreCase(parejaDos.getValue().getNombre());
            } //compare
        });

        //Guardar el orden
        Map<String, Contacto> mapaContacto = new LinkedHashMap<>();
        for (Map.Entry<String, Contacto> entrada : lista) {
            mapaContacto.put(entrada.getKey(), entrada.getValue());
        } //for

        return mapaContacto;

   }


    //Genera una clave única en minúsculas para asegurar que no se distinga entre mayúsculas y minúsculas.

    private String generarClave(String nombre, String apellido) {
        return (nombre.trim() + "_" + apellido.trim()).toLowerCase();
    }//generarClave



    public void eliminarContacto(Contacto c) {
        if (c == null) {
            System.out.println("Seleccione un contacto");
            return;
        }

        String clave = generarClave(c.getNombre(), c.getApellido());

        if (contactos.containsKey(clave)) {
            contactos.remove(clave);
            contadorContactos--;
            System.out.println("El contacto " + c.getNombre() + " " + c.getApellido() + " ha sido eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar; El contacto " + c.getNombre() + " " + c.getApellido() + " no existe en la agenda.");
        }
    }//eliminarContacto


    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        if (nombre == null || apellido == null) {
            System.out.println("Deben existir nombre y apellido");
            return;
        }

        String clave = generarClave(nombre, apellido);

        if (contactos.containsKey(clave)) {
            Contacto contacto = contactos.get(clave);
            contacto.setTelefono(nuevoTelefono);
            System.out.println("El teléfono de " + nombre + " " + apellido + " ha sido modificado con éxito.");
        } else {
            System.out.println("No se pudo modificar: El contacto " + nombre + " " + apellido + " no existe.");
        }
    }//modificarTelefono

    //busca contacto

    public void buscaContacto(String nombre, String apellido) {
        if (nombre == null || apellido == null) {
            System.out.println("El nombre y el apellido no pueden ser nulos.");
            return;
        }

        String clave = generarClave(nombre, apellido);

        if (contactos.containsKey(clave)) {
            Contacto contactoEncontrado = contactos.get(clave);
            System.out.println("Teléfono: " + contactoEncontrado.getTelefono());
        } else {
            System.out.println("No se ha encontrado el contacto.");
        }
    }

}


}//classAgenda