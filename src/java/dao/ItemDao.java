package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Item;
import model.Venda;

public class ItemDao {

  private final Connection connection;

  public ItemDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void adiciona(Item item) {
    String sql = "insert into itens (venda_id, produto_id, quantidade, valor, total) values (?, ?, ?, ?, ?)";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, item.getVenda().getId());
      stmt.setInt(2, item.getProduto().getId());
      stmt.setInt(3, item.getQuantidade());
      stmt.setDouble(4, item.getValor());
      stmt.setDouble(5, item.getTotal());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void altera(Item item) {
    String sql = "update itens set venda_id = ?, cliente_id = ?, quantidade = ?, valor = ?, total = ? where id = ?";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, item.getVenda().getId());
      stmt.setInt(2, item.getProduto().getId());
      stmt.setInt(3, item.getQuantidade());
      stmt.setDouble(4, item.getValor());
      stmt.setDouble(5, item.getTotal());
      stmt.setInt(5, item.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void remove(Item item) {
    try {
      PreparedStatement stmt = connection.prepareStatement("delete from itens where id = ?");
      stmt.setInt(1, item.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Item> getItens() {
    try {
      List<Item> itens = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from itens");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setVenda(new VendaDao().getVenda(rs.getInt("venda_id")));
        item.setProduto(new ProdutoDao().getProduto(rs.getInt("produto_id")));
        item.setQuantidade(rs.getInt("quantidade"));
        item.setValor(rs.getDouble("valor"));
        item.setTotal(rs.getDouble("total"));
        itens.add(item);
      }
      rs.close();
      stmt.close();
      return itens;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public List<Item> getItens(Venda venda) {
    List<Item> itens = venda.getItens();
    return itens;
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
