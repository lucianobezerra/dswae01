package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;
import model.Usuario;

public class UsuarioDao {

  private final Connection connection;

  public UsuarioDao() {
    this.connection = new ConnectionFactory().getConnection();
  }

  public void adiciona(Usuario usuario) {
    String sql = "insert into usuarios (usuario, senha) values (?, ?)";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, usuario.getUsuario());
      stmt.setString(2, usuario.getSenha());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void altera(Usuario usuario) {
    String sql = "update usuarios set usuario = ?, senha = ? where id = ?";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, usuario.getUsuario());
      stmt.setString(2, usuario.getSenha());
      stmt.setLong(5, usuario.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void remove(Usuario usuario) {
    try {
      PreparedStatement stmt = connection.prepareStatement("delete from usuarios where id = ?");
      stmt.setLong(1, usuario.getId());
      stmt.execute();
      stmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Usuario> getUsuarios() {
    try {
      List<Usuario> usuarios = new ArrayList<>();
      PreparedStatement stmt = connection.prepareStatement("select * from usuarios");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setSenha(rs.getString("senha"));
        usuarios.add(usuario);
      }
      rs.close();
      stmt.close();
      return usuarios;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Usuario getUsuario(int id) {
    Usuario usuario = new Usuario();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from usuarios where id = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        usuario.setId(rs.getInt("id"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setSenha(rs.getString("senha"));
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    return usuario;
  }
  
  public Usuario getUsuario(String user, String pass) {
    Usuario usuario = new Usuario();
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from usuarios where usuario = ? and senha = ?");
      stmt.setString(1, user);
      stmt.setString(2, pass);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        usuario.setId(rs.getInt("id"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setSenha(rs.getString("senha"));
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    return usuario;
  }
}
