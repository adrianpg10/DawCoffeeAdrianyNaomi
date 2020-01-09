/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffeeadriannaomi;

/**
 *
 * @author adrip
 */
public class Deposito {
    
    //Añadimos atributos de la clase Depósito
    private String contenido;
    private double cantidadMaxima;
    private double cantidadUmbral;
    private double cantidadActual;
    private boolean reserva;

    //Añadimos Constructor parametrizado
    public Deposito(String contenido, double cantidadMaxima, double cantidadUmbral, double cantidadActual) {
        this.contenido = contenido;
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadUmbral = cantidadUmbral;
        this.cantidadActual = cantidadActual;
        estadoReserva();
    }

    //Constructor por defecto
    public Deposito() {
        this.contenido = "Nueva";
        this.cantidadMaxima = 100;
        this.cantidadUmbral = 20;
        this.cantidadActual = 0;
        this.reserva = true;

    }

    private void estadoReserva() {
        if (this.cantidadActual <= this.cantidadUmbral) {
            this.reserva = true;
            System.out.println("La cantidad de " + getContenido() + " ha entrado en reserva, necesitamos recarcar");
        }
    }

    //Añadimos Getters y Setters
    public String getContenido() {
        return contenido;
    }

    public double getCantidadMaxima() {
        return cantidadMaxima;
    }

    public double getCantidadUmbral() {
        return cantidadUmbral;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public boolean isReserva() {
        return reserva;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setCantidadMaxima(double cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public void setCantidadUmbral(double cantidadUmbral) {
        this.cantidadUmbral = cantidadUmbral;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
    
    //Método toString
    @Override
    public String toString() {
        return "Deposito{" + "contenido=" + contenido + ", cantidadMaxima=" + cantidadMaxima + ", cantidadUmbral=" + cantidadUmbral + ", cantidadActual=" + cantidadActual + '}';
    }
}
