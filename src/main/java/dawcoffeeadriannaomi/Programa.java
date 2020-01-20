/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffeeadriannaomi;

/**
 *
 * @author Nao
 */
public class Programa {

    public static void main(String[] args) {

        //Creo e instancio el usurio con acceso al panel de administración
        Usuario administrador = new Usuario("adminCafeStoreZ5", "CZr4t89SDF");

        //Creación e instanciación de los componentes de la cafetera
        Deposito leche = new Deposito("leche", 1000, 1000, false);
        Deposito cafe = new Deposito("café", 2000, 2000, false);
        Deposito cafeDescafeinado = new Deposito("café descafeinado", 2000, 2000, false);
        Deposito chocolate = new Deposito("chocolate", 1000, 1000, false);
        Deposito agua = new Deposito("agua", 2000, 2000, false);
        Deposito azucar = new Deposito("azucar", 1000, 1000, false);
        Deposito sacarina = new Deposito("sacarina", 500, 500, false);
        
        //Creo e instancio la cafetera
        Cafetera cafetera = new Cafetera(0, 0, leche, cafe, cafeDescafeinado, chocolate, agua, azucar, sacarina, administrador);

        //Ejecuto el menú y le paso la cafetera
        Menu.Menu(cafetera);

        //System.out.println(cafetera.toString()); --Comprobación
    }
}
