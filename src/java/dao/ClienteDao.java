package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Cliente;

public class ClienteDao {

  private final Connection connection;

  public ClienteDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void adiciona(Cliente cliente) {
    String sql = "insert into clientes (nome, cpf, uf, cidade) values (?, ?, ?, ?)";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, cliente.getNome());
      stmt.setString(2, cliente.getCpf());
      stmt.setString(3, cliente.getUf());
      stmt.setString(4, cliente.getCidade());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void altera(Cliente cliente) {
    String sql = "update clientes set nome = ?, cpf = ?, uf = ?, cidade = ? where id = ?";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, cliente.getNome());
      stmt.setString(2, cliente.getCpf());
      stmt.setString(3, cliente.getUf());
      stmt.setString(4, cliente.getCidade());
      stmt.setLong(5, cliente.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void remove(Cliente cliente) {
    try {
      PreparedStatement stmt = connection.prepareStatement("delete from clientes where id = ?");
      stmt.setLong(1, cliente.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Cliente> getClientes() {
    try {
      List<Cliente> clientes = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from clientes");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setUf(rs.getString("uf"));
        cliente.setCidade(rs.getString("cidade"));
        clientes.add(cliente);
      }
      rs.close();
      stmt.close();
      return clientes;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Cliente getCliente(int id) {
    Cliente cliente = new Cliente();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from clientes where id = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setUf(rs.getString("uf"));
        cliente.setCidade(rs.getString("cidade"));
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      Logger.getLogger(ex.getLocalizedMessage());
    }
    return cliente;
  }
}
