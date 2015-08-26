drop table if exists fornecedores;
CREATE TABLE fornecedores (
  id int(11) NOT NULL AUTO_INCREMENT,
  razao varchar(200) NOT NULL,
  cnpj varchar(14) NOT NULL,
  uf varchar(2) NOT NULL,
  cidade varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table if exists clientes;
CREATE TABLE clientes (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  cpf varchar(11) NOT NULL,
  uf varchar(2) NOT NULL,
  cidade varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table if exists produtos;
CREATE TABLE produtos (
  id int(11) NOT NULL AUTO_INCREMENT,
  fornecedor_id int(11) NOT NULL,
  descricao varchar(200) NOT NULL,
  unidade varchar(14) NOT NULL,
  valor decimal(12,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table if exists vendas;
CREATE TABLE vendas (
  id int(11) NOT NULL AUTO_INCREMENT,
  cliente_id int(11) NOT NULL,
  data date NOT NULL,
  quantidade int(11) NOT NULL,
  valor decimal(12,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table if exists itens;
CREATE TABLE itens (
  id int(11) NOT NULL AUTO_INCREMENT,
  venda_id int(11) NOT NULL,
  produto_id int(11) NOT NULL,
  quantidade int(11) NOT NULL,
  valor decimal(12,2) NOT NULL,
  total decimal(12,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table if exists usuarios;
CREATE TABLE usuarios (
id int(11) NOT NULL AUTO_INCREMENT,
usuario varchar(256) default NULL,
senha varchar(256) default NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into usuarios (usuario,senha) values ('admin', 'admin');