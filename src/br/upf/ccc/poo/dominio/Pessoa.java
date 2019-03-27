/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ccc.poo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jaqson
 */
public class Pessoa implements Serializable{
    private Integer codigo;
    private String nome;
    private Double salario;
    private Date nascimento;
    private Cidade mora;

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Pessoa(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Pessoa() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigo=" + codigo + ", nome=" + nome + ", mora=" + mora + '}';
    }

    public Pessoa(Integer codigo, String nome, Cidade mora, Double salario, Date nascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.mora = mora;
        this.salario = salario;
        this.nascimento = nascimento;
    }

    public Pessoa(Integer codigo, String nome, Cidade mora) {
        this.codigo = codigo;
        this.nome = nome;
        this.mora = mora;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getMora() {
        return mora;
    }

    public void setMora(Cidade mora) {
        this.mora = mora;
    }
    
    
}
