package py.edu.ucom.entitiess;

import java.util.List;

public class Usuarios<librosPrestados>{
       public String nombre;
       public String documento;
       public List<librosPrestados> LbrosPretados;

       public String getNombre() {
              return nombre;
       }
       public void setNombre(String nombre) {
              this.nombre = nombre;
       }
       public String getDocumento() {
              return documento;
       }
       public void setDocumento(String documento) {
              this.documento = documento;
       }
       public List<Libros> getLibrosPrestados() {
              return LbrosPretados;
       }
       public void setLibrosPrestados(List<Libros> librosPrestados) {
              this.librosPrestados = librosPrestados;
       }


}

