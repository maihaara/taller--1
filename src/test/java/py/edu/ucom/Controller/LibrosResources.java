package py.edu.ucom.Controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import py.edu.ucom.entitiess.Libros;
import py.edu.ucom.utils.DataSourceJSON;
import py.edu.ucom.Controller.LibrosResources;

@Path("/libros")
public class LibrosResources {

    @Inject
    public DataSourceJSON ds; 

    @GET 
    @Path("isbn")
    public Libros obtenerLibroByISBN(@PathParam("isbn") String  param){
        return this.ds.buscarLibro(param);
    }   

    @GET 
    public List<Libros> obtenerLibros(List<Libros> listasDeLibros, List<Libros> listaDeLibros) {
        List<Libros> lib = new ArrayList<> ();

        try {
            listaDeLibros = this.ds.obtenerLibros();
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
}

