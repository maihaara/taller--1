package py.edu.ucom.utils;

import java.io.File;
import java.util.List;
import py.edu.ucom.entitiess.Libros;

@ApplicatioScoped
public class DataSourceJSON {
    public String SRC = "C:\\Users\\Maihaa\\Deskop\\taller-1\\src\\main\\java\\py\\ucom\\utils\\libros.json";
    public void guardarLibro(Libros Libro){
    try {
        ObjectMapper mapper = new ObjectMapper();

        List<Libros> lista = obtenerLibros();
        lista.add(Libro);
        mapper.writerValue(new File(“this.SRC”), lista)

    } catch (Exception e) {

        e.printStackTrace();
    }
        
}
      
       public List<Libros> obtenerLibros() {
            ObjectMapper mapper = new ObjectMapper();
            List<Libros> libros = new ArrayList<>();
             try {

                   libros = mapper.readValue( new File( "this.SRC"),new TypeReference<List<Libros>>() {});

             } catch (Exception e) {

               e.printStackTrace();
             }
        
             return libros;
       }


}