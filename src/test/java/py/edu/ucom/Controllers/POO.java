package py.edu.ucom.Controllers;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import py.edu.ucom.entities.Cuadrado;
import py.edu.ucom.entities.FiguraGeometrica;
import py.edu.ucom.entities.Rectangulo;

@Path("poo")
public class POO {

    @GET
    @Path("Cuadrado")
    public double obtenerPerimetroCuadrado() {

        Cuadrado c = new Cuadrado(4.0);


        return c.calcularPerimetro();
    } 

    @GET
    @Path("cuadrado-area")
    public double obtenerAreaCuadrada() {
        Cuadrado c =  new Cuadrado(2.0);

        return c.calcularArea();
    } 


    @GET
    @Path("rectangulo-area")

    public double obtenerAreaRectangulo(){
        Rectangulo r = new Rectangulo(2.0, 4.0);
        FiguraGeometrica f = r;
        return f.calcularPerimetro();
    } 



}

