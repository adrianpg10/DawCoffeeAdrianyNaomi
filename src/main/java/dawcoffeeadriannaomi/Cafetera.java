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
        this.saldoCliente = 0;
        this.saldoAcumulado = 0;
        this.numVentasRealizadas = 0;
        this.leche = new Deposito();
        this.cafe = cafe;
        this.chocolate = chocolate;
        this.agua = agua;
        this.azucar = azucar;
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
