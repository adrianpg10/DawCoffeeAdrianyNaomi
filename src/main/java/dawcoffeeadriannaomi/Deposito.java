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
    public Deposito(String contenido, double cantidadMaxima, double cantidadActual, boolean reserva) {
        this.contenido = contenido;
        this.cantidadMaxima = cantidadMaxima;
        //La cantidad umbral será la mitad de la capacidad total de la cafetera
        this.cantidadUmbral = cantidadMaxima / 2;
        this.cantidadActual = cantidadActual;
        //La cantidad actual nunca podrá ser mayor que la cantidad máxima de la cafetera
        if (cantidadActual > cantidadMaxima) {
            this.cantidadActual = cantidadMaxima;
        }
        this.reserva = reserva;
    }

    //Constructor por defecto
    public Deposito() {
        this.contenido = "Nuevo";
        this.cantidadMaxima = 1000;
        this.cantidadUmbral = 500;
        this.cantidadActual = 0;
        this.reserva = true;
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

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;

        if (cantidadActual > this.cantidadMaxima) {
            this.cantidadActual = this.cantidadMaxima;
        }
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
