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
public class BusquedaTrab {
    public static void buscar(DatosTrabajador[] datT,int cantT,Scanner sn){
        int ret = -1;
        boolean enc=false;
        System.out.print("Ingrese aqui el codigo a buscar: ");
        String cod = sn.next();
        for (int i = 0; i < cantT; i++) {
            if(datT[i].getCodigo().equalsIgnoreCase(cod)){
            ret=i;
            enc=true;
            break;
            }
        }
        if (enc){
            System.out.format("|%-8s|%-25s|%-25s|%9s|%n","Codigo","Nombre","Direccion"," Nro DNI ");
            DatosTrabajador d = datT[ret];
            System.out.format("|%-8s|%-25s|%-25s| %8s |%n",
                    d.getCodigo(),d.getNombre(),d.getDireccion(),d.getDni());
        }
        else{
            System.out.println("CODIGO NO EXISTE");
        
        } 
    }
}
