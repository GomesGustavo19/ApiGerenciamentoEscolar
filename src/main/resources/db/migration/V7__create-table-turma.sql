CREATE TABLE turma(
    fk_professor VARCHAR(100) NOT NULL PRIMARY KEY,
    fk_aluno varchar(2),
    fk_materia varchar(2),
    descricaoDaAula varchar(255)
);