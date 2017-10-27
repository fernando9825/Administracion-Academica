/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import iudesign.*;
import static iudesign.ingresoNotas.fullName;
import static iudesign.ingresoNotas.materia;
import static iudesign.ingresoNotas.seccion;

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
    
    public static void constructorObjetosVariables(int x, String fullName, String materia, String seccion) {
        //AQUI SE DETERMINA QUE OBJETO SE CONTRUIRÁ DEPENDIENDO DEL VALOR DE X

        switch (x) {
            case 1: {
                new menúGuia(fullName, materia, seccion).setVisible(true);
                break;
            }
            case 2: {
                new matriculaTabla(fullName, materia, seccion).setVisible(true);
                break;
            }
            case 3: {
                new menúNormal(fullName, materia, seccion).setVisible(true);
                break;
            }
            case 4: {
                new ingresoNotas(fullName, materia, seccion).setVisible(true);
                break;
            }
            case 5: {
                new modify(fullName, materia, seccion).setVisible(true);
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
