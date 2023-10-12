package py.edu.ucom.controllers;
import java.util.List;

import javax.inject.Inject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.ucom.Entities.ItemPago;
import py.edu.ucom.Entities.Pagos;


@Path ("/tienda/caja")
@Produces (MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class cajaResource {

    @Inject
    cajaService cajaService;

    @POST
    @Path("/{documentoCliente}/{documentoUsuario}")
    public void registrarPago(
        @PathParam ("documentoCliente") String documentoCliente,
        @PathParam("documentoUsuario") String documentoUsuario,
        List<ItemPago> items) {
        cajaService.registrarPago(documentoCliente, documentoUsuario, items);
    }

    @GET
    @Path("/pagos")
    public List<Pagos> obtenerPagos() {
        return cajaService.obtenerPagos();
    }
}
