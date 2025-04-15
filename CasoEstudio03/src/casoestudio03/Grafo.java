/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoestudio03;

/**
 *
 * @author fernandafajardo
 */
public class Grafo {

    private NodoGrafo[] nodos;
    private String[][] matrizAdyacencia;
    private int cantidadActual;
    
    public Grafo(int cantidadNodos){
        
        nodos = new NodoGrafo[cantidadNodos];
        matrizAdyacencia = new String[cantidadNodos][cantidadNodos];
        cantidadActual = 0;
    }
    
    public void insertarNodo(String nombreEtapa, String rolEjecutor){
        
        if(cantidadActual < nodos.length){
          nodos[cantidadActual++] = new NodoGrafo(nombreEtapa, rolEjecutor);  
        }
    }
    
    public void agregarAristaAccion(int origen, int destino, String accion){
        matrizAdyacencia[origen][destino] = accion;
    }
    
    public void imprimirMatrizAdyacencia(){
        
        System.out.println("Matriz de adyacencia: ");
        for(int i = 0; i < matrizAdyacencia.length; i++){
            for(int j = 0; j < matrizAdyacencia[i].length; j++){
                String accion = matrizAdyacencia[i][j];
                System.out.print((accion != null ? accion : "-") + "\t");
            }
            System.out.println();
        }
    }
    
    public void imprimirNodos(){
        
        System.out.println("Info de los nodos: ");
        for(NodoGrafo nodo : nodos){
            if(nodo != null){
                nodo.imprimirInfo();
            }
        }
    }
 
}
