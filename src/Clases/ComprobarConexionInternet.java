/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import iudesign.menú;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class ComprobarConexionInternet {

    public ComprobarConexionInternet() {
    }
    
    public boolean comprobarConexion() {

        boolean conex = false;
            try {
                String dirWeb = "www.google.com";
                int puerto = 80;
                Socket s = new Socket(dirWeb, puerto);
                if (s.isConnected()) {
                    System.out.println("Conexión establecida con la dirección: " + dirWeb + " a travéz del puerto: " + puerto);
                    System.out.println("Por lo tanto la ejecución puede continuar");
                    conex = true;
                }
            } catch (IOException ex) {
                Logger.getLogger(menú.class.getName()).log(Level.SEVERE, null, ex);
                
                //SI OCURRE UNA EXCEPCION, SE DETENDRA LA EJECUCION
                //PARA EL CASO SI LA CONEXION A INTERNET DEJA DE EXISTIR, SE SALDRA DE LA APLICACIÓN
                JOptionPane.showMessageDialog(null, "Este programa precisa de una conexión "
                            + "a internet para poder funcionar\nPor favor revise "
                            + "su conexión a internet\nPor motivos de seguridad la "
                            + "aplicación se cerrara ahora\nLe rogamos que tenga "
                            + "una conexión estable para usar esta aplicación"
                            , "Información", 0);
                    System.exit(0);
            }
        return conex;
    }
}
