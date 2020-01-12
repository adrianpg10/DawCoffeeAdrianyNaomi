/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffeeadriannaomi;

import javax.swing.JOptionPane;

/**
 *
 * @author Nao
 */
public class Menu {

    public static void Menu(Cafetera cafetera) {

        int opcionElegida;
        boolean repetir = true;
        //Bucle Do-while para controlar que el programa se repite mientras el usuario no selecciones salir
        do {
            //Do-while para controlar que selecciona una opcion viable
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
                    String opcionesVenta;
                    //Utilizo un bucle do-while para controlar que el usuario elige una opción disponible
                    do {
                        //Muestro al usuario las opciones disponibles
                        opcionesVenta = JOptionPane.showInputDialog("[Daw Coffee]\n"
                                + "Elije una opción de nuestros productos:\n"
                                + "A1 - Café solo\n"
                                + "A2 - Café solo largo\n"
                                + "A3 - Café con leche\n"
                                + "A4 - Café cortado\n"
                                + "B1 - Chocolate\n"
                                + "C1 - Leche fría\n"
                                + "C2 - Leche caliente\n");
                    } while (!(opcionesVenta.equalsIgnoreCase("A1") || opcionesVenta.equalsIgnoreCase("A2") || opcionesVenta.equalsIgnoreCase("A3")
                            || opcionesVenta.equalsIgnoreCase("A4") || opcionesVenta.equalsIgnoreCase("B1") || opcionesVenta.equalsIgnoreCase("C1")
                            || opcionesVenta.equalsIgnoreCase("C2")));
                    
                    if(opcionesVenta.equalsIgnoreCase("A1")){
                        cafetera.servirCafeSolo();
                    }else if(opcionesVenta.equalsIgnoreCase("A2")){
                        cafetera.servirCafeLargo();
                    }else if(opcionesVenta.equalsIgnoreCase("A3")){
                        cafetera.servirCafeLeche();
                    }else if(opcionesVenta.equalsIgnoreCase("A4")){
                        cafetera.servirCafeCortado();
                    }else if(opcionesVenta.equalsIgnoreCase("B1")){
                        cafetera.servirChocolate();
                    }else{
                        cafetera.servirLeche();  
                    }

                    //Muestro los datos al usuario
                    JOptionPane.showMessageDialog(null, "[Daw Coffee]\n"
                            + "Disfrute de su pedido.");
                    break;

                case 2:
                    //ADMINISTRACIÓN DE LA CAFETERA//
                    String opcionesAdministracion;

                    //Utilizo un bucle do-while para controlar que el usuario elige una opción disponible
                    do {
                        //Muestro al usuario las opciones disponibles
                        opcionesAdministracion = JOptionPane.showInputDialog("[Daw Coffee]\n"
                                + "Elije una opción para administrar la cafetera:\n"
                                + "1.- Comprobar depósitos\n"
                                + "2.- Comprobar estado general\n"
                                + "3.- Consultar saldo de ventas\n"
                                + "4.- Rellenar depósitos");

                        //Paso el String "opcion" a int haciendo un parseo
                        opcionElegida = Integer.parseInt(opcionesAdministracion);
                    } while (opcionElegida < 1 || opcionElegida > 4);
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
}
