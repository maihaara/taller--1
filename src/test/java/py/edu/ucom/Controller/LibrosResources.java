package py.edu.ucom.Controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import py.edu.ucom.entitiess.Libros;
import py.edu.ucom.utils.DataSourceJSON;

@Path("/libros")
public class LibrosResources {

    @Inject
    public DataSourceJSON ds; 
    @GET 
    public List<libros> obtenerLibros(DataSourceJSON listasDeLibros) {
        List<Libros> lib = new ArrayList<> ();

        try {
            listasDeLibros = this.ds.obtenerLibros();
        } catch (Exception e) {

            }
         return listasDeLibros;
        } ;   

        @POST  
            public void agregarLibro(Libros params) {
                   try {
                        this.ds.guardarLibro(params);
                   } catch (Exception e) {
                         e.printStackTrace();
            }

}
