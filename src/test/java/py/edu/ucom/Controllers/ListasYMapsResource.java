<<<<<<< HEAD
package py.edu.ucom.Controllers;


import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/clase3")
public class ListasYMapsResource {

    @GET
    public List<Integer> getLista() {

        
        List<Integer> ListaInteger = new ArrayList<>();
        ListaInteger.add(1);
        ListaInteger.add(2);
        ListaInteger.add(3);

        return ListaInteger;
    }

        

     
    @GET
    @Path("maps")
    public Map<String, Object> getMaps() {
        List<Integer> ListaInteger = new ArrayList<>();
        ListaInteger.add(1);
        ListaInteger.add(2);
        ListaInteger.add(3);

        Map<String, Object> maps = new HashMap<>();
        maps.put("clase-3", "04/10/2023");
        maps.put("clase-4", 1000000);


        Map<String, Object> mapsItems = new HashMap<>();
        maps.put("clase-3", "04/10/2023");
        maps.put("clase-4", 1000000);
        maps.put("clase-5", new Date());
        maps.put("clase-6", ListaInteger);

        maps.put("clase-7", mapsItems);

        return maps;
    }


    @GET
    @Path("ejercicio1")
    public Map<String, Integer> getFrecuencias() {
        
        return contadorDePalabras();
 
    }
 
    public Map<String, Integer> contadorDePalabras() {
        String texto = "Ejemplo de texto para prueba";
    
        String[] palabras = texto.split("\\s+");
    
        List<String> ListaPalabras = new ArrayList<>();
    
        for (String palabra : palabras) {
            palabra = palabra.replaceAll("[^a-zA-Z]", "");
    
            if (!palabra.isEmpty()) {
                ListaPalabras.add(palabra);
            }
        }
    }

   
    Map<String, Integer> contadorPalabras = new HashMap<>() ;

    for (String palabra : ListaPalabras) {
          if (contadorPalabras.containsKey(palabra)) {
              int frecuencia = contadorPalabras.get(palabra);
              contadorPalabras.put(palabra, frecuencia + 1);
            } else {
               contadorPalabras.put(palabra, 1);
        }
    }
      

    return contadorPalabras;
}

}


=======
>>>>>>> parent of e0251bb (clase-4)
