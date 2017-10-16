/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import iudesign.*;

/**
 *
 * @author ferna
 */
public class SimpleFactory {

    public SimpleFactory() {
    }
    
    public static void constructorObjetos(int x) {
        //AQUI SE DETERMINA QUE OBJETO SE CONTRUIRÁ DEPENDIENDO DEL VALOR DE X

        switch (x) {
            case 1: {
                new splashscreen().setVisible(true); //Para mostrar el login
                break;
            }
            case 2: {
                new loginn().setVisible(true); //Para mostrar el login
                break;
            }
            case 3: {
                new registrarse().setVisible(true); //Para mostrar el formulario de registro
                break;
            }
            case 4: {
                new registrarseGuia().setVisible(true); //Para mostrar el formulario de registro
                break;
            }
            default: {
                System.out.println("Ocurrio un error en la creación de objetos");
                break;
            }
        }
    }
    
    public static void constructorObjetosVariables(int x, String fullName, String materia) {
        //AQUI SE DETERMINA QUE OBJETO SE CONTRUIRÁ DEPENDIENDO DEL VALOR DE X

        switch (x) {
            case 1: {
                new menú(fullName, materia).setVisible(true);
                break;
            }
            case 2: {
                new matricula(fullName, materia).setVisible(true);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            default: {
                System.out.println("Ocurrio un error en la creación de objetos");
                break;
            }
        }
    }
}
