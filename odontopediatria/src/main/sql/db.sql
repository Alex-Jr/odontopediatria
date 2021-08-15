create database if not exists odontopediatria;
use odontopediatria;

CREATE TABLE IF NOT EXISTS pacientes(
nome varchar(100),
sexo char(1),
responsavel varchar(100),
dataNasc date,
id int not null primary key auto_increment 
);

CREATE TABLE IF NOT EXISTS medicos (
id int NOT NULL PRIMARY KEY auto_increment,
nome VARCHAR(100),
crm VARCHAR(20));

CREATE TABLE IF NOT EXISTS avatares (
cor_da_pele varchar(15),
olho int,
cor_do_olho varchar(15),
sobrancelha int,
nariz int,
orelha int,
boca int,
cabelo int,
rosto int,
roupa int,
id_paciente int not null,
id_avatar int not null primary key auto_increment,
FOREIGN KEY (id_paciente) REFERENCES pacientes(id)
);

CREATE TABLE IF NOT EXISTS avaliacoes (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
PacienteID int, MedicoID int, 
expressoes VARCHAR(255), 
data DATE, 
ansiedade int, 
FOREIGN KEY (PacienteID) REFERENCES pacientes(id),
FOREIGN KEY (MedicoID) REFERENCES medicos(id)
);

CREATE TABLE usuarios (
	login VARCHAR(255) PRIMARY KEY,
	senha VARCHAR(255) NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	id_medico INT,
	FOREIGN KEY (id_medico) REFERENCES medicos(id)
)
	

