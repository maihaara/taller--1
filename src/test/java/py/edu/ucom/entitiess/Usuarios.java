package py.edu.ucom.entitiess;

import java.util.List;

public class Usuarios<librosPrestados>{
       public String nombre;
       public Boolean b;
       public Boolean documento2;
       public String documento;
       public List<librosPrestados> LibrosPretados;
       private List<Libros> librosPrestados;

       public String getNombre() {
              return nombre;
       }
       public void setNombre(Boolean b) {
              this.nombre =  b;

       }
       public String getDocumento() {
              return documento;
       }
       public void setDocumento(String documento) {
              this.documento = documento;
       }
       public List<Libros> getLibrosPrestados() {

              return librosPrestados;
       }
       public void setLibrosPrestados(List<Libros> librosPrestados) {
              this.librosPrestados = librosPrestados;
       }
    public boolean setNombre(boolean documento2) {
       return documento2;
    }
    public Object getDocumentos() {
        return null;
    }


}

