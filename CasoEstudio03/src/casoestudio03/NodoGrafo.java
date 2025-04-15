/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoestudio03;

/**
 *
 * @author fernandafajardo
 */
public class NodoGrafo {
    
    private String nombreEtapa;
    private String rolEjecutor;

    public NodoGrafo(String nombreEtapa, String rolEjecutor) {
        this.nombreEtapa = nombreEtapa;
        this.rolEjecutor = rolEjecutor;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public String getRolEjecutor() {
        return rolEjecutor;
    }

    public void setRolEjecutor(String rolEjecutor) {
        this.rolEjecutor = rolEjecutor;
    }
    
    public void imprimirInfo(){
        System.out.println("Etapa: " + nombreEtapa + ", Rol: " + rolEjecutor);
    }
}
