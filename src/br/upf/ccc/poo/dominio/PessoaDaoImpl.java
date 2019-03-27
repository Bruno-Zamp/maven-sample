package br.upf.ccc.poo.dominio;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PessoaDaoImpl implements PessoaDao {

    @Override
    public void incluir(Pessoa objeto) throws IncluirException {
        PESSOAS.add(objeto);
    }

    @Override
    public Pessoa obter(Integer id) throws ObterException {
        if (!PESSOAS.contains(new Pessoa(id))) {
            throw new ObterException("O Objeto não está contido na Lista");
        } else {
            return PESSOAS.get(PESSOAS.indexOf(new Pessoa(id)));
        }
    }

    @Override
    public void alterar(Pessoa objeto) throws AlterarException {
        if (!PESSOAS.contains(objeto)) {
            throw new AlterarException("O Objeto não está contido na Lista");
        } else {
            PESSOAS.set(PESSOAS.indexOf(objeto), objeto);
        }
    }

    @Override
    public void excluir(Pessoa objeto) throws ExcluirException {
        if (PESSOAS.contains(objeto)) {
            PESSOAS.remove(objeto);
        } else {
            throw new ExcluirException("O Objeto não está contido na Lista");
        }

    }

    @Override
    public void excluir(Integer id) throws ExcluirException {
        if (PESSOAS.contains(new Pessoa(id))) {
            PESSOAS.remove(new Pessoa(id));
        } else {
            throw new ExcluirException("O Objeto não está contido na Lista");
        }
    }

    @Override
    public List<Pessoa> obterTodos() {
        return PESSOAS;
    }

    @Override
    public List<Pessoa> obterTodos(String ordem) {
        switch (ordem) {
            case "codigo": {
                PESSOAS.sort((Pessoa o1, Pessoa o2) -> o1.getCodigo().compareTo(o2.getCodigo()));
                break;
            }
            case "nome": {
                Comparator<Pessoa> ordemNome = new Comparator<Pessoa>() {
                    @Override
                    public int compare(Pessoa obj1, Pessoa obj2) {
                        return obj1.getNome().compareTo(obj2.getNome());
                    }
                };
                Collections.sort(PESSOAS, ordemNome);
                break;
            }
            case "salario": {
                PESSOAS.sort((Pessoa o1, Pessoa o2) -> o1.getSalario().compareTo(o2.getSalario()));
                break;
            }
            case "nascimento": {
                PESSOAS.sort((Pessoa o1, Pessoa o2) -> o1.getNascimento().compareTo(o2.getNascimento()));
                break;
            }
        }
        return PESSOAS;
    }

    @Override
    public void reajustarSalario(Double percentual) {
        for (Pessoa a : PESSOAS) {
            a.setSalario(a.getSalario() * percentual);
        }
    }

    @Override
    public void inicializarCidades() {      //Criando 3 Cidades Fictícias  
        Cidade Cit = new Cidade(125, "Nova Bassano", "RS");
        CIDADES.add(Cit);
        Cit = new Cidade(356, "Passo Fundo", "RS");
        CIDADES.add(Cit);
        Cit = new Cidade(658, "São Paulo", "SP");
        CIDADES.add(Cit);
    }

    @Override
    public List<Cidade> obterCidades() {
        return CIDADES;
    }

}
