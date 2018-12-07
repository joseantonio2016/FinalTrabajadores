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
public class OrdenamientoTrab {
    public static void ordenDni(DatosTrabajador[] datT, int datIng){
        System.out.println("Ordenando registros por DNI (ASC)");
        DatosTrabajador aux;
        for (int i = 0; i < datIng; i++) 
            for (int j = 0; j < datIng-1; j++) {
                if(datT[j].getDni()>datT[j+1].getDni()){
                aux = datT[j];
                datT[j]=datT[j+1];
                datT[j+1]=aux;
                } 
            }
        ListadoTrabajadores.lista(datT, datIng);
     }
        
    
    
}
