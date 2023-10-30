package py.edu.ucom.test.controllers;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import py.edu.ucom.test.Config.Globales;
import py.edu.ucom.test.entities.Cliente;
import py.edu.ucom.test.entities.TipoDocumento;
import py.edu.ucom.test.services.ClienteService;
import jakarta.ws.rs.core.Response;
import py.edu.ucom.test.Config.Globales;

import py.edu.ucom.test.services.TipoDocumentoService;
import py.edu.ucom.test.entities.TipoDocumento;
@Path("/Cliente")
public class ClienteResource {
    @Inject
    public ClienteService service;
    @Inject
    public TipoDocumentoService docuService;




    @GET
    public List<Cliente> listar() {
        return this.service.listar();
    }

    @DELETE
    @Path("{id}")
    public void eliminar(Integer id) {
        this.service.eliminar(id);
    }

    @POST
    public Cliente agregar(Cliente param) {
        return this.service.agregar(param);
    }

    @PUT
    public Cliente modificar(Cliente param) {
        return this.service.modificar(param);
    }

    @GET
    @Path("{id}")
    public Cliente obtener(@PathParam("id") Integer param) {
        return this.service.obtener(param);
    }




        @POST
    @Path("/agregar/{Nombre}/{Apellido}/{Documento}/{CodDocu}/{ClienteFiel}")
    public Response agregarNuevoCliente(@PathParam("nombre") String nombre, @PathParam("Aellido") String apellido,

        @PathParam("Documento") String documento, @PathParam("codDocu") Integer codDocu,
        @PathParam("ClienteFiel") String clienteFiel) {

        TipoDocumento tipoDocu = this.docuService.obtener(codDocu);
        Cliente cliente = new Cliente();
        cliente.setNombres(nombre);
        cliente.setApellidos(apellido);
        cliente.setDocumento(documento);
        cliente.setTipoDocumentoId(tipoDocu);
        cliente.setEsClienteFiel(Boolean.parseBoolean(clienteFiel));

        try {
            this.service.agregar(cliente);
            return Response.status(Response.Status.OK)
            .entity(Globales.CRUD.CREADO_OK)
            .build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(Globales.CRUD.CREADO_ERR)
            .build();
        }
    }


}
