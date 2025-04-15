/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoestudio03;

import java.util.*;

/**
 *
 * @author fernandafajardo
 */
public class CasoEstudio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //a.Precargue el árbol con la siguiente estructura:  50, 30, 80, 25, 17, 38, 65, 90,78.
        ArbolBinario arbol = new ArbolBinario();
        int[] valoresArbol = {50, 30, 80, 25, 17, 38, 65, 90,78};
        for(int valor : valoresArbol){
            arbol.insertar(valor);
            System.out.println(valor);
        }
        
       //b.Cree un método que reciba como parámetro un número y retorne verdadero o falso si se encuentra dentro del árbol.
       int[] buscarNum = {17, 63};
       for(int valor : buscarNum){
           if(arbol.verificarNumero(valor)){
               System.out.println("El " + valor + " si se encuentra en el árbol.");
           }else{
               System.out.println("El " + valor + " no se encuentra en el árbol.");
           }
       }
       
       //c.Cree un método que recorra el árbol y retorne un arreglo con los nodos impares del árbol.
       ArrayList<Integer> numImpares = arbol.obtenerNodosImpar();
       System.out.println("Los nodos impars del árbol son: ");
       for(int impar : numImpares){
           System.out.println(impar);
       }
       
       //Grafo BPM (Business Process Management)
       Grafo bpm = new Grafo(5);
       
       //ii.Inserte la información de los nodos 
       bpm.insertarNodo("Inicio", "NA");
       bpm.insertarNodo("Recibir documentos", "Técnico");
       bpm.insertarNodo("Analizar solicitud", "Analista");
       bpm.insertarNodo("Aprobar solicitud", "Jefe");
       bpm.insertarNodo("Terminar", "NA");
       
       //iii.Inicialice la matriz de adyacencia.
       bpm.agregarAristaAccion(0, 1, "Avanzar");
       bpm.agregarAristaAccion(1, 2, "Continuar");
       bpm.agregarAristaAccion(2, 3, "Continuar");
       bpm.agregarAristaAccion(3, 4, "Aprobar");
       
       //iv.Imprima la matriz de adyacencia.
       bpm.imprimirMatrizAdyacencia();
       bpm.imprimirNodos();
    }
    
}
