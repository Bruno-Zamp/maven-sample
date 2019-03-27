/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ccc.poo.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 158788
 */
public interface PessoaDao {
    List<Pessoa> PESSOAS = new ArrayList();
    List<Cidade> CIDADES = new ArrayList();
    
    public void incluir (Pessoa objeto) throws IncluirException;
    
    public Pessoa obter(Integer id) throws ObterException;
    
    public void alterar(Pessoa objeto) throws AlterarException;
    
    public void excluir(Pessoa objeto) throws ExcluirException;
    
    public void excluir(Integer id) throws ExcluirException;
    
    public List<Pessoa> obterTodos();
    
    public List<Pessoa> obterTodos(String ordem);
    
    public void reajustarSalario(Double percentual);
    
    public void inicializarCidades();
    
    public List<Cidade> obterCidades();
}
