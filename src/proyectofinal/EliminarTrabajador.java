/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
System.out.println("Ingrese la posicion a eliminar.Min: 1, Max: "+
                datIng+". Digite '0' para salir.");
 */
package proyectofinal;

import java.util.Scanner;

/**
 *
 * @author jose
 */
public class EliminarTrabajador {
    public static int elim(DatosTrabajador[] datT, int datIng, Scanner sn){
        //Para eliminar un trabajador podemos elegir eliminarlo segun su codigo
        //o su nombre, las alternativas correspondientes son C o N
        //busca el nombre, devuelve la posicion, quita el objeto del array
        //y muestra los resultados en una tabla actualizada
        //Para salir de la opcion se deja en blanco y se da Enter
        int ret = datIng;
        int busq=-1;
        System.out.println("Elimine un trabajador buscando por nombre (N), codigo (C). Salir de opción con otra tecla");
        String eli = sn.next();
        sn.nextLine();
        if(eli.equalsIgnoreCase("N")){
            System.out.println("Ingrese el nombre del trabajador a eliminar. Salir dejando en blanco");
            String nomBusc = sn.nextLine();
            if (nomBusc.isEmpty())return ret;
            for (int i = 0; i < datIng; i++) 
            if(datT[i].getNombre().equalsIgnoreCase(nomBusc)){
            busq=i;
            break;
            }
        
        } else if(eli.equalsIgnoreCase("C")){
            System.out.println("Ingrese el codigo del trabajador a eliminar. Salir dejando en blanco");
            String codBusc = sn.nextLine();
            if (codBusc.isEmpty())return ret;
            for (int i = 0; i < datIng; i++) 
            if(datT[i].getCodigo().equalsIgnoreCase(codBusc)){
            busq=i;
            break;
            }
        }else {
            System.out.println("Saldrá de la opción Eliminar");
            return ret;
        }
        if (busq<0){
            System.out.println("No se eliminó ningun registro");
            ret=datIng;
        }else {
            for (int i = busq; i < datIng-1; i++) 
                datT[i]=datT[i+1];
            ret=datIng-1;
            System.out.println("Tabla actualizada luego de eliminar un trabajador");
            ListadoTrabajadores.lista(datT, ret);
        }
        
        return ret;
    }
}
