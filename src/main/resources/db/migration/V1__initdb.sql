CREATE TABLE PACIENTE (
    id int GENERATED BY DEFAULT AS IDENTITY,
    nome varchar(50),
    sobrenome varchar(100),
    email  varchar(100),
    data_de_nascimento  timestamp,
    data_da_ultima_consulta timestamp,
    telefone varchar(9),
    celular varchar(9),
    endereco varchar(100),
    cep varchar(10),
    forma_de_pagamento varchar(20),
    cpf varchar(14)
);

CREATE TABLE MEDICO (
	id int GENERATED BY DEFAULT AS IDENTITY,
	nome varchar(255)
);

CREATE TABLE CONSULTA(
	id int GENERATED BY DEFAULT AS IDENTITY,
	id_medico int,
	id_paciente int,
	valor double,
	data_consulta date
);

ALTER TABLE CONSULTA ADD FOREIGN KEY (id_medico) REFERENCES MEDICO(id);
ALTER TABLE CONSULTA ADD FOREIGN KEY (id_paciente) REFERENCES PACIENTE(id);

CREATE TABLE USERS (
 id BIGINT GENERATED BY DEFAULT AS IDENTITY,
 username varchar(256),
 password varchar(256),
 enabled boolean
);

CREATE TABLE AUTHORITIES (
 id BIGINT GENERATED BY DEFAULT AS IDENTITY,
 username varchar(256),
 authority varchar(256)
);

CREATE TABLE PRECOS(
	id BIGINT GENERATED BY DEFAULT AS IDENTITY,
	valor BIGINT,
	nome varchar(255),
	descricao varchar(255)
);

CREATE TABLE PRONTUARIO(
	id BIGINT GENERATED BY DEFAULT AS IDENTITY,
	id_medico BIGINT,
	id_paciente BIGINT,
	descricao varchar(1000)
);

--ALTER TABLE CONSULTA ADD FOREIGN KEY (id_preco) REFERENCES PRECOS(id);
ALTER TABLE PRONTUARIO ADD FOREIGN KEY (id_medico) REFERENCES MEDICO(id);
ALTER TABLE PRONTUARIO ADD FOREIGN KEY (id_paciente) REFERENCES PACIENTE(id);

INSERT INTO USERS (username, password, enabled) values ('admin', 'admin', true);
INSERT INTO AUTHORITIES (username, authority) values ('admin', 'ROLE_ADMIN');

INSERT INTO USERS (username, password, enabled) values ('user', 'user', true);
INSERT INTO AUTHORITIES (username, authority) values ('user', 'ROLE_USER');

