package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Produto;

public class ProdutoDao {

  private final Connection connection;

  public ProdutoDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void adiciona(Produto produto) {
    String sql = "insert into produtos (fornecedor_id, descricao, unidade, valor) values (?, ?, ?, ?)";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setLong(1, produto.getFornecedor().getId());
      stmt.setString(2, produto.getDescricao());
      stmt.setString(3, produto.getUnidade());
      stmt.setDouble(4, produto.getValor());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void altera(Produto produto) {
    String sql = "update produtos set fornecedor_id = ?, descricao = ?, unidade = ?, valor = ? where id = ?";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setLong(1, produto.getFornecedor().getId());
      stmt.setString(2, produto.getDescricao());
      stmt.setString(3, produto.getUnidade());
      stmt.setDouble(4, produto.getValor());
      stmt.setInt(5, produto.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void remove(Produto produto) {
    try {
      PreparedStatement stmt = connection.prepareStatement("delete from produtos where id = ?");
      stmt.setInt(1, produto.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Produto> getProdutos() {
    try {
      List<Produto> produtos = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from produtos");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Produto produto = new Produto();
        produto.setId(rs.getInt("id"));
        produto.setFornecedor(new FornecedorDao().getFornecedor(rs.getInt("fornecedor_id")));
        produto.setDescricao(rs.getString("descricao"));
        produto.setUnidade(rs.getString("unidade"));
        produto.setValor(rs.getDouble("valor"));
        produtos.add(produto);
      }
      rs.close();
      stmt.close();
      return produtos;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Produto getProduto(int id) {
    Produto produto = new Produto();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from produtos where id = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        produto.setId(rs.getInt("id"));
        produto.setFornecedor(new FornecedorDao().getFornecedor(rs.getInt("fornecedor_id")));
        produto.setDescricao(rs.getString("descricao"));
        produto.setUnidade(rs.getString("unidade"));
        produto.setValor(rs.getDouble("valor"));
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      Logger.getLogger(ex.getLocalizedMessage());
    }
    return produto;
  }
}
