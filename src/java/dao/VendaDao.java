package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Item;
import model.Venda;

public class VendaDao {

  private final Connection connection;

  public VendaDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void adiciona(Venda venda) {
    String sql = "insert into vendas (cliente_id, data, quantidade, valor) values (?, ?, ?, ?)";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setLong(1, venda.getCliente().getId());
      stmt.setDate(2, new Date(venda.getData().getTimeInMillis()));
      stmt.setInt(3, venda.getQuantidade());
      stmt.setDouble(4, venda.getValor());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void altera(Venda venda) {
    String sql = "update vendas set cliente_id = ?, data = ?, quantidade = ?, valor = ? where id = ?";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setLong(1, venda.getCliente().getId());
      stmt.setDate(2, new Date(venda.getData().getTimeInMillis()));
      stmt.setInt(3, venda.getQuantidade());
      stmt.setDouble(4, venda.getValor());
      stmt.setInt(5, venda.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void remove(Venda venda) {
    try {
      PreparedStatement stmt = connection.prepareStatement("delete from vendas where id = ?");
      stmt.setInt(1, venda.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Venda> getVendas() {
    try {
      List<Venda> vendas = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from vendas");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Venda venda = new Venda();
        venda.setId(rs.getInt("id"));
        venda.setCliente(new ClienteDao().getCliente(rs.getInt("cliente_id")));
        Calendar data = Calendar.getInstance();
        data.setTime(rs.getDate("data"));
        venda.setData(data);
        venda.setQuantidade(rs.getInt("quantidade"));
        venda.setValor(rs.getDouble("valor"));
        vendas.add(venda);
      }
      rs.close();
      stmt.close();
      return vendas;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public List<Item> listItens(Venda venda){
    try {
      List<Item> itens = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from itens where venda_id = ?");
      stmt.setInt(1, venda.getId());
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setVenda(venda);
        item.setProduto(new ProdutoDao().getProduto(rs.getInt("produto_id")));
        item.setQuantidade(rs.getInt("quantidade"));
        item.setValor(rs.getDouble("valor"));
        item.setTotal(rs.getDouble("total"));
        itens.add(item);
      }
      rs.close();
      stmt.close();
      return itens;
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }

  public Venda getVenda(int id) {
    Venda venda = new Venda();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from vendas where id = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        venda.setId(rs.getInt("id"));
        venda.setCliente(new ClienteDao().getCliente(rs.getInt("cliente_id")));
        Calendar data = Calendar.getInstance();
        data.setTime(rs.getDate("data"));
        venda.setData(data);
        venda.setQuantidade(rs.getInt("quantidade"));
        venda.setValor(rs.getDouble("valor"));
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      Logger.getLogger(ex.getLocalizedMessage());
    }
    return venda;
  }
}
