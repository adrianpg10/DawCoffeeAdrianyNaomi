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
    private Usuario admin;

    //Constructor por defecto
    public Cafetera() {
        this.saldoCliente = 100;
        this.saldoAcumulado = 200;
        this.numVentasRealizadas = 2;
        this.leche = new Deposito("leche", 80, 30, 50);
        this.cafe = new Deposito("cafe", 80, 50, 60);
        this.chocolate = new Deposito("chocolate", 80, 30, 50);
        this.agua = new Deposito("agua", 90, 50, 20);
        this.azucar = new Deposito("azucar", 50, 30, 60);
        this.admin = new Usuario();
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

    public Usuario getAdmin() {
        return admin;
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

    //Comprobamos si los depositos deben ser rellenados
    public void comprobarDepositos() {
        boolean reserva = true;

        if (getLeche().getCantidadActual() <= getLeche().getCantidadUmbral()) {
            JOptionPane.showMessageDialog(null, "El depósito de " + getLeche().getContenido() + ", debe ser rellenado");
            reserva = false;
        }

        if (getAzucar().getCantidadActual() <= getAzucar().getCantidadUmbral()) {
            JOptionPane.showMessageDialog(null, "El depósito de " + getAzucar().getContenido() + ", debe ser rellenado");
            reserva = false;
        }

        if (getCafe().getCantidadActual() <= getCafe().getCantidadUmbral()) {
            JOptionPane.showMessageDialog(null, "El depósito de " + getCafe().getContenido() + ", debe ser rellenado");
            reserva = false;
        }

        if (getChocolate().getCantidadActual() <= getChocolate().getCantidadUmbral()) {
            JOptionPane.showMessageDialog(null, "El depósito de " + getChocolate().getContenido() + ", debe ser rellenado");
            reserva = false;
        }

        if (getAgua().getCantidadActual() <= getAgua().getCantidadUmbral()) {
            JOptionPane.showMessageDialog(null, "El depósito de " + getAgua().getContenido() + ", debe ser rellenado");
            reserva = false;
        }

        if (reserva == true) {
            JOptionPane.showMessageDialog(null, "Ningun deposito ha llegado a la capacidad Umbral");
        }

    }

//Metodo para comprobar el estado general de los depositos de la cafetera.
    public void comprobarEstadoGeneral() {

        JOptionPane.showMessageDialog(null, " Deposito de:  " + getAgua().getContenido() + "\n "
                + "Cantidad Máxima: " + getAgua().getCantidadMaxima() + "\n "
                + "Cantidad Umbral: " + getAgua().getCantidadUmbral() + "\n "
                + "Cantidad Actual: " + getAgua().getCantidadActual());

        JOptionPane.showMessageDialog(null, " Deposito de:  " + getCafe().getContenido() + "\n "
                + "Cantidad Máxima: " + getCafe().getCantidadMaxima() + "\n "
                + "Cantidad Umbral: " + getCafe().getCantidadUmbral() + "\n "
                + "Cantidad Actual: " + getCafe().getCantidadActual());

        JOptionPane.showMessageDialog(null, " Deposito de:  " + getLeche().getContenido() + "\n "
                + "Cantidad Máxima: " + getLeche().getCantidadMaxima() + "\n "
                + "Cantidad Umbral: " + getLeche().getCantidadUmbral() + "\n "
                + "Cantidad Actual: " + getLeche().getCantidadActual());

        JOptionPane.showMessageDialog(null, " Deposito de:  " + getAzucar().getContenido() + "\n "
                + "Cantidad Máxima: " + getAzucar().getCantidadMaxima() + "\n "
                + "Cantidad Umbral: " + getAzucar().getCantidadUmbral() + "\n "
                + "Cantidad Actual: " + getAzucar().getCantidadActual());

        JOptionPane.showMessageDialog(null, " Deposito de:  " + getChocolate().getContenido() + "\n "
                + "Cantidad Máxima: " + getChocolate().getCantidadMaxima() + "\n "
                + "Cantidad Umbral: " + getChocolate().getCantidadUmbral() + "\n "
                + "Cantidad Actual: " + getChocolate().getCantidadActual());

        JOptionPane.showMessageDialog(null, " Cuenta del Administrador:  " + "\n "
                + "Usuario: " + getAdmin().getUsuario() + "\n "
                + "Contraseña: " + getAdmin().getPassword() + "\n ");

    }

    //Metodo para rellenar los depositos, que se llenará en funcion de 2 opciones, por completo o la cantidad elegida
    public void rellenarDepositos() {
        int opcionElegida;
        String opcionllenado;
        int eleccion;
        String indicaCantidad;
        double cantidadIndicada;

        String opciondepositos = JOptionPane.showInputDialog(
                "Elije el deposito a rellenar: \n"
                + "1.- Agua \n"
                + "2.- Café \n"
                + "3.- Leche \n"
                + "4.- Azúcar \n"
                + "5.- Chocolate");

        //Paso el String "opcion" a int haciendo un parseo
        opcionElegida = Integer.parseInt(opciondepositos);

        switch (opcionElegida) {
            case 1:

                opcionllenado = JOptionPane.showInputDialog(
                        "¿Cómo quieres llenarlo? \n"
                        + "1.- Completo \n"
                        + "2.- Indica la cantidad ");

                eleccion = Integer.parseInt(opcionllenado);

                switch (eleccion) {
                    case 1:

                        getAgua().setCantidadActual(getAgua().getCantidadMaxima());

                        JOptionPane.showMessageDialog(null, "El depósito de " + getAgua().getContenido() + " se ha llenado por completo");

                        break;
                    case 2:

                        indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                        cantidadIndicada = Integer.parseInt(indicaCantidad);

                        if (cantidadIndicada >= getAgua().getCantidadMaxima() || (cantidadIndicada + getAgua().getCantidadActual()) >= getAgua().getCantidadMaxima()) {
                            getAgua().setCantidadActual(getAgua().getCantidadMaxima());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getAgua().getContenido() + " es de: " + getAgua().getCantidadActual());
                        } else {

                            getAgua().setCantidadActual(cantidadIndicada + getAgua().getCantidadActual());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getAgua().getContenido() + " es de: " + getAgua().getCantidadActual());
                        }

                        break;
                }

                break;

            case 2:

                opcionllenado = JOptionPane.showInputDialog(
                        "¿Cómo quieres llenarlo? \n"
                        + "1.- Completo \n"
                        + "2.- Indica la cantidad ");

                eleccion = Integer.parseInt(opcionllenado);

                switch (eleccion) {
                    case 1:

                        getCafe().setCantidadActual(getCafe().getCantidadMaxima());

                        JOptionPane.showMessageDialog(null, "El depósito de " + getCafe().getContenido() + " se ha llenado por completo");

                        break;
                    case 2:

                        indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                        cantidadIndicada = Integer.parseInt(indicaCantidad);

                        if (cantidadIndicada >= getCafe().getCantidadMaxima() || (cantidadIndicada + getCafe().getCantidadActual()) >= getCafe().getCantidadMaxima()) {
                            getCafe().setCantidadActual(getCafe().getCantidadMaxima());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getCafe().getContenido() + " es de: " + getCafe().getCantidadActual());
                        } else {

                            getCafe().setCantidadActual(cantidadIndicada + getCafe().getCantidadActual());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getCafe().getContenido() + " es de: " + getCafe().getCantidadActual());
                        }

                        break;
                }

                break;

            case 3:

                opcionllenado = JOptionPane.showInputDialog(
                        "¿Cómo quieres llenarlo? \n"
                        + "1.- Completo \n"
                        + "2.- Indica la cantidad ");

                eleccion = Integer.parseInt(opcionllenado);

                switch (eleccion) {
                    case 1:

                        getLeche().setCantidadActual(getLeche().getCantidadMaxima());

                        JOptionPane.showMessageDialog(null, "El depósito de " + getLeche().getContenido() + " se ha llenado por completo");

                        break;
                    case 2:

                        indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                        cantidadIndicada = Integer.parseInt(indicaCantidad);

                        if (cantidadIndicada >= getLeche().getCantidadMaxima() || (cantidadIndicada + getLeche().getCantidadActual()) >= getLeche().getCantidadMaxima()) {
                            getLeche().setCantidadActual(getLeche().getCantidadMaxima());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getLeche().getContenido() + " es de: " + getLeche().getCantidadActual());
                        } else {

                            getLeche().setCantidadActual(cantidadIndicada + getLeche().getCantidadActual());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getLeche().getContenido() + " es de: " + getLeche().getCantidadActual());
                        }

                        break;
                }

                break;

            case 4:

                opcionllenado = JOptionPane.showInputDialog(
                        "¿Cómo quieres llenarlo? \n"
                        + "1.- Completo \n"
                        + "2.- Indica la cantidad ");

                eleccion = Integer.parseInt(opcionllenado);

                switch (eleccion) {
                    case 1:

                        getAzucar().setCantidadActual(getAzucar().getCantidadMaxima());

                        JOptionPane.showMessageDialog(null, "El depósito de " + getAzucar().getContenido() + " se ha llenado por completo");

                        break;
                    case 2:

                        indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                        cantidadIndicada = Integer.parseInt(indicaCantidad);

                        if (cantidadIndicada >= getAzucar().getCantidadMaxima() || (cantidadIndicada + getAzucar().getCantidadActual()) >= getAzucar().getCantidadMaxima()) {
                            getAzucar().setCantidadActual(getAzucar().getCantidadMaxima());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getAzucar().getContenido() + " es de: " + getAzucar().getCantidadActual());
                        } else {

                            getAzucar().setCantidadActual(cantidadIndicada + getAzucar().getCantidadActual());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getAzucar().getContenido() + " es de: " + getAzucar().getCantidadActual());
                        }

                        break;
                }

                break;

            case 5:

                opcionllenado = JOptionPane.showInputDialog(
                        "¿Cómo quieres llenarlo? \n"
                        + "1.- Completo \n"
                        + "2.- Indica la cantidad ");

                eleccion = Integer.parseInt(opcionllenado);

                switch (eleccion) {
                    case 1:

                        getChocolate().setCantidadActual(getChocolate().getCantidadMaxima());

                        JOptionPane.showMessageDialog(null, "El depósito de " + getChocolate().getContenido() + " se ha llenado por completo");

                        break;
                    case 2:

                        indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                        cantidadIndicada = Integer.parseInt(indicaCantidad);

                        if (cantidadIndicada >= getChocolate().getCantidadMaxima() || (cantidadIndicada + getChocolate().getCantidadActual()) >= getChocolate().getCantidadMaxima()) {
                            getChocolate().setCantidadActual(getChocolate().getCantidadMaxima());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getChocolate().getContenido() + " es de: " + getChocolate().getCantidadActual());
                        } else {

                            getChocolate().setCantidadActual(cantidadIndicada + getChocolate().getCantidadActual());
                            JOptionPane.showMessageDialog(null, "La cantidad de " + getChocolate().getContenido() + " es de: " + getChocolate().getCantidadActual());
                        }

                        break;
                }

                break;

        }

    }
}
