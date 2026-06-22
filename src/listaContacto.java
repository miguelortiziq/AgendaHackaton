import java.util.*;

public class listaContacto {

    //Se crea lista

    List<Map .Entry<String, Contacto>>lista = new ArrayList<>(contactos.entrySet());

    //Se ordena llamando al to String

          Collections.sort(lista, new Comparator<Map.Entry<String, Contacto>>() {
        @Override
        public int compare(Map.Entry<String, Contacto> parejaUno, Map.Entry<String, Contacto> parejaDos) {
         return parejaUno.getValue().getNombre.compareToIgnoreCase(parejaDos.getValue().getNombre());
        } //compare
    });

          //Guardar el orden
    Map<String, Contacto> mapaContacto = new LinkedHashMap<>();
    for (Map.Entry<String,Contacto> entrada : lista) {
        mapaContacto.put(entrada.getKey(), entrada.getValue());
        } //for


   }//class listaContato
