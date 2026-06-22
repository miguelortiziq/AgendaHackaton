import java.util.HashMap;

public class Agenda {
    private HashMap<String, Contacto> contactos = new HashMap<>();
    static private int contadorContactos; // Variable que cuenta cuántos contactos hay guardados.



    public Agenda() { // Constructor por defecto.

        contactos = new HashMap<>(10);
        // Creamos una agenda con tamaño por defecto de 10.
        this.contadorContactos = 0; // Inicializamos el contador en cero.

    }

}