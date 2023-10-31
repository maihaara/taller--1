package py.edu.ucom.test.controllers;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
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
import py.edu.ucom.test.util.Caracteres;



@Path("/Cliente")
public class ClienteResource {
    @Inject
    public ClienteService service;

    @Inject
    public TipoDocumentoService docuService;

    @GET
    public Response listarClientes() {
        List<Cliente> lista = this.service.listar();
        return (lista != null) ?
        Response.ok(lista).build() :
        Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.LISTADO_ERR).build();
    }

    @DELETE
    @Path("{id}")
    public Response eliminarCliente(@PathParam("id") Integer id) {
        try {
            this.service.eliminar(id);
            return Response.ok(Globales.CRUD.ELIMINADO_OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(Globales.CRUD.ELIMINADO_ERR)
            .build();
        }
    }

    @PUT
    public Response modificarCliente(Cliente cliente) {
        try {
            this.service.modificar(cliente);
            return Response.ok(Globales.CRUD.MODIFICADO_OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(Globales.CRUD.MODIFICADO_ERR)
            .build();
        }
    }

    @GET
    @Path("{id}")
    public Response obtenerCliente(@PathParam("id") Integer id) {
        Cliente cliente = this.service.obtener(id);
        return (cliente != null) ?
        Response.ok(cliente).build() :
        Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.RECUPERADO_ERR).build();
    }

    @POST
    @Path("/agregar")
    public Response agregarNuevoCliente(
        @FormParam("nombre") String nombre,
        @FormParam("apellido") String apellido,
        @FormParam("documento") String documento,
        @FormParam("codDocu") Integer codDocu,
        @FormParam("clienteFiel") String clienteFiel) {
        nombre = Caracteres.limpiarYCapitalizar(nombre);
        apellido = Caracteres.limpiarYCapitalizar(apellido);
        if (!clienteFiel.equals("true") && !clienteFiel.equals("false")) {
            return Response.status(Response.Status.BAD_REQUEST)
            .entity("El valor de 'clienteFiel' debe ser 'true' o 'false")
            .build();
        }
        TipoDocumento tipoDocu = this.docuService.obtener(codDocu);

        // Validación de tipoDocu:
        if (tipoDocu == null) {
            return Response.status(Response.Status.NOT_FOUND)
            .entity("Tipo de documento no encontrado")
            .build();
        }

        Cliente cliente = new Cliente();
        cliente.setNombres(nombre);
        cliente.setApellidos(apellido);
        cliente.setDocumento(documento);
        cliente.setTipoDocumento(tipoDocu);
        cliente.setEsClienteFiel(Boolean.parseBoolean(clienteFiel));

        this.service.agregar(cliente);
        return Response.ok(Globales.CRUD.CREADO_OK).build();
    }
}
