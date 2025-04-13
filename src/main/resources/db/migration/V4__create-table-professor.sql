CREATE TABLE professor(
    id_professor VARCHAR(100) PRIMARY KEY NOT NULL,
    nome VARCHAR(70),
    dataNascimento DATE,
    cpf VARCHAR(11),
    registroProfessor varchar(5),
    materiaLecionada varchar(30),
    nivelEscolar varchar(2)
);