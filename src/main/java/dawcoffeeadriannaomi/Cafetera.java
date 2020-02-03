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
    private final double CANT_CAFE_CAFELECHE = 40;
    private final double CANT_LECHE_CAFELECHE = 40;
    private final double CANT_AGUA_CAFELECHE = 100;
    private final double CANT_CAFE_CAFELARGO = 50;
    private final double CANT_LECHE_CAFELARGO = 60;
    private final double CANT_AGUA_CAFELARGO = 70;
    private final double CANT_CAFE_CAFECORTADO = 60;
    private final double CANT_LECHE_CAFECORTADO = 30;
    private final double CANT_AGUA_CAFECORTADO = 90;
    private final double CANT_CHOCOLATE = 30;
    private final double CANT_LECHE_CHOCOLATE = 30;
    private final double CANT_LECHE = 60;
    private final double CANT_AGUA_GENERAL = 120;
    private final double CANT_AZUCAR = 5;
    private final double CANT_SACARINA = 3;

    private final double PRECIO_PRODUCT_MINIMO = 0.5;

    //Constantes con los precios de los productos
    private static final double PRECIO_CAFESOLO = 0.8;
    private static final double PRECIO_CAFELARGO = 0.9;
    private static final double PRECIO_CAFELECHE = 1.1;
    private static final double PRECIO_CORTADO = 1;
    private static final double PRECIO_CHOCOLATE = 1.4;
    private static final double PRECIO_LECHE = 0.5;

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
    public void servirCafeSolo(double saldoIntroducido) {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CAFESOLO;
    }

    //Método servirCafeSoloDescafeinado que actualiza el estado de los depósitos
    public void servirCafeSoloDescafeinado(double saldoIntroducido) {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUAYCAFE_CAFESOLO);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CAFESOLO;
    }

    //Método servirCafeLeche que actualiza el estado de los depósitos
    public void servirCafeLeche(double saldoIntroducido) {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_CAFE_CAFELECHE);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELECHE);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_CAFELECHE);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CAFELECHE;
    }

    //Método servirCafeLecheDescafeinado que actualiza el estado de los depósitos
    public void servirCafeLecheDescafeinado(double saldoIntroducido) {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_CAFE_CAFELECHE);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELECHE);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_CAFELECHE);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CAFELECHE;
    }

    //Método servirCafeLargo que actualiza el estado de los depósitos
    public void servirCafeLargo(double saldoIntroducido) {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_CAFE_CAFELARGO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELARGO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_CAFELARGO);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CAFELARGO;
    }

    //Método servirCafeLargoDescafeinado que actualiza el estado de los depósitos
    public void servirCafeLargoDescafeinado(double saldoIntroducido) {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_CAFE_CAFELARGO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFELARGO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_CAFELARGO);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CAFELARGO;
    }

    //Método servirCafeCortado que actualiza el estado de los depósitos
    public void servirCafeCortado(double saldoIntroducido) {
        cafe.setCantidadActual(cafe.getCantidadActual() - CANT_CAFE_CAFECORTADO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFECORTADO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_GENERAL);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CORTADO;
    }

    //Método servirCafeCortadoDescafeinado que actualiza el estado de los depósitos
    public void servirCafeCortadoDescafeinado(double saldoIntroducido) {
        cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadActual() - CANT_CAFE_CAFECORTADO);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CAFECORTADO);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_GENERAL);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CORTADO;
    }

    //Método servirChocolate que actualiza el estado de los depósitos
    public void servirChocolate(double saldoIntroducido) {
        chocolate.setCantidadActual(chocolate.getCantidadActual() - CANT_CHOCOLATE);
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE_CHOCOLATE);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_GENERAL);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_CHOCOLATE;
    }

    //Método servirLeche (en el menú controlaremos que sea caliete o fría)
    public void servirLeche(double saldoIntroducido) {
        leche.setCantidadActual(leche.getCantidadActual() - CANT_LECHE);
        agua.setCantidadActual(agua.getCantidadActual() - CANT_AGUA_GENERAL);
        numVentasRealizadas++;
        this.saldoAcumulado += saldoIntroducido - PRECIO_LECHE;
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

    public int getNumVentasRealizadas() {
        return numVentasRealizadas;
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

    public Deposito getCafeDescafeinado() {
        return cafeDescafeinado;
    }

    public void setCafeDescafeinado(Deposito cafeDescafeinado) {
        this.cafeDescafeinado = cafeDescafeinado;
    }

    public Deposito getSacarina() {
        return sacarina;
    }

    public void setSacarina(Deposito sacarina) {
        this.sacarina = sacarina;
    }

    public double getPRECIO_PRODUCT_MINIMO() {
        return PRECIO_PRODUCT_MINIMO;
    }

    public static double getPRECIO_CAFESOLO() {
        return PRECIO_CAFESOLO;
    }

    public static double getPRECIO_CAFELARGO() {
        return PRECIO_CAFELARGO;
    }

    public static double getPRECIO_CAFELECHE() {
        return PRECIO_CAFELECHE;
    }

    public static double getPRECIO_CORTADO() {
        return PRECIO_CORTADO;
    }

    public static double getPRECIO_CHOCOLATE() {
        return PRECIO_CHOCOLATE;
    }

    public static double getPRECIO_LECHE() {
        return PRECIO_LECHE;
    }

    //Método toString
    @Override
    public String toString() {
        return "Cafetera{" + "saldoCliente=" + saldoCliente + ", saldoAcumulado=" + saldoAcumulado + ", numVentasRealizadas=" + numVentasRealizadas + ", leche=" + leche + ", cafe=" + cafe + ", chocolate=" + chocolate + ", agua=" + agua + ", azucar=" + azucar + '}';
    }

    //Comprobamos si los depositos deben ser rellenados
    public String comprobarDepositos(Deposito deposito) {

        String reserva = " ";

        if (deposito.getCantidadActual() <= deposito.getCantidadUmbral()) {
            reserva = deposito.getContenido();
        }

        return reserva;

    }

    //Método que comprueba el estado general de los depósitos de la cafetera.
    public String comprobarEstadoGeneral() {

        String cadena = agua.toString() + cafe.toString() + leche.toString() + chocolate.toString()
                + azucar.toString() + sacarina.toString() + cafeDescafeinado.toString() + admin.toString();
        return cadena;

    }

}
