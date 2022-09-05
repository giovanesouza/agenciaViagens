-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.

CREATE DATABASE gotoviagens;

use gotoviagens;


CREATE TABLE Empresa (
    Cnpj VARCHAR(14),
    Razao_Social VARCHAR(20),
    Nome_Fantasia VARCHAR(20),
    Cod_Unid INTEGER PRIMARY KEY auto_increment,
    Unidade VARCHAR(20),
    Telefone VARCHAR(15),
    Email VARCHAR(50),
    Endereco VARCHAR(50)
);


CREATE TABLE Departamento (
    Cod_Departamento INTEGER PRIMARY KEY auto_increment,
    Nome_Departamento VARCHAR(15),
    Cod_Unid INTEGER
);


CREATE TABLE Funcionario (
    Mat_Func INTEGER PRIMARY KEY auto_increment,
    Nome_Func VARCHAR(50),
    Cargo_Func VARCHAR(20),
    Salario_Func DECIMAL(10),
    Cod_Departamento INTEGER,
    FOREIGN KEY (Cod_Departamento) REFERENCES Departamento (Cod_Departamento)
);



CREATE TABLE Destino (
    Id_Destino INTEGER auto_increment,
    Categoria_Destino VARCHAR(20),
    Qtd_Disponivel INTEGER,
    Condicao VARCHAR(20),
    Preco_Destino DECIMAL(10),
    Nome_Destino VARCHAR(20),
    PRIMARY KEY (Id_Destino , Nome_Destino)
);


CREATE TABLE Passagem (
    Id_Passagem INTEGER PRIMARY KEY auto_increment,
    Quantidade INTEGER,
    Num_Pedido INTEGER,
    Id_Destino INTEGER,
    Nome_Destino VARCHAR(20)
);


CREATE TABLE Pedido (
    Num_Pedido INTEGER PRIMARY KEY auto_increment,
    PrecoTotal DECIMAL(10),
    Forma_Pag VARCHAR(10),
    Mat_Func INTEGER,
    Cpf_Cli VARCHAR(11),
    Nome_Cli VARCHAR(50),
	Data_Pedido DATETIME,
    FOREIGN KEY (Mat_Func)  REFERENCES Funcionario (Mat_Func),
    FOREIGN KEY (Nome_Cli) REFERENCES Cliente (Cpf_Cli , Nome_Cli)
);


ALTER TABLE PEDIDO ADD FOREIGN KEY (Mat_Func) REFERENCES Funcionario (Mat_Func);
ALTER TABLE PEDIDO ADD FOREIGN KEY (Nome_Cli) REFERENCES Cliente (Cpf_Cli, Nome_Cli);


CREATE TABLE Cliente (
    Cpf_Cli VARCHAR(11),
    Nome_Cli VARCHAR(50),
    Email_Cli VARCHAR(50),
    Telefone_Cli VARCHAR(11),
    PRIMARY KEY (Cpf_Cli, Nome_Cli)
);


CREATE TABLE Usuario (
    id_Usuario INTEGER PRIMARY KEY auto_increment,
    Email_Usuario VARCHAR(10),
    Senha_Usuario VARCHAR(12),
    dataCadastro DATETIME,
    Cpf_Cli VARCHAR(11),
    Nome_Cli VARCHAR(50)
);



ALTER TABLE Usuario ADD FOREIGN KEY (Cpf_Cli) REFERENCES Cliente (Cpf_Cli);
ALTER TABLE Passagem ADD FOREIGN KEY(Num_Pedido) REFERENCES Pedido (Num_Pedido);
ALTER TABLE Passagem ADD FOREIGN KEY(Id_Destino) REFERENCES Destino (Id_Destino);
ALTER TABLE Departamento ADD FOREIGN KEY(Cod_Unid) REFERENCES Empresa (Cod_Unid);
