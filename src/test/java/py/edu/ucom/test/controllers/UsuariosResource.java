package py.edu.ucom.test.controllers;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/usuarios")
public class UsuariosResource {
    
    /* @Inject
    public DataSourceJSON ds;
    @GET
	@@ -24,10 +21,10 @@ public List<Usuarios> obtener(){
    public Usuarios obtenerByDocumento(@PathParam("documento")String param){
        return this.ds.buscarUsuario(param);
    }
 */
    @POST
    public void guardar(Object usuario){
      //  this.ds.guardarUsuarios(usuario);
    }

}