/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;


import java.util.Scanner;

/**
 *
 * @author jose
 */
public class IngresoDatos {
    public static int ingresa(DatosTrabajador[] datTrab,Scanner sn){

        int ret = 0, cantTrab=0;
        //valida que el numero de registros sea por lo menos uno, si no, sigue pidiendo
        //que ingrese un numero del 1 al 50, si digita 0 sale de la opcion
        do{
            System.out.println("Ingrese numero de registros, Max. 50. Para salir digite 0");
            String strab =  sn.next();
            if (strab.matches("[0-9]|[1-4][0-9]|50")){
            cantTrab=Integer.parseInt(strab);
            if (cantTrab==0){
                System.out.println("Salió sin ingresar datos");
                break;
            }
            int i = 0;
                
                   for (; i < cantTrab; i++) {
                       System.out.println("-----------"+(i+1)+"-----------");
                       DatosTrabajador dTrab = datosTrab(datTrab, i, sn);
                       if (dTrab==null)break;
                       else datTrab[i]=dTrab;
            } 
                  if (i==0)System.out.println("Ningun trabajador se pudo registrar");
                  else if (i<cantTrab){
                       System.out.println("Solo ingresó "+i+" registros");
                   }
                  else if(i==cantTrab)
                       System.out.println("Terminó de ingresar "+i+" registros");
                ret=i;
            }else{
                System.out.println("Error al digitar");
            } 
        }while(ret<1);
     
        return ret;
    }
    
    public static DatosTrabajador datosTrab(DatosTrabajador[] datT, int datIng, Scanner sn){
    DatosTrabajador ret=null;
    String codigo, nombre,direccion;
    int dni;
    boolean nombreRepetido,codigoRepetido,dniRepetido;
     
    sn.nextLine();
                //valida que el codigo ingresado no sea repetido,
                //si es blanco se sale de la opcion
                do {
                    codigoRepetido=false;
                    System.out.println("Ingrese codigo: (Dejar vacio para salir)");
                    codigo=sn.nextLine();
                    if(codigo.isEmpty()){
                        System.out.println("No escribió nada, saldrá de la opción");
                    return ret;
                    }
                    for (int i = 0; i < datIng; i++) 
                                if(codigo.equalsIgnoreCase(datT[i].getCodigo())){
                                    codigoRepetido=true;
                                    System.out.println("Codigo repetido, ingrese otro");
                                    break;
                                }
                } while (codigoRepetido);
                //valida que el nombre ingresado no sea repetido,
                //si es blanco se sale de la opcion
                do {
                    nombreRepetido=false;
                    System.out.println("Ingrese nombre: (Dejar vacio para salir)");
                    nombre=sn.nextLine();
                    if(nombre.isEmpty()){
                        System.out.println("No escribió nada, saldrá de la opción");
                    return ret;
                    }
                    for (int i = 0; i < datIng; i++) 
                                if(nombre.equalsIgnoreCase(datT[i].getNombre())){
                                    nombreRepetido=true;
                                    System.out.println("Nombre repetido, ingrese otro");
                                    break;
                                } 
                } while (nombreRepetido);
                System.out.println("Ingrese direccion");
                direccion=sn.nextLine();
                //valida que el dni ingresado no sea repetido,
                //debe contener 8 caracteres numericos o saldra de la opcion
                do {
                    dniRepetido=false;
                    System.out.println("Ingrese DNI");
                    String sdni =sn.next();
                    if (!sdni.matches("[0-9]{8}")){
                    System.out.println("Error al digitar dni, saldrá de la opción");
                    return ret;
                }else dni = Integer.parseInt(sdni);
                    for (int i = 0; i < datIng; i++) 
                                if(dni==datT[i].getDni()){
                                    dniRepetido=true;
                                    System.out.println("DNI repetido, ingrese otro");
                                    break;
                                } 
                   } while (dniRepetido);
        
                
                ret= new DatosTrabajador(nombre, direccion, codigo, dni);
    return ret;
    }
    
}
