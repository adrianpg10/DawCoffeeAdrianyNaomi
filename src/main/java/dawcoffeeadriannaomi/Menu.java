/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffeeadriannaomi;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Nao
 */
public class Menu {

    public static void Menu(Cafetera cafetera) {

        //Variables
        int opcionElegida;
        boolean repetir = true;

        //Controlo que el Menú se repita mientras el usuario no selecciones salir del programa
        do {
            //Controlo que el usuario utiliza una opción válida
            do {
                String opcionesMenu = JOptionPane.showInputDialog("[Daw Coffee]\n"
                        + "Elije una de las siguientes opciones:\n"
                        + "1.- Venta de productos\n"
                        + "2.- Administración de la cafetera\n"
                        + "3.- Salir");

                //Paso el String "opcion" a int haciendo un parseo
                opcionElegida = Integer.parseInt(opcionesMenu);

                //Mientras el usuario elija una de las opciones que no están disponibles se volverá a repetir el menú
            } while (opcionElegida < 1 || opcionElegida > 3);

            //Utilizo un switch para las 3 opciones disponibles
            switch (opcionElegida) {
                case 1:
                    //VENTA DE PRODUCTOS//
                    Menu.ventas(cafetera);
                    break;
                case 2:
                    //ADMINISTRACIÓN DE LA CAFETERA//
                    Menu.administracion(cafetera);
                    break;
                case 3:
                    //SALIR DEL PROGRAMA//
                    int opcionSalir = JOptionPane.showConfirmDialog(null, "¿Deseas salir?", "Dejar de usar Daw Coffee", JOptionPane.YES_NO_OPTION);

                    if (opcionSalir == JOptionPane.YES_OPTION) {
                        System.out.println("Saliendo del programa.");
                        repetir = false;
                    }
                    break;
            }
        } while (repetir);
    }

    //Método de clase estático que gestiona la parte de ventas del menú
    public static void ventas(Cafetera cafetera) {

        double saldoCliente = 0;
        //Variable para controlar si se realiza la compra o no
        boolean compra = false;
        //Utilizo la clase DecimalFormat para dar formato a los datos
        DecimalFormat df = new DecimalFormat("#0.00");

        do {
            // Controlamos la excepcion del signo ","
            try {
                //Mensaje para que el usuario introduzca el saldo
                String saldo = JOptionPane.showInputDialog("[Daw Coffee]\n"
                        + "Introduzca el dinero:");
                //Paso de String a double
                saldoCliente = Double.parseDouble(saldo);
                //El saldo del cliente se va actualizando - tendrá que introducir más dinero dependiendo del producto que desee
                cafetera.setSaldoCliente(cafetera.getSaldoCliente() + saldoCliente); //Cambio el saldo del cliente por el actual
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Has introducido mal el importe. Signo incorrecto ( , ) ", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Controlo que el saldo introducido sea igual o superior al precio del producto más barato
            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_LECHE()) {
                String opcionesVenta;
                String opcionAzucar;
                String opcionCantAzucar;

                do {
                    //Controlo que el usuario elige una opción válida
                    do {
                        //Muestro al usuario los productos disponibles
                        opcionesVenta = JOptionPane.showInputDialog("[Daw Coffee]\n"
                                + "Elije una opción de nuestros productos:\n"
                                + "A1 - Café solo\n"
                                + "A2 - Café solo largo\n"
                                + "A3 - Café con leche\n"
                                + "A4 - Café cortado\n"
                                + "B1 - Café solo descafeinado\n"
                                + "B2 - Café solo largo descafeinado\n"
                                + "B3 - Café descafeinado con leche\n"
                                + "B4 - Café cortado descafeinado\n"
                                + "C1 - Chocolate\n"
                                + "D1 - Leche fría\n"
                                + "D2 - Leche caliente\n");
                    } while (!(opcionesVenta.equalsIgnoreCase("A1") || opcionesVenta.equalsIgnoreCase("A2") || opcionesVenta.equalsIgnoreCase("A3")
                            || opcionesVenta.equalsIgnoreCase("A4") || opcionesVenta.equalsIgnoreCase("B1") || opcionesVenta.equalsIgnoreCase("B2")
                            || opcionesVenta.equalsIgnoreCase("B3") || opcionesVenta.equalsIgnoreCase("B4") || opcionesVenta.equalsIgnoreCase("C1")
                            || opcionesVenta.equalsIgnoreCase("D1") || opcionesVenta.equalsIgnoreCase("D2")));

                    switch (opcionesVenta.toUpperCase()) {
                        case "A1":
                            //Si el saldo es inferior al precio del producto no se realiza la venta
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CAFESOLO()) {
                                cafetera.servirCafeSolo(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CAFESOLO());
                                compra = true;
                            }
                            break;
                        case "A2":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CAFELARGO()) {
                                cafetera.servirCafeLargo(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CAFELARGO());
                                compra = true;
                            }
                            break;
                        case "A3":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CAFELECHE()) {
                                cafetera.servirCafeLeche(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CAFELECHE());
                                compra = true;
                            }
                            break;
                        case "A4":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CORTADO()) {
                                cafetera.servirCafeCortado(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CORTADO());
                                compra = true;
                            }
                            break;
                        case "B1":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CAFESOLO()) {
                                cafetera.servirCafeSoloDescafeinado(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CAFESOLO());
                                compra = true;
                            }
                            break;
                        case "B2":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CAFELARGO()) {
                                cafetera.servirCafeLargoDescafeinado(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CAFELARGO());
                                compra = true;
                            }
                            break;
                        case "B3":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CAFELECHE()) {
                                cafetera.servirCafeLecheDescafeinado(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CAFELECHE());
                                compra = true;
                            }
                            break;
                        case "B4":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CORTADO()) {
                                cafetera.servirCafeCortadoDescafeinado(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CORTADO());
                                compra = true;
                            }
                            break;
                        case "C1":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_CHOCOLATE()) {
                                cafetera.servirChocolate(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_CHOCOLATE());
                                compra = true;
                            }
                            break;
                        case "D1":
                        case "D2":
                            if (cafetera.getSaldoCliente() >= Cafetera.getPRECIO_LECHE()) {
                                cafetera.servirLeche(saldoCliente);
                                cafetera.setSaldoCliente(cafetera.getSaldoCliente() - Cafetera.getPRECIO_LECHE());
                                compra = true;
                            }
                            break;
                    }

                    //Si el salso es insuficiente para el producto seleccionado el usuario
                    //deberá introducir más dinero
                    if (compra == false) {
                        String masSaldo = JOptionPane.showInputDialog("[Daw Coffee]\n"
                                + "El saldo es insuficiente para el producto seleccionado.\n"
                                + "Introduzca más dinero:");

                        double acumulaSaldo = Double.parseDouble(masSaldo);

                        //Actualizamos el saldo actual del cliente
                        cafetera.setSaldoCliente(cafetera.getSaldoCliente() + acumulaSaldo);
                    }
                    //Se repetirá el proceso mientras no se haya efectuado la compra
                } while (compra == false);

                int opAzucar, opCantAzucar;

                //Selecciona del tipo de edulcorante
                //Controlo que se elije una opción válida
                do {
                    opcionAzucar = JOptionPane.showInputDialog("[Daw Coffee]\n"
                            + "¿Desea su bebida con azúcar o sacarina?:\n"
                            + "1.- Azúcar\n"
                            + "2.- Sacarina\n");

                    opAzucar = Integer.parseInt(opcionAzucar);
                } while (opAzucar < 1 || opAzucar > 2);

                //El usuario selecciona la cantidad de edulcorante que desea
                do {
                    opcionCantAzucar = JOptionPane.showInputDialog("[Daw Coffee]\n"
                            + "¿Qué cantidad de edulcorante desea?:\n"
                            + "1.- Ninguna\n"
                            + "2.- Poca\n"
                            + "3.- Mucha\n");
                    opCantAzucar = Integer.parseInt(opcionCantAzucar);

                } while (opCantAzucar < 1 || opCantAzucar > 3);

                //Se sirve el azúcar o el edulcorante al producto
                switch (opAzucar) {
                    case 1: //HA ELEGIDO AZÚCAR
                        switch (opCantAzucar) { //CANTIDAD DE AZÚCAR QUE DESEA
                            case 1:
                                cafetera.servirAzucar(0);
                                break;
                            case 2:
                                cafetera.servirAzucar(1);
                                break;
                            case 3:
                                cafetera.servirAzucar(2);
                                break;
                        }
                        break;

                    case 2: //HA ELEGIDO SACARINA
                        switch (opCantAzucar) { //CANTIDAD DE SACARINA QUE DESEA
                            case 1:
                                cafetera.servirSacarina(0);
                                break;
                            case 2:
                                cafetera.servirSacarina(1);
                                break;
                            case 3:
                                cafetera.servirSacarina(2);
                                break;
                        }
                        break;
                }
            } else {
                //Muestro mensaje de saldo insuficiente y el cambio que en este caso se devolverá
                //ya que no llegá al precio del producto más barato
                JOptionPane.showMessageDialog(null, "[Daw Coffee]\n"
                        + "El saldo introducido es insuficiente.\n"
                        + "Su cambio es: " + df.format(cafetera.getSaldoCliente()));
                //Tras devolverle el dinero, el saldo del cliente se actualizará a cero
                cafetera.setSaldoCliente(0);
            }
            //Este proceso se producirá hasta que se introduzca el saldo mínimo y se realice la venta
        } while (cafetera.getSaldoCliente() < Cafetera.getPRECIO_LECHE() && compra == false);

        //Muestro los datos al usuario del saldo restante tras el pedido
        JOptionPane.showMessageDialog(null, "[Daw Coffee]\n"
                + "Su cambio es: " + df.format(cafetera.getSaldoCliente())
                + "\nDisfrute de su pedido.");

        //Tras devolverle el dinero el saldo del cliente se actualizará a cero
        cafetera.setSaldoCliente(0);
    }

    //Creamos un método estático de clase para modularizar la sección de administracion
    public static void administracion(Cafetera cafetera) {

        String adminUsuario;
        String adminContrasenia;

        do {
            adminUsuario = JOptionPane.showInputDialog("User: ");

            adminContrasenia = JOptionPane.showInputDialog("Password: ");

        } while (!(adminUsuario.equals(cafetera.getAdmin().getUsuario()) && adminContrasenia.equals(cafetera.getAdmin().getPassword())));

        //ADMINISTRACIÓN DE LA CAFETERA//
        String opcionesAdministracion;
        String opcionllenado;
        int eleccion;
        String indicaCantidad;
        int cantidadIndicada;
        int opcionElegidaAdm;

        //Utilizo un bucle do-while para controlar que el usuario elige una opción disponible
        do {
            //Muestro al usuario las opciones disponibles

            opcionesAdministracion = JOptionPane.showInputDialog(
                    "[Daw Coffee]\n"
                    + "Elije una opción para administrar la cafetera:\n"
                    + "1.- Comprobar depósitos\n"
                    + "2.- Comprobar estado general\n"
                    + "3.- Consultar saldo de ventas\n"
                    + "4.- Rellenar depósitos");

            //Paso el String "opcion" a int haciendo un parseo
            opcionElegidaAdm = Integer.parseInt(opcionesAdministracion);
        } while (opcionElegidaAdm < 1 || opcionElegidaAdm > 4);
        boolean reserva = false;
        switch (opcionElegidaAdm) {

            case 1:

                if (cafetera.comprobarDepositos(cafetera.getAgua()).equalsIgnoreCase(cafetera.getAgua().getContenido())) {

                    JOptionPane.showMessageDialog(null, "El depósito de " + cafetera.comprobarDepositos(cafetera.getAgua()) + ", debe ser rellenado");
                    reserva = true;
                }

                if (cafetera.comprobarDepositos(cafetera.getCafe()).equalsIgnoreCase(cafetera.getCafe().getContenido())) {

                    JOptionPane.showMessageDialog(null, "El depósito de " + cafetera.comprobarDepositos(cafetera.getCafe()) + ", debe ser rellenado");
                    reserva = true;
                }
                if (cafetera.comprobarDepositos(cafetera.getLeche()).equalsIgnoreCase(cafetera.getLeche().getContenido())) {

                    JOptionPane.showMessageDialog(null, "El depósito de " + cafetera.comprobarDepositos(cafetera.getLeche()) + ", debe ser rellenado");
                    reserva = true;
                }

                if (cafetera.comprobarDepositos(cafetera.getAzucar()).equalsIgnoreCase(cafetera.getAzucar().getContenido())) {

                    JOptionPane.showMessageDialog(null, "El depósito de " + cafetera.comprobarDepositos(cafetera.getAzucar()) + ", debe ser rellenado");
                    reserva = true;
                }
                if (cafetera.comprobarDepositos(cafetera.getChocolate()).equalsIgnoreCase(cafetera.getChocolate().getContenido())) {

                    JOptionPane.showMessageDialog(null, "El depósito de " + cafetera.comprobarDepositos(cafetera.getChocolate()) + ", debe ser rellenado");
                    reserva = true;
                }
                if (cafetera.comprobarDepositos(cafetera.getSacarina()).equalsIgnoreCase(cafetera.getSacarina().getContenido())) {

                    JOptionPane.showMessageDialog(null, "El depósito de " + cafetera.comprobarDepositos(cafetera.getSacarina()) + ", debe ser rellenado");
                    reserva = true;
                }
                if (cafetera.comprobarDepositos(cafetera.getCafeDescafeinado()).equalsIgnoreCase(cafetera.getCafeDescafeinado().getContenido())) {

                    JOptionPane.showMessageDialog(null, "El depósito de " + cafetera.comprobarDepositos(cafetera.getCafeDescafeinado()) + ", debe ser rellenado");
                    reserva = true;
                }

                if (reserva == false) {
                    JOptionPane.showMessageDialog(null, "Ningun deposito ha llegado a la capacidad Umbral");

                }

                break;
            case 2:

                JOptionPane.showMessageDialog(null, cafetera.comprobarEstadoGeneral());

                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Se han realizado: " + cafetera.getNumVentasRealizadas() + " ventas \n"
                        + "El saldo acumulado es: " + cafetera.getSaldoAcumulado() + " euros.");
                break;
            case 4:
                int opciondepositosElegida;
                do {

                    String opciondepositos = JOptionPane.showInputDialog(
                            "Elije el deposito a rellenar: \n"
                            + "1.- Agua \n"
                            + "2.- Café \n"
                            + "3.- Leche \n"
                            + "4.- Azúcar \n"
                            + "5.- Chocolate\n"
                            + "6.- Sacarina\n"
                            + "7.- Café Descafeinado");

                    //Paso el String "opcion" a int haciendo un parseo
                    opciondepositosElegida = Integer.parseInt(opciondepositos);
                } while (opciondepositosElegida < 1 || opciondepositosElegida > 7);

                switch (opciondepositosElegida) {

                    case 1:
                        opcionllenado = JOptionPane.showInputDialog(
                                "¿Cómo quieres llenarlo? \n"
                                + "1.- Completo \n"
                                + "2.- Indica la cantidad ");

                        eleccion = Integer.parseInt(opcionllenado);

                        switch (eleccion) {
                            case 1:

                                cafetera.getAgua().rellenarDeposito();

                                break;
                            case 2:
                                indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                                cantidadIndicada = Integer.parseInt(indicaCantidad);

                                cafetera.getAgua().rellenarDeposito(cantidadIndicada);
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

                                cafetera.getCafe().rellenarDeposito();

                                break;
                            case 2:
                                indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                                cantidadIndicada = Integer.parseInt(indicaCantidad);

                                cafetera.getCafe().rellenarDeposito(cantidadIndicada);
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

                                cafetera.getLeche().rellenarDeposito();

                                break;
                            case 2:
                                indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                                cantidadIndicada = Integer.parseInt(indicaCantidad);

                                cafetera.getLeche().rellenarDeposito(cantidadIndicada);
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

                                cafetera.getAzucar().rellenarDeposito();

                                break;
                            case 2:
                                indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                                cantidadIndicada = Integer.parseInt(indicaCantidad);

                                cafetera.getAzucar().rellenarDeposito(cantidadIndicada);
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

                                cafetera.getChocolate().rellenarDeposito();

                                break;
                            case 2:
                                indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                                cantidadIndicada = Integer.parseInt(indicaCantidad);

                                cafetera.getChocolate().rellenarDeposito(cantidadIndicada);
                                break;

                        }

                        break;

                    case 6:

                        opcionllenado = JOptionPane.showInputDialog(
                                "¿Cómo quieres llenarlo? \n"
                                + "1.- Completo \n"
                                + "2.- Indica la cantidad ");

                        eleccion = Integer.parseInt(opcionllenado);

                        switch (eleccion) {
                            case 1:

                                cafetera.getSacarina().rellenarDeposito();

                                break;
                            case 2:
                                indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                                cantidadIndicada = Integer.parseInt(indicaCantidad);

                                cafetera.getSacarina().rellenarDeposito(cantidadIndicada);
                                break;

                        }

                        break;

                    case 7:

                        opcionllenado = JOptionPane.showInputDialog(
                                "¿Cómo quieres llenarlo? \n"
                                + "1.- Completo \n"
                                + "2.- Indica la cantidad ");

                        eleccion = Integer.parseInt(opcionllenado);

                        switch (eleccion) {
                            case 1:

                                cafetera.getCafeDescafeinado().rellenarDeposito();

                                break;
                            case 2:
                                indicaCantidad = JOptionPane.showInputDialog("Indica la cantidad: ");

                                cantidadIndicada = Integer.parseInt(indicaCantidad);

                                cafetera.getCafeDescafeinado().rellenarDeposito(cantidadIndicada);
                                break;

                        }

                        break;

                }
                break;

        }

    }
}
