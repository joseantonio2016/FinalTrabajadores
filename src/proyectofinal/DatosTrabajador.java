/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author JOSE ANTONIO HUILLCA PAUCAR
 */
public class DatosTrabajador {
    private String nombre, direccion,codigo;
    private int dni;

    public DatosTrabajador(String nombre, String direccion, String codigo, int dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo = codigo;
        this.dni = dni;
    }
    
    public DatosTrabajador[] datosTrab = new DatosTrabajador[50];
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
}
