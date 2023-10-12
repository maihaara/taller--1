package py.edu.ucom.Entities;


import java.time.LocalDateTime;

public class Pagos {
    private static int codigoUnico = 1;
    private int codigoCompra;
    private Cliente cliente;
    private LocalDateTime fecha;
    private double monto;
    private detalleDeCompras detalle;
    private Empleados empleado;


 public Pagos(Cliente cliente, detalleDeCompras detalle, Empleados empleado) {
        this.codigoCompra = codigoUnico; codigoUnico++;
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.detalle = detalle;
        this.monto = detalle.getTotal();
        this.empleado = empleado;
    }




    public int getCodigo() {
        return codigoCompra;
    }



    public Cliente getCliente() {
        return cliente;
    }



    public LocalDateTime getFechayHora() {
        return fecha;
    }



    public double getMonto() {
        return monto;
    }



    public detalleDeCompras getDetalle() {
        return detalle;
    }



    public Empleados getEmpleado() {
        return empleado;
    }

}
