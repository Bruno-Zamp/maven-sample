/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ccc.poo.testes;

import br.upf.ccc.poo.dominio.Cidade;
import br.upf.ccc.poo.dominio.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaqson
 */
public class TesteColecoes02 {

    private static List<Cidade> listCid = new ArrayList<>();
    private static List<Pessoa> listPes = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //listCid.add("teste");
        listCid.add(new Cidade(1, "Passo Fundo"));
        listCid.add(new Cidade(2, "Marau"));
        listCid.add(new Cidade(3, "Alegrete"));
        listCid.add(new Cidade(4, "Soledade"));
        
        listPes.add(new Pessoa(1, "Paulo", listCid.get(2)));
        listPes.add(new Pessoa(2, "Maria", listCid.get(3)));
        listPes.add(new Pessoa(3, "Pedro", listCid.get(0)));
        
        System.out.println(listCid);
        System.out.println(listPes);
        
        System.out.println("------------------------------");
        Pessoa p = new Pessoa(2, "Maria", listCid.get(3));
        if (listPes.get(1).equals(p))
            System.out.println("Objetos iguais!");
        else
            System.out.println("Objetos diferentes");
        
        System.out.println("------------------------------");
        Pessoa p2 = new Pessoa(2, "Maria", listCid.get(3));
        if (listPes.get(1) == p2)
            System.out.println("Objetos iguais usando ==!");
        else
            System.out.println("Objetos diferentes usando ==");        
        
        System.out.println("------------------------------");
        Pessoa p3 = new Pessoa(2, "Maria", listCid.get(3));
        if (listPes.contains(p3))
            System.out.println("Objeto ja está na lista");
        else
            System.out.println("Objeto não está na lista");        
        System.out.println("-------------------------------");
        System.out.println("Posição: "+listPes.indexOf(p3));
        
        System.out.println("-------------------------------");
        System.out.println("Remover uma cidade");
        listCid.remove(new Cidade(4));
        System.out.println(listCid);
        System.out.println(listPes);
        
    }
    
}
