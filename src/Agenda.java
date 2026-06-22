import java.util.HashMap;

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

}