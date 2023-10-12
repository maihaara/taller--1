package py.edu.ucom.Entities;


import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
public class Pagos {
    private static int codigoUnico = 1;
    private int codigoCompra;
    private String codigoCliente;
        private int codigoPago;
    private Cliente cliente;
    private LocalDateTime fecha;
    private double monto;
    private detalleDeCompras detalle;
    private int codigoDetalle;
    private String codigoEmpleado;
    private Empleados empleado;


 public Pagos(Cliente cliente, detalleDeCompras detalle, Empleados empleado) {
        this.codigoPago = codigoUnico;
        this.codigoCompra = codigoUnico; codigoUnico++;
        this.codigoCliente = cliente.getDocumento();
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.codigoDetalle = detalle.getCodigo();
        this.detalle = detalle;
        this.monto = detalle.getTotal();
        this.empleado = empleado;
        this.codigoEmpleado = empleado.getDocumento();
    }

    public Pagos(Object cliente2, Object detalle2, Object empleado2) {
}

    public int getCodPago() {
        return codigoPago;
    }




    public String getCodCliente() {
        return codigoCliente;
    }
    public int getCodigo() {
        return codigoCompra;
    }

    @JsonProperty("fechayHora")
    @JsonSerialize(using = ToStringSerializer.class)

    public Cliente getCliente() {
        return cliente;
    }



    public LocalDateTime getFechayHora() {
        return fecha;
    }



    public double getMonto() {
        return monto;
    }

    public int getCodDetalle() {
        return codigoDetalle;
    }


    public detalleDeCompras getDetalle() {
        return detalle;
    }



    public Empleados getEmpleado() {
        return empleado;
    }
    public String getCodEmpleado() {
        return codigoEmpleado;
    }

