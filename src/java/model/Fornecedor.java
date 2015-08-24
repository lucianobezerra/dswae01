package model;

import java.util.List;

/**
 *
 * @author Luciano
 */
public class Fornecedor {
  private long id;
  private String razao;
  private String cnpj;
  private String uf;
  private String cidade;
  private List produtos;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRazao() {
    return razao;
  }

  public void setRazao(String razao) {
    this.razao = razao;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public List getProdutos() {
    return produtos;
  }

  public void setProdutos(List produtos) {
    this.produtos = produtos;
  }
}
