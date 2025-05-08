-- DROP IF EXISTS (ordem inversa por dependência)
DROP TABLE IF EXISTS registro_ponto;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS jornada_trabalho;
DROP TABLE IF EXISTS empresa;

-- EMPRESA
CREATE TABLE empresa (
    id BIGSERIAL PRIMARY KEY,
    razao_social VARCHAR(255) NOT NULL,
    cnpj VARCHAR(255) NOT NULL UNIQUE,
    data_cadastro TIMESTAMP,
    data_alteracao TIMESTAMP,
    ativo BOOLEAN
);

-- USUARIO
CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP,
    data_alteracao TIMESTAMP,
    ativo BOOLEAN,
    role VARCHAR(50),
    tentativas_login INTEGER,
    id_empresa BIGINT NOT NULL,
    id_jornada_trabalho BIGINT,

    CONSTRAINT fk_usuario_empresa FOREIGN KEY (id_empresa) REFERENCES empresa(id),
    CONSTRAINT fk_usuario_jornada FOREIGN KEY (id_jornada_trabalho) REFERENCES jornada_trabalho(id)
);

-- JORNADA TRABALHO
CREATE TABLE jornada_trabalho (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    hora_entrada TIME NOT NULL,
    hora_saida TIME NOT NULL,
    tolerancia_entrada INTEGER NOT NULL,
    tolerancia_saida INTEGER NOT NULL,
    tempo_descanso INTERVAL NOT NULL,
    data_cadastro TIMESTAMP NOT NULL,
    data_alteracao TIMESTAMP NOT NULL,
    id_empresa BIGINT,
    criado_por BIGINT,

    CONSTRAINT fk_jornada_empresa FOREIGN KEY (id_empresa) REFERENCES empresa(id),
    CONSTRAINT fk_jornada_criado_por FOREIGN KEY (criado_por) REFERENCES usuario(id)
);

-- REGISTRO PONTO
CREATE TABLE registro_ponto (
    id BIGSERIAL PRIMARY KEY,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    tipo VARCHAR(50),
    origem VARCHAR(50),
    latitude DECIMAL(10,8),
    longitude DECIMAL(11,8),
    usuario BIGINT,

    CONSTRAINT fk_registro_usuario FOREIGN KEY (usuario) REFERENCES usuario(id)
);
