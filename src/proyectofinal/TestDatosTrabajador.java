/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.util.Scanner;

/**
 *
 * @author JOSE ANTONIO HUILLCA PAUCAR
 */
public class TestDatosTrabajador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Vamos a mostrar dos tipos de menu
        //Menu Inicial: Cuando no tenemos ningun trabajador existente
        //en el array no tendria sentido mostrar un menu completo,
        //cuando el sistema detecta que hay uno o mas registros validos
        //entonces se puede mostrar el 
        //Menu Completo de seis opciones(1-6) del programa mas la salida (0).
        //Como alternativa puse una linea donde se pide que ingrese el numero
        //de la opcion del menu, y si se quiere visualizar el menu, se escribe
        // la letra m o M, eso cuando se pierda de vista o no se acuerde de las
        //opciones del menu
        //Para acceder a los metodos de las distintas clases opte por asignarles
        //como metodos estaticos
        //Hay alternativas para salir del proceso de digitacion salir de la
        //opcion del menu y tambien del programa.
        //Para mayor comodidad utilice expresiones regulares para validar que los
        //datos ingresados sean los correctos o se pida nuevamente la insercion
        //de datos en casos cuando no se respeten esas validaciones.
        Scanner sn = new Scanner(System.in);
        DatosTrabajador dataTrabaj = new DatosTrabajador("", "", "", 0);
       boolean salir = false;
       boolean menuActivo=true;
       int datosIngresados=0;
       int opcion; //Guardaremos la opcion del usuario
       
        
       while(!salir){
           if (datosIngresados==0){
           mostrarMenuInicial();
           String op = sn.next();
           if (op.matches("[0-1]"))
               opcion = Integer.parseInt(op);
           else opcion=-1;
           switch(opcion){
               case 1:
                   datosIngresados=IngresoDatos.ingresa(dataTrabaj.datosTrab, sn);
                   if (datosIngresados>0)menuActivo=true;
                   break;
                case 0:
                   salir=true;
                   break;
                default:
                   System.out.println("Error de digitacion. Elegir entre 0 y 1");
           }
           }
           else{
               String verMenu;
            if (menuActivo){
                mostrarMenu();
                verMenu=sn.next();
             }
            else{
                System.out.println("Ingrese un numero de accion (0-6) del menu o tecla 'M' para ver menu");
                verMenu = sn.next();
                if (verMenu.equalsIgnoreCase("M")){
                    mostrarMenu();
                    verMenu=sn.next();
                }
            }
            if (verMenu.matches("[0-6]"))
                opcion=Integer.parseInt(verMenu);
            else{
                System.out.println("Menu incorrecto, terminará el sistema");
                opcion=0;
            }
            menuActivo=false; 
           switch(opcion){
               case 1:
                   datosIngresados=IngresoDatos.ingresa(dataTrabaj.datosTrab, sn);
                   if (datosIngresados>0)menuActivo=true;
                   break;
               case 2:
                   ListadoTrabajadores.lista(dataTrabaj.datosTrab, datosIngresados);
                   break;
                case 3:
                   BusquedaTrab.buscar(dataTrabaj.datosTrab, datosIngresados, sn);
                   break;
                case 4:
                   OrdenamientoTrab.ordenDni(dataTrabaj.datosTrab, datosIngresados);
                   break;
                case 5:
                   datosIngresados =
                           InsertTrabajador.insert(dataTrabaj.datosTrab, datosIngresados, sn);
                   break;
                case 6:
                   datosIngresados =
                           EliminarTrabajador.elim(dataTrabaj.datosTrab, datosIngresados, sn);
                   break;
                case 0:
                   salir=true;
                   break;
                default:
                   System.out.println("Solo un número entre 0 y 6");
           }
           }
           
            
       }
        
    }
    public static void mostrarMenu(){
    System.out.println("Ingrese el numero de menu segun la accion deseada");
           System.out.println("0. Salir del programa");
           System.out.println("1. Ingresar datos");
           System.out.println("2. Listar trabajadores");
           System.out.println("3. Buscar un trabajador");
           System.out.println("4. Ordenar trabajadores por DNI");
           System.out.println("5. Insertar trabajador en la posicion deseada");
           System.out.println("6. Eliminar trabajador");
    }
    public static void mostrarMenuInicial(){
    System.out.println("Ingrese el numero de menu segun la accion deseada");
           System.out.println("0. Salir del programa");
           System.out.println("1. Ingresar datos");
           
    }
    
    
    
}
