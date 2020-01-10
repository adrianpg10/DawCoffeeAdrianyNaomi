/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffeeadriannaomi;

import javax.swing.JOptionPane;

/**
 *
 * @author adrip
 */
public class Cafetera {

    //Atributos
    private double saldoCliente; //Saldo actual del cliente
    private double saldoAcumulado; //Cantidad de dinero en la máquina
    private int numVentasRealizadas;
    private Deposito leche;
    private Deposito cafe;
    private Deposito chocolate;
    private Deposito agua;
    private Deposito azucar;

    //Constructor por defecto
    public Cafetera() {
        this.saldoCliente = 100;
        this.saldoAcumulado = 200;
        this.numVentasRealizadas = 2;
        this.leche = new Deposito("leche", 80, 30, 50);
        this.cafe = new Deposito("cafe", 80, 50, 70);
        this.chocolate = new Deposito("chocolate", 80, 30, 50);
        this.agua = new Deposito("agua", 80, 50, 60);
        this.azucar = new Deposito("azucar", 50, 30, 60);
    }

    //Constructor parametrizado
    public Cafetera(double saldoCliente, double saldoAcumulado, int numVentasRealizadas, Deposito leche, Deposito cafe, Deposito chocolate, Deposito agua, Deposito azucar) {
        this.saldoCliente = saldoCliente;
        this.saldoAcumulado = saldoAcumulado;
        this.numVentasRealizadas = numVentasRealizadas;
        this.leche = leche;
        this.cafe = cafe;
        this.chocolate = chocolate;
        this.agua = agua;
        this.azucar = azucar;
    }

    //Métodos getters y setters
    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }

    public int getNumVentasRealizadas() {
        return numVentasRealizadas;
    }

    public void setNumVentasRealizadas(int numVentasRealizadas) {
        this.numVentasRealizadas = numVentasRealizadas;
    }

    public Deposito getLeche() {
        return leche;
    }

    public void setLeche(Deposito leche) {
        this.leche = leche;
    }

    public Deposito getCafe() {
        return cafe;
    }

    public void setCafe(Deposito cafe) {
        this.cafe = cafe;
    }

    public Deposito getChocolate() {
        return chocolate;
    }

    public void setChocolate(Deposito chocolate) {
        this.chocolate = chocolate;
    }

    public Deposito getAgua() {
        return agua;
    }

    public void setAgua(Deposito agua) {
        this.agua = agua;
    }

    public Deposito getAzucar() {
        return azucar;
    }

    public void setAzucar(Deposito azucar) {
        this.azucar = azucar;
    }

    //Método toString
    @Override
    public String toString() {
        return "Cafetera{" + "saldoCliente=" + saldoCliente + ", saldoAcumulado=" + saldoAcumulado + ", numVentasRealizadas=" + numVentasRealizadas + ", leche=" + leche + ", cafe=" + cafe + ", chocolate=" + chocolate + ", agua=" + agua + ", azucar=" + azucar + '}';
    }

    

}
