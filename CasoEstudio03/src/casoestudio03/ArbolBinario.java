/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoestudio03;

import java.util.*;

/**
 *
 * @author fernandafajardo
 */
public class ArbolBinario {
        private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    //Método wrapper
    public void insertar(int dato){
        raiz = insertarRecursivo(raiz,dato);
    }
    
    //Método recursivo
    private Nodo insertarRecursivo(Nodo nodoActual, int valor){
        
        // Caso 1: El nodo actual está vacío
        if(nodoActual == null){ // Condición de parada
            return new Nodo(valor); // Se crea la cajita
        }else{
            // Caso 2: Que el nodo a insertar sea menor a la rama actual
            if(valor < nodoActual.getDato()){
                nodoActual.setIzquierda(insertarRecursivo(nodoActual.getIzquierda(), valor));
            }else if (valor > nodoActual.getDato()){
                nodoActual.setDerecha(insertarRecursivo(nodoActual.getDerecha(), valor));
            }
        }
        return nodoActual;
    }
    
    // Recorridos de árboles //
    
    public void inOrden(){
        inOrdenRec(raiz);
    }
    
    //Método recursivo que recorre el árbol en orden
    private void inOrdenRec(Nodo actual){
        
        if(actual != null){
            inOrdenRec(actual.getIzquierda()); // Vuelva a entrar recursivamente pero evaluando el hijo izquierdo
            System.out.println(actual.getDato()); 
            inOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente pero evaluando el hijo derecho
        }
    }
    
    public void preOrden(){
        preOrdenRec(raiz);
    }
    
    //Método recursivo que recorre el árbol en orden
    private void preOrdenRec(Nodo actual){
        
        if(actual != null){
            System.out.println(actual.getDato());
            preOrdenRec(actual.getIzquierda()); // Vuelva a entrar recursivamente pero evaluando el hijo izquierdo 
            preOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente pero evaluando el hijo derecho
        }
    }
    
    public void postOrden(){
        postOrdenRec(raiz);
    }
    
    //Método recursivo que recorre el árbol en orden
    private void postOrdenRec(Nodo actual){
        
        if(actual != null){
            postOrdenRec(actual.getIzquierda()); // Vuelva a entrar recursivamente pero evaluando el hijo izquierdo 
            postOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente pero evaluando el hijo derecho
            System.out.println(actual.getDato());
        }
    }
    
    //Método para eliminar
    public void eliminar(int valor){
        raiz = eliminarRec(raiz, valor);
    }
    
    private Nodo eliminarRec(Nodo actual, int valor){
        // Condición de parada
        if(actual == null)return actual;
        
        //Buscar el nodo a la izq o a la derecha
        if(valor < actual.getDato()){ // Vamos a buscar en la izq del árbol
            actual.setIzquierda(eliminarRec(actual.getIzquierda(), valor));
        }else if(valor > actual.getDato()){ // Vamos a buscar en la derecha del árbol
            actual.setDerecha(eliminarRec(actual.getDerecha(), valor));
        }else{ // Ya lo encontre, es igual
            //Caso 1: Nodo sin hijo
            if(actual.getIzquierda() == null && actual.getDerecha() == null){
                return null; // Elimina la hoja y la sustituye por un null
            }
            //Caso 2: Nodo con 1 hijo
            if(actual.getIzquierda() == null){
                return actual.getDerecha();
            }else if(actual.getDerecha() == null){
                return actual.getIzquierda();
            }
            //Caso 3: Nodo con 2 hijos
            Nodo sucesor = minValorSucedor(actual.getDerecha()); // Nos devuelve el sucesor del número que queremos eliminar
            actual.setDato(sucesor.getDato()); // Ya tenemos reemplazado el valor
            actual.setDerecha(eliminarRec(actual.getDerecha(), sucesor.getDato())); //
        
        }
        return actual;
    }
    
    private Nodo minValorSucedor(Nodo nodo){
        while(nodo.getIzquierda() != null){
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }
    
    public int obtenerNivel(int valor, int nivel){
        return obtenerNivelRec(raiz,valor, nivel);
    }
    
    private int obtenerNivelRec(Nodo actual, int valor, int nivel){
        if(actual == null) return -1;
        
        if(actual.getDato() == valor) return nivel; // Si encuentro el valor retorno su nivel
        int nivelIzq = obtenerNivelRec(actual.getIzquierda(), valor, nivel +1);
        if(nivelIzq != -1) return nivelIzq; //Significa que encontre el valor que ando buscando;
        return obtenerNivelRec(actual.getDerecha(), valor, nivel +1);
    }
    
    public int obtenerAltura(Nodo actual){
        if(actual == null) return -1;
        int alturaIzq = obtenerAltura(actual.getIzquierda());
        int alturaDer = obtenerAltura(actual.getDerecha());
        int alturaMayor = Math.max(alturaIzq, alturaDer) +1; // Compara cual de las 2 ramas es mas larga
        return alturaMayor;
    }
    
    
    public boolean verificarNumero(int valor) {
        return verificarNumeroRec(raiz, valor);
    }

    private boolean verificarNumeroRec(Nodo actual, int valor) {
        if (actual == null) return false;
        if (actual.getDato() == valor) return true;
        return valor < actual.getDato() ? verificarNumeroRec(actual.getIzquierda(), valor) : verificarNumeroRec(actual.getDerecha(), valor);
    }
 
    public ArrayList<Integer> obtenerNodosImpar(){
        ArrayList<Integer> numImpares = new ArrayList<>();
        obtenerNodosImparRec(raiz,numImpares);
        return numImpares;
    }
    
    public void obtenerNodosImparRec(Nodo actual, ArrayList<Integer> numImpares){
        if(actual != null){
            obtenerNodosImparRec(actual.getIzquierda(), numImpares);
            if(actual.getDato() % 2 != 0){
                numImpares.add(actual.getDato());
            }
            obtenerNodosImparRec(actual.getDerecha(), numImpares);
        }
    }
    
}
