/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ccc.poo.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaqson
 */
public class PessoaDaoImplJdbc implements PessoaDao {

    @Override
    public void incluir(Pessoa objeto) throws IncluirException {
        try {
            String sql = "INSERT INTO pessoa (codigo, nome, salario, nascimento, mora_codigo) "
                    + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = ConexaoSingleton.getInstance().getPreparedStatement(sql);
            pst.setInt(1, objeto.getCodigo());
            pst.setString(2, objeto.getNome());
            pst.setDouble(3, objeto.getSalario());
            pst.setDate(4, new java.sql.Date(objeto.getNascimento().getTime()));
            pst.setInt(5, objeto.getMora().getId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            throw new IncluirException(ex.getMessage());
        }

    }

    @Override
    public Pessoa obter(Integer codigo) throws ObterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Pessoa objeto) throws AlterarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Pessoa objeto) throws ExcluirException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Integer codigo) throws ExcluirException {
        try {
            String sql = "DELETE FROM pessoa "
                    + "WHERE codigo = "+codigo.toString()+";";
            PreparedStatement pst = ConexaoSingleton.getInstance().getPreparedStatement(sql);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoImplJdbc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getSQLState());
        }
    }

    @Override
    public List<Pessoa> obterTodos(String ordem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pessoa> obterTodos() {
        List<Pessoa> pes = new ArrayList<>();
        try {
            String sql =  "select pessoa.codigo, pessoa.nome, cidade.codigo as cid_codigo, cidade.nome as cid_nome, cidade.uf, pessoa.salario, pessoa.nascimento "
                        + "from pessoa "
                        + "join cidade on pessoa.mora_codigo = cidade.codigo "
                        + "order by pessoa.nome";
            ResultSet rs = ConexaoSingleton.getInstance().getStatement().executeQuery(sql);
            while (rs.next()) {
                pes.add(new Pessoa( rs.getInt("codigo"),
                                    rs.getString("nome"),
                                    new Cidade(
                                        rs.getInt("cid_codigo"),
                                        rs.getString("cid_nome"),
                                        rs.getString("uf")),
                                    rs.getDouble("salario"),
                                    rs.getDate("nascimento")
                        ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PessoaDaoImplJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pes;
    }

    @Override
    public void reajustarSalario(Double percentual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cidade> obterCidades() {
        List<Cidade> cids = new ArrayList<>();
        try {
            String sql = "select * from cidade order by nome";
            ResultSet rs = ConexaoSingleton.getInstance().getStatement().executeQuery(sql);
            while (rs.next()) {
                cids.add(new Cidade(rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("uf")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PessoaDaoImplJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cids;
    }

    @Override
    public void inicializarCidades() {

    }

}
