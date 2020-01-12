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
        
        //Creación e instanciación de la Cafetera y sus componentes
        Deposito leche = new Deposito("leche", 1000, 300, 1000, false);
        Deposito cafe = new Deposito("café", 2000, 500, 2000, false);
        Deposito chocolate = new Deposito("chocolate", 1000, 300, 1000, false);
        Deposito agua = new Deposito("agua", 2000, 500, 2000, false);
        Deposito azucar = new Deposito("azucar", 1000, 200, 1000, false);
        
        //Cafetera cafetera1 = new Cafetera(double saldoCliente, double saldoAcumulado, int numVentasRealizadas, Deposito leche, Deposito cafe, Deposito chocolate, Deposito agua, Deposito azucar, Usuario admin);
        Cafetera cafetera = new Cafetera(0, 0, 0, leche, cafe, chocolate, agua, azucar, administrador);
        
        //Ejecuto el menú
        Menu.Menu(cafetera);
        
        //System.out.println(cafetera.toString()); --Comprobación
    }
}
