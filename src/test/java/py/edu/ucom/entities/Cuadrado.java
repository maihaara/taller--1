package py.edu.ucom.entities;


public class Cuadrado extends FiguraGeometrica {
       public double lado;

       public Cuadrado(double lado){
              this.lado = lado;
       }
      /*
       * public double calcularPerimetro() {
              return 0.0;
          };
       */

       @Override
       public double calcularArea() {
              return (lado*lado);
       };

       @Override
       public double calcularPerimetro() {
              return 4 * lado;
       }
}


