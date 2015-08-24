package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Fornecedor;

public class FornecedorDao {

  private final Connection connection;

  public FornecedorDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void adiciona(Fornecedor fornecedor) {
    String sql = "insert into fornecedores (razao, cnpj, uf, cidade) values (?, ?, ?, ?)";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, fornecedor.getRazao());
      stmt.setString(2, fornecedor.getCnpj());
      stmt.setString(3, fornecedor.getUf());
      stmt.setString(4, fornecedor.getCidade());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void altera(Fornecedor fornecedor) {
    String sql = "update fornecedores set razao = ?, cnpj = ?, uf = ?, cidade = ? where id = ?";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, fornecedor.getRazao());
      stmt.setString(2, fornecedor.getCnpj());
      stmt.setString(3, fornecedor.getUf());
      stmt.setString(4, fornecedor.getCidade());
      stmt.setLong(5, fornecedor.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void remove(Fornecedor fornecedor) {
    try {
      PreparedStatement stmt = connection.prepareStatement("delete from fornecedores where id = ?");
      stmt.setLong(1, fornecedor.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Fornecedor> getFornecedores() {
    try {
      List<Fornecedor> fornecedores = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from fornecedores");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(rs.getInt("id"));
        fornecedor.setRazao(rs.getString("razao"));
        fornecedor.setCnpj(rs.getString("cnpj"));
        fornecedor.setUf(rs.getString("uf"));
        fornecedor.setCidade(rs.getString("cidade"));
        fornecedores.add(fornecedor);
      }
      rs.close();
      stmt.close();
      return fornecedores;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Fornecedor getFornecedor(int id) {
    Fornecedor fornecedor = new Fornecedor();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from fornecedores where id = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        fornecedor.setId(rs.getInt("id"));
        fornecedor.setRazao(rs.getString("razao"));
        fornecedor.setCnpj(rs.getString("cnpj"));
        fornecedor.setUf(rs.getString("uf"));
        fornecedor.setCidade(rs.getString("cidade"));
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      Logger.getLogger(ex.getLocalizedMessage());
    }
    return fornecedor;
  }
}
