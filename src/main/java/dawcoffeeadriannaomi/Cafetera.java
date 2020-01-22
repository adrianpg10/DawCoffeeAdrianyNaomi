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
    private Deposito leche;
    private Deposito cafe;
    private Deposito cafeDescafeinado;
    private Deposito chocolate;
    private Deposito agua;
    private Deposito azucar;
    private Deposito sacarina;
    private Usuario admin;
    private static int numVentasRealizadas = 0; //Para calcular el número de ventas

    //Constantes
    //Las cantidades serán las mismas para el café normal y el descafeinado
    private final double CANT_AGUAYCAFE_CAFESOLO = 50;
    private final double CANT_CAFE_CAFELECHE = 60;
    private final double CANT_LECHE_CAFELECHE = 120;
    private final double CANT_CAFE_CAFELARGO = 80;
    private final double CANT_LECHE_CAFELARGO_YCHOCOLATE = 100;
    private final double CANT_CAFE_CAFECORTADO = 150;
    private final double CANT_LECHE_CAFECORTADO = 30;
    private final double CANT_CHOCOLATE = 80;
    private final double CANT_LECHE = 80;
    private final double CANT_AZUCAR = 5;
    private final double CANT_SACARINA = 3;

    private final double PRECIO_PRODUCT_MINIMO = 0.50;

    //Constructor por defecto
    public Cafetera() {
        this.saldoCliente = 5;
        this.saldoAcumulado = 200;
        this.leche = new Deposito("leche", 1000, 800, false);
        this.cafe = new Deposito("café", 2000, 1800, false);
        this.chocolate = new Deposito("chocolate", 1000, 900, false);
        this.agua = new Deposito("agua", 2000, 1500, false);
        this.azucar = new Deposito("azúcar", 1000, 600, false);
        this.sacarina = new Deposito("agua", 500, 200, false);
        this.admin = new Usuario();
    }

    //Constructor parametrizado
    public Cafetera(double saldoCliente, double saldoAcumulado, Deposito leche, Deposito cafe, Deposito cafeDescafeinado, Deposito chocolate, Deposito agua, Deposito azucar, Deposito sacarina, Usuario admin) {
        this.saldoCliente = saldoCliente;
        this.saldoAcumulado = saldoAcumulado;
        this.leche = leche;
        this.cafe = cafe;
        this.cafeDescafeinado = cafeDescafeinado;
        this.chocolate = chocolate;
        this.agua = agua;
        this.azucar = azucar;
        this.sacarina = sacarina;
        this.admin = admin;
    }

    //Método servirCafeSolo que actualiza el estado de los depósitos 
    //Nota: Un vaso 180 ml/gr
    public void servirCafeSolo() {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        numVentasRealizadas++;
    }

    //Método servirCafeSoloDescafeinado que actualiza el estado de los depósitos
    public void servirCafeSoloDescafeinado() {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        numVentasRealizadas++;
    }

    //Método servirCafeLeche que actualiza el estado de los depósitos
    public void servirCafeLeche() {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_CAFE_CAFELECHE);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELECHE);
        numVentasRealizadas++;
    }

    //Método servirCafeLecheDescafeinado que actualiza el estado de los depósitos
    public void servirCafeLecheDescafeinado() {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_CAFE_CAFELECHE);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELECHE);
        numVentasRealizadas++;
    }

    //Método servirCafeLargo que actualiza el estado de los depósitos
    public void servirCafeLargo() {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_CAFE_CAFELARGO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELARGO_YCHOCOLATE);
        numVentasRealizadas++;
    }

    //Método servirCafeLargoDescafeinado que actualiza el estado de los depósitos
    public void servirCafeLargoDescafeinado() {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_CAFE_CAFELARGO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELARGO_YCHOCOLATE);
        numVentasRealizadas++;
    }

    //Método servirCafeCortado que actualiza el estado de los depósitos
    public void servirCafeCortado() {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_CAFE_CAFECORTADO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFECORTADO);
        numVentasRealizadas++;
    }

    //Método servirCafeCortadoDescafeinado que actualiza el estado de los depósitos
    public void servirCafeCortadoDescafeinado() {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_CAFE_CAFECORTADO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFECORTADO);
        numVentasRealizadas++;
    }

    //Método servirChocolate que actualiza el estado de los depósitos
    public void servirChocolate() {
        chocolate.setCantidadActual(chocolate.getCantidadActual() - CANT_CHOCOLATE);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELARGO_YCHOCOLATE);
        numVentasRealizadas++;
    }

    //Método servirLeche (en el menú controlaremos que sea caliete o fría)
    public void servirLeche() {
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE);
        numVentasRealizadas++;
    }

    //Método servirAzucar que sirve una o dos cucharadas según elija el cliente
    public void servirAzucar(int numeroCucharadas) {
        if (numeroCucharadas == 1) {
            azucar.setCantidadActual(azucar.getCantidadActual() - CANT_AZUCAR);
        } else {
            azucar.setCantidadActual(azucar.getCantidadActual() - CANT_AZUCAR * numeroCucharadas);
        }
    }

    //Método servirSacarina que sirve una o dos cucharadas según elija el cliente
    public void servirSacarina(int numeroCucharadas) {
        if (numeroCucharadas == 1) {
            sacarina.setCantidadActual(sacarina.getCantidadActual() - CANT_AZUCAR);
        } else {
            sacarina.setCantidadActual(sacarina.getCantidadActual() - CANT_SACARINA * numeroCucharadas);
        }
    }

    //Método acumularSaldoCliente
    public void acumularSaldoCliente(double saldoIntroducido) {
        this.saldoCliente += saldoIntroducido;
    }

    //Método saldoSuficiente devuelve un boolean, true si el dinero introducido por el cliente
    //es igual o superior al precio mínimo que se necesita para comprar un producto sino devuelve false
    public boolean saldoSuficiente() {
        if (this.saldoCliente < PRECIO_PRODUCT_MINIMO) {
            return false;
        } else {
            return true;
        }
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
            JOptionPane.showMessageDialog(null, "Ningún deposito ha llegado a la capacidad Umbral");
        }

    }

    //Método que comprueba el estado general de los depósitos de la cafetera.
    public void comprobarEstadoGeneral() {

        JOptionPane.showMessageDialog(null, agua.toString() + "\n"
                + cafe.toString() + "\n"
                + leche.toString() + "\n"
                + chocolate.toString() + "\n"
                + azucar.toString() + "\n"
                + sacarina.toString() + "\n"
                + cafeDescafeinado.toString() + "\n"
                + admin.toString()
        );

    }

    //Método que rellena los depósitos. Se llenará en funcion de 2 opciones: por completo o según la cantidad elegida
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
