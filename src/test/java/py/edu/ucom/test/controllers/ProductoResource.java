package py.edu.ucom.test.controllers;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import py.edu.ucom.test.Config.Globales;
import py.edu.ucom.test.entities.Cliente;
import py.edu.ucom.test.entities.Producto;
import py.edu.ucom.test.services.ProductoService;



@Path("/producto")
public class ProductoResource {
    @Inject
    private ProductoService service; 
    @GET
    public Response listarProductos() {
        List<Producto> lista = service.listar();
        if (lista != null) {
            return Response.status(Response.Status.OK).entity(lista).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.LISTADO_ERR).build();
        }
    }


    @DELETE
    @Path("{id}")
    public Response eliminarProducto(@PathParam("id") Integer id) {
        try {
            service.eliminar(id);
            return Response.status(Response.Status.OK)
                    .entity(Globales.CRUD.ELIMINADO_OK)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Globales.CRUD.ELIMINADO_ERR)
                    .build();
        }
    }

    @PUT
    public Response modificarProducto(Producto producto) {
        try {
            service.modificar(producto);
            return Response.status(Response.Status.OK)
                    .entity(Globales.CRUD.MODIFICADO_OK)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Globales.CRUD.MODIFICADO_ERR)
                    .build();
        }
    }

    @PUT
    @Path("/stock/restar/{prodId}/{cantidad}")
    public Response restarStockProducto(@PathParam("prodId") Integer productoId, @PathParam("cantidad") Integer cantidad) {
        Producto producto = service.obtener(productoId);
        if (producto != null) {
            if (service.restarStock(cantidad, producto)) {
                return Response.status(Response.Status.OK).entity(Globales.CRUD.MODIFICADO_OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Stock insuficiente").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build();
        }
    }

 
    @PUT
    @Path("/stock/sumar/{prodId}/{cantidad}")
    public Response sumarStockProducto(@PathParam("prodId") Integer productoId, @PathParam("cantidad") Integer cantidad) {
        Producto producto = service.obtener(productoId);
        if (producto != null) {
            service.sumarStock(cantidad, producto);
            return Response.status(Response.Status.OK).entity(Globales.CRUD.MODIFICADO_OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build();
        }
    }
    @PUT
    @Path("/stock/cambiar/{prodId}/{cantidad}")
    public Response cambiarStockProducto(@PathParam("prodId") Integer productoId, @PathParam("cantidad") Integer cantidad) {
        Producto producto = service.obtener(productoId);
        if (producto != null) {
            if (cantidad >= 0) {
                service.cambiarStock(cantidad, producto);
                return Response.status(Response.Status.OK).entity(Globales.CRUD.MODIFICADO_OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Cantidad no válida").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build();
        }
    }

    @GET
    @Path("{id}")
    public Response obtenerProducto(@PathParam("id") Integer id) {
        Producto producto = service.obtener(id);
        if (producto != null) {
            return Response.status(Response.Status.OK).entity(producto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.RECUPERADO_ERR).build();
        }
    }
    @POST
    public Response agregarProducto(Producto producto) {
        Producto nuevoProducto = service.agregar(producto);
        if (nuevoProducto != null) {
            return Response.status(Response.Status.OK).entity(nuevoProducto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.CREADO_ERR).build();
        }
    }
}


