import java.util.*;

public class Agenda {
    private HashMap<String, Contacto> contactos = new HashMap<>();
    static private int contadorContactos; // Variable que cuenta cuántos contactos hay guardados.


    public Agenda() { // Constructor por defecto.

        contactos = new HashMap<>(10);
        // Creamos una agenda con tamaño por defecto de 10.
        this.contadorContactos = 0; // Inicializamos el contador en cero.

    }

    public void añadirContacto(Contacto contacto) { // Método para añadir un contacto.
        if (existeContacto(contacto)) { // Verificamos si el contacto ya existe.
            System.out.println("El contacto ya existe en la agenda."); // Mostramos mensaje si está repetido.
            return; // Terminamos el método.
        }

        if (agendaLlena()) { // Verificamos si la agenda está llena.
            System.out.println("La agenda está llena. No se pueden agregar más contactos."); // Mostramos mensaje.
            return; // Terminamos el método.
        }

        contactos[contadorContactos] = contacto; // Guardamos el contacto en la posición disponible.
        contadorContactos++; // Aumentamos el contador de contactos.
        System.out.println("Contacto agregado correctamente."); // Mostramos mensaje de éxito.
    }

    public boolean existeContacto(Contacto contacto) { // Método que verifica si un contacto existe.
        for (int i = 0; i < contadorContactos; i++) { // Recorremos solo las posiciones ocupadas.
            if (contactos[i].equals(contacto)) { // Comparamos el contacto actual con el recibido.
                return true; // Si existe, retornamos true.
            }
        }

        return false; // Si no se encontró, retornamos false.
    }


    public boolean agendaLlena() { // Método para saber si la agenda está llena.
        return contadorContactos == contactos.length; // Retorna true si el contador es igual al tamaño del arreglo.
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



}//classAgenda