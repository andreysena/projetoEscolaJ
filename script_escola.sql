drop database escola;
create database escola;
use escola;

create table funcionario(
	ID_Funcionario int primary key auto_increment, 
    nome_funcionario varchar(45) not null,
    dt_nasc date not null,
    cpf varchar(45) not null,
    rg varchar(45) not null,
    telefone varchar(45) not null,
    salario decimal(6,2) not null,
    status char(1) not null default "D"
);


create table professor(
	ID_Professor int primary key auto_increment,
    numero_aulas varchar(45) not null,
    FK_Func_Prof int not null,
    constraint FK_Func_Prof foreign key(FK_Func_Prof) references funcionario(ID_Funcionario),
    status char(1) not null default "D"
);

create table coordenador(
	ID_Coordenador int primary key auto_increment,
    FK_Func_Coord int not null,
    constraint FK_Func_Coord foreign key(FK_Func_Coord) references funcionario(ID_Funcionario),
    status char(1) not null default "D"
);

create table materia(
	ID_Materia int primary key auto_increment,
	nome_materia varchar(45) not null,
    status char(1) not null default "D"
);


create table professor_materia(
	ID_ProfMat int not null auto_increment,
	FK_Prof_Mat int not null,
    FK_Materia int not null,
    primary key(ID_ProfMat, FK_Prof_Mat, FK_Materia),
    constraint FK_Prof_Mat foreign key(FK_Prof_Mat) references professor(ID_Professor),
    constraint FK_Materia foreign key(FK_Materia) references materia(ID_Materia),
    status char(1) not null default "D"
);


create table turma(
	ID_Turma int primary key auto_increment,
    letra_turma varchar(45) not null,
    FK_Coordenador int not null,
    constraint FK_Coordenador foreign key(FK_Coordenador) references coordenador(ID_Coordenador),
    status char(1) not null default "D"
);
s
create table turma_professor(
	ID_TurmaProf int not null auto_increment,
	FK_Turma_Prof int not null,
    FK_Prof_Turma int not null,
    primary key(ID_TurmaProf, FK_Turma_Prof, FK_Prof_Turma),
    constraint FK_Turma_Prof foreign key(FK_Turma_Prof) references turma(ID_Turma),
    constraint FK_Prof_Turma foreign key(FK_Prof_Turma) references professor(ID_Professor),
    status char(1) not null default "D"
);

create table aluno(
	ID_Aluno int primary key auto_increment,
    nome_aluno varchar(45) not null,
    matricula varchar(45) not null,
    dt_nasc date not null,
    cpf varchar(45) not null,
    rg varchar(45) not null,
    telefone varchar(45) not null,
    FK_Turma int not null,
    constraint FK_Turma foreign key(FK_Turma) references turma(ID_Turma),
    status char(1) not null default "D"
);
