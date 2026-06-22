import java.util.Map;

public class runListaContacto {
    public static void main(String[] args) {


    //Se llama a la función
    Map<String, Contacto> contactosOrdenado =sortByValue(contactos);

    //Imprimir el hashmap
        for (Map.Entry<String, Contacto> parejaRevisada : contactosOrdenado.entrySet()) {
            System.out.println(parejaRevisada.getValue().toString() + " " + parejaRevisada.getKey());
        }


    } //main
}//class runListaContacto
