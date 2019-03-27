/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ccc.poo.testes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jaqson
 */
public class TesteColecoes01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instanciar um arraylist
        ArrayList lista = new ArrayList();
        lista.add("Uma String");
        lista.add(new Date());
        lista.add(new Pessoa(1, "João"));
        lista.add(new Pessoa(2, "Maria"));
        
        Pessoa p = new Pessoa(3, "Pedro");
        lista.add(p);
        
        
        // Mostrar o conteúdo da coleção
        mostrar(lista);
        System.out.println("------------------------");
        System.out.println(lista);
        System.out.println("------------------------");
        mostrarComTipo(lista);
        
    }

    private static void mostrar(ArrayList lista) {
        for(Object o : lista){
            System.out.println(o.toString());
        } 
    }

    private static void mostrarComTipo(ArrayList lista) {
        for(Object o : lista){
            if (o.getClass().getSimpleName().equals("Pessoa")){
               Pessoa p = (Pessoa) o;
               System.out.println(p.nome+" - "+p.codigo);
            }else if (o instanceof Date){
                String mostra = new SimpleDateFormat("dd-MM-yyyy").format(o);
                System.out.println(mostra);
            }else
                System.out.println(o.toString());
        }         
    }
    
    private static class Pessoa{
        Integer codigo;
        String nome;

        public Pessoa(Integer codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        @Override
        public String toString() {
            return codigo + " | " + nome;
        }
        
        
        
    }
    
}
