/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.util.LinkedList;

/**
 *
 * @author italo
 */
public class Pilha<T> {
    private LinkedList<T> conteudo;
    
    public Pilha(){
        conteudo= new LinkedList<>();
    }
    
    public boolean estaVazia(){
        return conteudo.isEmpty();
    }
    
    public void empilha(T x){
        conteudo.addFirst(x);
    }
    
    public T desempilha(){
        if(conteudo.isEmpty()){
            throw new Error("Lista vazia");
        }
        else{
        return conteudo.removeFirst();
        }
    }
    
    public T topo(){
        return conteudo.getFirst();
    }
    
    public String toString(){
        return conteudo.toString();
    }
    
    public void reinicializa(){
        while(!estaVazia()){
            desempilha();
        }
    }
    
    public String toStringInverse(){
        Pilha<T> pilhaAux= new Pilha<>();
        
        for (int i=0; i<conteudo.size();i++){
            pilhaAux.empilha(conteudo.get(i));
        }
        
        return pilhaAux.toString();
    }
    
    static void test2() {
        Pilha<Double> aPilha = new Pilha<Double>();
        System.out.println(aPilha);
        aPilha.empilha(1.1);
        System.out.println(aPilha);
        aPilha.empilha(2.1);
        System.out.println(aPilha);
        aPilha.empilha(3.1);
        System.out.println(aPilha);
        double valor = 0.0;
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
    }
    
    public static void main(String[] args){
        test2();
    }
}

