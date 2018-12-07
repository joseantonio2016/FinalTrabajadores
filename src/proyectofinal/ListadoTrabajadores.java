/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author jose
 */
public class ListadoTrabajadores {
    public static void lista(DatosTrabajador[] datosT, int cantAct){
        System.out.format("|%-8s|%-25s|%-25s|%9s|%n","Codigo","Nombre","Direccion"," Nro DNI ");
        for (int i = 0; i < cantAct; i++) {
            DatosTrabajador d = datosT[i];
            System.out.format("|%-8s|%-25s|%-25s| %8s |%n",
                    d.getCodigo(),d.getNombre(),d.getDireccion(),d.getDni());
        }
    }
    
}
