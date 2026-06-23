import java.util.Map;

public class Main {


   public static void main(String[] args) {
       // Crear la agenda
       Agenda agenda = new Agenda();

       // Crear contactos
       Contacto contacto1 = new Contacto("Luis", "Gomez", "5512345678");
       Contacto contacto2 = new Contacto("Karla", "Perez", "5587654321");
       Contacto contacto3 = new Contacto("Rodrigo", "Lopez", "5555555555");

       // Agregar contactos
       System.out.println("=== AGREGANDO CONTACTOS ===");
       agenda.añadirContacto(contacto1);
       agenda.añadirContacto(contacto2);
       agenda.añadirContacto(contacto3);

       // Intentar agregar un contacto repetido
       System.out.println("\n=== CONTACTO REPETIDO ===");
       agenda.añadirContacto(new Contacto("Luis", "Gomez", "9999999999"));

       // Listar contactos
       System.out.println("\n=== LISTA DE CONTACTOS ===");

       Map<String, Contacto> contactos = agenda.listarContactos();

       for (Map.Entry<String, Contacto> entrada : contactos.entrySet()) {
           System.out.println(entrada.getValue());
       }

       // Buscar contacto
       System.out.println("\n=== BUSCAR CONTACTO ===");
       agenda.buscaContacto("Luis", "Gomez");

       // Modificar teléfono
       System.out.println("\n=== MODIFICAR TELÉFONO ===");
       agenda.modificarTelefono("Luis", "Gomez", "5511111111");

       // Buscar nuevamente para verificar cambio
       agenda.buscaContacto("Luis", "Gomez");

       // Eliminar contacto
       System.out.println("\n=== ELIMINAR CONTACTO ===");
       agenda.eliminarContacto(contacto2);

       // Mostrar lista final
       System.out.println("\n=== LISTA FINAL ===");

       contactos = agenda.listarContactos();

       for (Map.Entry<String, Contacto> entrada : contactos.entrySet()) {
           System.out.println(entrada.getValue());
       }

   }
}

