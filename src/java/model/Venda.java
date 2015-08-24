package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class Venda {

  private int id;
  private Cliente cliente;
  private Calendar data;
  private int quantidade;
  private double valor;
  private ArrayList<Item> itens;

  public Venda() {
    this.itens = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Calendar getData() {
    return data;
  }

  public void setData(Calendar data) {
    this.data = data;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public void addItem(Item item) {
    this.itens.add(item);
  }
  
  public List<Item> getItens(){
    return this.itens;
  }

}
