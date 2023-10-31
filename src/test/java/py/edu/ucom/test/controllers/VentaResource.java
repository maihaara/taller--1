package py.edu.ucom.test.controllers;


import java.util.ArrayList;
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
import py.edu.ucom.test.entities.MetodoPago;
import py.edu.ucom.test.entities.Producto;
import py.edu.ucom.test.entities.Venta;
import py.edu.ucom.test.entities.VentaDetalle;
import py.edu.ucom.test.dto.ResumenVentaDTO;
import py.edu.ucom.test.services.ClienteService;
import py.edu.ucom.test.services.MetodoPagoService;
import py.edu.ucom.test.services.ProductoService;
import py.edu.ucom.test.services.VentaDetalleService;
import py.edu.ucom.test.services.VentaService;





@Path("/venta")
public class VentaResource {
    @Inject
    public VentaService ventaService;
    @Inject
    public ClienteService clienteService;
    @Inject
    public MetodoPagoService metodoPagoService;
    @Inject
    public ProductoService productoService;
    @Inject
    public VentaDetalleService ventaDetalleService;

    @GET
    public Response listarVentas() {
        List<Venta> lista = ventaService.listar();
        return (lista != null)
            ? Response.ok(lista).build()
            : Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.LISTADO_ERR).build();
    }


    @DELETE
    @Path("{id}")
    public Response eliminarVenta(@PathParam("id") Integer id) {
        try {
            ventaService.eliminar(id);
            return Response.ok(Globales.CRUD.ELIMINADO_OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Globales.CRUD.ELIMINADO_ERR)
                .build();
        }
    }

    @POST
    public Venta agregarVenta(Venta venta) {
        return ventaService.agregar(venta);
    }


    @PUT
    public Response modificarVenta(Venta venta) {
        try {
            ventaService.modificar(venta);
            return Response.ok(Globales.CRUD.MODIFICADO_OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Globales.CRUD.MODIFICADO_ERR)
                .build();
        }
    }

    @GET
    @Path("{id}")
    public Response obtenerVenta(@PathParam("id") Integer id) {
        Venta venta = ventaService.obtener(id);
        return (venta != null)
            ? Response.ok(venta).build()
            : Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.RECUPERADO_ERR).build();
    }


    @GET
    @Path("resumen/{id}")
    public ResumenVentaDTO obtenerResumenVenta(@PathParam("id") Integer id) {
        return ventaService.obtenerResumen(id);
    }

    @GET
    @Path("listaDetalle/{id}")
    public List<VentaDetalle> listarDetallesVenta(@PathParam("id") Integer id) {
        Venta venta = ventaService.obtener(id);
        return (venta != null) ? venta.getVentaDetalleList() : new ArrayList<>();
    }

    @POST
    @Path("/agregar/venta/{clienteId}/{metodoPagoId}/{productoId}/{cantidad}")
    public Response crearVentaConDetalles(
        @PathParam("clienteId") Integer clienteId,
        @PathParam("metodoPagoId") Integer metodoPagoId,
        @PathParam("productoId") Integer productoId,
        @PathParam("cantidad") Integer cantidad
    ) {
        Cliente cliente = clienteService.obtener(clienteId);
        MetodoPago metodoPago = metodoPagoService.obtener(metodoPagoId);
        Producto producto = productoService.obtener(productoId);

        if (cliente == null || metodoPago == null || producto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.CREADO_ERR).build();
        }

        if (!productoService.restarStock(cantidad, producto)) {
            return Response.status(Response.Status.NOT_FOUND).entity("No está disponible").build();
        }

        Venta venta = ventaService.crearVenta(cliente, metodoPago);
        VentaDetalle detalle = ventaDetalleService.crearVentaDetalle(venta, producto, cantidad);

        if (venta == null || detalle == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Globales.CRUD.CREADO_ERR).build();
        }

        venta.setTotal(detalle.getSubtotal());
        ventaService.modificar(venta);
        return Response.ok(Globales.CRUD.CREADO_OK).build();
    }
}
