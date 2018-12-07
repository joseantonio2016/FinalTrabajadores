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
public class InsertTrabajador {
    public static int insert(DatosTrabajador[] datT, int datIng, Scanner sn){
        /*OPCIONES
        1. Aunque el array soporta hasta 50 datos, no se permite vacios entre posiciones
        1. Si lo ingresa en la posicion de datos ingresados, no se mueve las posiciones anteriores
        2. Si lo ingresa al principio o entre los datos ingresados, se moveran posiciones
        RESTRICCIONES
        El maximo es datIng + 1, puesto que suma la cantidad total de datos mas el nuevo
        Se valida para evitar que la posicion ingresada sobrepase esa cantidad o 50.
        Para el usuario la posicion inicial es uno, mientras que el sistema toma a 0
        */
        System.out.println("Ingrese la posicion a insertar.Min: 1, Max: "+
                (datIng+1)+". Digite '0' para salir.");
        int ret = datIng;
        int pos = -1;
        do{
            try {
                pos = sn.nextInt();
                if (pos==0){
                    System.out.println("Saldrá de esta opcion");
                    break;
                }else
                    if (pos > (datIng+1)||(pos>50)){
                        System.out.println("Ingreso un numero mayor al permitido");
                        pos=-1;
                    }else
                        if(pos==(datIng+1)){
                               System.out.println("--------"+pos+"--------");
                               DatosTrabajador datTrab = IngresoDatos.datosTrab(datT, datIng, sn);
                               if (datTrab!=null){
                               datT[pos-1]=datTrab;
                               ret=datIng+1;
                               System.out.println("Tabla actualizada. Inserción en la posicion "+pos);
                                 ListadoTrabajadores.lista(datT, ret);
                               }
                               else
                               System.out.println("Error  al insertar trabajador. Sin cambios");      
                        }
                        else
                            if (pos<(datIng+1)){
                            int rpos=pos-1;
                               System.out.println("--------"+pos+"--------");
                DatosTrabajador dTrab=IngresoDatos.datosTrab(datT, datIng, sn);
                               if (dTrab!= null){
                               for (int i = datIng; i > rpos ; i--) datT[i]=datT[i-1];
                                datT[rpos]=dTrab;
                                ret=datIng+1;
                               System.out.println("Tabla actualizada. Inserción en la posicion "+pos);
                                 ListadoTrabajadores.lista(datT, ret);
                               }
                               else
                               System.out.println("Error  al insertar trabajador. Sin cambios");      
                        }       
            } catch (NumberFormatException e) {
                System.out.println("Error al digitar posicion");
                pos=-1;
            }
        }while(pos<0);
        return ret;
    }
    
    
}
