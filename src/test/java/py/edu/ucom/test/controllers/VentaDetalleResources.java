package py.edu.ucom.test.controllers;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import py.edu.ucom.test.Config.Globales;
import py.edu.ucom.test.entities.Producto;
import py.edu.ucom.test.entities.Venta;
import py.edu.ucom.test.entities.VentaDetalle;
import py.edu.ucom.test.services.ProductoService;
import py.edu.ucom.test.services.VentaDetalleService;
import py.edu.ucom.test.services.VentaService;




@Path("/VentaDetalle")
public class VentaDetalleResources {
    @Inject
    private VentaDetalleService ventaDetalleService; 
    @Inject
    private VentaService ventaService; 
    @Inject
    private ProductoService productoService; 

    @GET
    public List<VentaDetalle> listarVentaDetalles() {
        return ventaDetalleService.listar();
    }
    @DELETE
    @Path("{id}")
    public void eliminarVentaDetalle(@PathParam("id") Integer id) {
        ventaDetalleService.eliminar(id);
    }

    @POST
    public Response agregarVentaDetalle(VentaDetalle ventaDetalle) {
        VentaDetalle nuevoDetalle = ventaDetalleService.agregar(ventaDetalle);
        return Response.ok(nuevoDetalle).build();
    }


    @PUT
    public Response modificarVentaDetalle(VentaDetalle ventaDetalle) {
        VentaDetalle detalleModificado = ventaDetalleService.modificar(ventaDetalle);
        return Response.ok(detalleModificado).build();
    }


    @GET
    @Path("{id}")
    public Response obtenerVentaDetalle(@PathParam("id") Integer id) {
        VentaDetalle detalle = ventaDetalleService.obtener(id);
        if (detalle != null) {
            return Response.ok(detalle).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.RECUPERADO_ERR).build();
        }
    }


    @POST
    @Path("/agregar/detalle/{ventaId}/{productoId}/{cantidad}")
    public Response crearVentaDetalle(@PathParam("ventaId") Integer ventaId,@PathParam("productoId") Integer productoId, @PathParam("cantidad") Integer cantidad)
     {
        Venta venta = ventaService.obtener(ventaId);
        Producto producto = productoService.obtener(productoId);

        if (venta == null || producto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.CREADO_ERR).build();
        }

        if (!productoService.restarStock(cantidad, producto)) {
            return Response.status(Response.Status.NOT_FOUND).entity("No esta disponible").build();
        }

        VentaDetalle nuevoDetalle = ventaDetalleService.crearVentaDetalle(venta, producto, cantidad);

        if (nuevoDetalle == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.CREADO_ERR).build();
        }

        int total = calcularTotalVenta(venta);
        actualizarTotalVenta(venta, total);

        return Response.status(Response.Status.OK).entity(Globales.CRUD.CREADO_OK).build();
    }


    
    private int calcularTotalVenta(Venta venta) {
        int total = 0;
        List<VentaDetalle> detalles = venta.getVentaDetalleList();
        for (VentaDetalle detalle : detalles) {
            total += detalle.getSubtotal();
        }
        return total;
    }


    private void actualizarTotalVenta(Venta venta, int total) {
        venta.setTotal(total);
        ventaService.modificar(venta);
    }
}


