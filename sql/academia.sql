-- =========================================
-- BANCO DE DADOS - SOFTWARE DE GERENCIAMENTO DE ACADEMIA
-- =========================================

-- CREATE DATABASE IF NOT EXISTS academia;
USE academia;

-- =========================================
-- TABELA PESSOA (ABSTRACT)
-- =========================================
CREATE TABLE IF NOT EXISTS pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    idade INT NOT NULL
);

-- =========================================
-- TABELA FUNCIONARIO
-- =========================================
CREATE TABLE IF NOT EXISTS funcionario (
    id INT PRIMARY KEY,
    salario DECIMAL(10,2) NOT NULL,			-- maxímo 10 caracteres com 2 após o ponto/vírgula
    
    CONSTRAINT fk_funcionario_pessoa		-- restrição
        FOREIGN KEY (id) REFERENCES pessoa(id)
        ON DELETE CASCADE					-- apaga todas instâncias
);

-- =========================================
-- TABELA PERSONAL TRAINER
-- =========================================
CREATE TABLE IF NOT EXISTS personal_trainer (
    id INT PRIMARY KEY,
    cref VARCHAR(20) UNIQUE NOT NULL,
    
    CONSTRAINT fk_pt_funcionario
        FOREIGN KEY (id) REFERENCES funcionario(id)
        ON DELETE CASCADE
);

-- =========================================
-- TABELA PLANO (ABSTRACT)
-- =========================================
CREATE TABLE IF NOT EXISTS plano (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('Mensal', 'Anual') NOT NULL,		-- limitado aos 2 valores do enum
    valor DECIMAL(10,2) NOT NULL
);

-- =========================================
-- TABELA PAGAMENTO
-- =========================================
CREATE TABLE IF NOT EXISTS pagamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('Pix', 'Cartao', 'Dinheiro') NOT NULL
);

-- =========================================
-- TABELA TREINO
-- =========================================
CREATE TABLE IF NOT EXISTS treino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) NOT NULL 
);

-- =========================================
-- TABELA ALUNO
-- =========================================
CREATE TABLE IF NOT EXISTS aluno (
    id INT PRIMARY KEY,
    matricula INT UNIQUE NOT NULL,
    peso DOUBLE,
    altura DOUBLE,
    tipo_plano ENUM('Mensal','Anual'),
    tipo_pagamento ENUM('Pix','Cartão','Dinheiro'),
    nome_treino VARCHAR(20),
    FOREIGN KEY (id) REFERENCES pessoa(id)
    ON DELETE CASCADE
);

-- =========================================
-- TABELA EXERCICIO
-- =========================================
CREATE TABLE IF NOT EXISTS exercicio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    series INT NOT NULL,
    repeticoes INT NOT NULL,
    treino_id INT,
    
    CONSTRAINT fk_exercicio_treino
        FOREIGN KEY (treino_id) REFERENCES treino(id)
        ON DELETE CASCADE
);

-- =========================================
-- TABELA EQUIPAMENTO
-- =========================================
CREATE TABLE IF NOT EXISTS equipamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    status VARCHAR(20)
);

-- =========================================
-- TABELA ACADEMIA
-- =========================================
CREATE TABLE IF NOT EXISTS academia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

DROP TABLE equipamento;

CREATE TABLE IF NOT EXISTS equipamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL UNIQUE,
    status VARCHAR(20)
);

ALTER TABLE treino ADD UNIQUE (nome);

-- reset no BD
-- SET SQL_SAFE_UPDATES = 0;
-- DELETE FROM equipamento;
-- DELETE FROM treino;
-- DELETE FROM aluno;
-- DELETE FROM pessoa;
-- DESCRIBE aluno;
-- DROP TABLE aluno;