package py.edu.ucom.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;


import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.Entities.Cliente;
import py.edu.ucom.Entities.Empleados;
import py.edu.ucom.Entities.ItemPago;
import py.edu.ucom.Entities.Pagos;
import py.edu.ucom.Entities.detalleDeCompras;
import py.edu.ucom.controllers.cajaService;


@ApplicationScoped
public class cajaService {

    @Inject


    private List<Pagos> pagos; 

    public void registrarPago(String documentoCliente, String documentoUsuario, List<ItemPago> items, Cliente cliente, detalleDeCompras detalle, Empleados empleado) {




        Pagos pago = new Pagos(cliente, detalle, empleado);
        pagos.add(pago); // Agrega el pago a la lista

        guardarPagosEnJSON(); // Guarda la lista de pagos en un archivo JSON
    }

    public List<Pagos> obtenerPagos() {
        return pagos; // Devuelve la lista de pagos
    }

    private void guardarPagosEnJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        try {
            objectWriter.writeValue(new File("pagos.json"), pagos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarPago(String documentoCliente, String documentoUsuario, List<ItemPago> items) {
    }
}

