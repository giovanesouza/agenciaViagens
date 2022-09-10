-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.

CREATE DATABASE gotoviagens;

use gotoviagens;

-- TABELAS RELACIONADAS À EMPRESA/FUNCIONÁRIOS

CREATE TABLE Empresa (
    Cnpj VARCHAR(14) default '11111111111111',
    Razao_Social VARCHAR(20) default 'Go To Viagens',
    Nome_Fantasia VARCHAR(30) default 'Agência de Viagens Go To',
    Cod_Unid INTEGER PRIMARY KEY auto_increment,
    Unidade VARCHAR(20) not null,
    Telefone VARCHAR(15) not null,
    Email VARCHAR(50) not null,
    Endereco VARCHAR(50) not null
);


CREATE TABLE Departamento (
    Cod_Departamento INTEGER PRIMARY KEY auto_increment,
    Nome_Departamento VARCHAR(15) not null,
    Cod_Unid INTEGER not null,
    FOREIGN KEY (Cod_unid) REFERENCES Empresa (Cod_Unid)
);


CREATE TABLE Funcionario (
    Mat_Func INTEGER PRIMARY KEY auto_increment,
    Nome_Func VARCHAR(50) not null,
    Cargo_Func VARCHAR(20) not null,
    Salario_Func DOUBLE not null default '0',
    Cod_Departamento INTEGER not null,
    FOREIGN KEY (Cod_Departamento) REFERENCES Departamento (Cod_Departamento)
);

-- TABELAS RELACIONADAS AO CLIENTE/USUÁRIO

CREATE TABLE Cliente (
    Cpf_Cli VARCHAR(11) not null,
    Nome_Cli VARCHAR(50) not null,
    Email_Cli VARCHAR(50) not null,
    Telefone_Cli VARCHAR(11) not null,
    PRIMARY KEY (Cpf_Cli)
);


CREATE TABLE Usuario (
    id_Usuario INTEGER PRIMARY KEY auto_increment,
    Email_Usuario VARCHAR(50) not null,
    Senha_Usuario VARCHAR(12) not null,
    dataCadastro DATE not null,
    Cpf_Cli VARCHAR(11) not null,
    Nome_Cli VARCHAR(50) not null,
    FOREIGN KEY (Cpf_Cli) REFERENCES Cliente (Cpf_Cli)
);


-- TABELAS RELACIONADAS AO PEDIDO

CREATE TABLE Destino (
    Id_Destino INTEGER auto_increment,
	Nome_Destino VARCHAR(20) not null,
    Preco_Destino DOUBLE not null,
    Categoria_Destino VARCHAR(20) not null,
    Qtd_Disponivel INTEGER not null,
    Condicao VARCHAR(20) not null default 'Sem desconto',
    PRIMARY KEY (Id_Destino)
);


CREATE TABLE Passagem (
    Id_Passagem INTEGER PRIMARY KEY auto_increment,
    Quantidade INTEGER not null,
--  Num_Pedido INTEGER not null,
    Id_Destino INTEGER not null,
--    Nome_Destino VARCHAR(20) not null,
	FOREIGN KEY (Id_Destino) REFERENCES Destino (Id_Destino)
 --   FOREIGN KEY (Nome_Destino) REFERENCES Destino (Nome_Destino)
);


CREATE TABLE Pedido (
    Num_Pedido INTEGER PRIMARY KEY auto_increment,
    PrecoTotal DOUBLE not null,
    Forma_Pag VARCHAR(20) not null default 'Cartão de Crédito',
    Mat_Func INTEGER not null,
    Cpf_Cli VARCHAR(11) not null,
    Nome_Cli VARCHAR(50) not null,
	Data_Pedido DATE not null,
    FOREIGN KEY (Mat_Func) REFERENCES Funcionario (Mat_Func),
    FOREIGN KEY (Cpf_Cli) REFERENCES Cliente (Cpf_Cli)
);
