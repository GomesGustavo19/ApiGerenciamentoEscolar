CREATE TABLE classroom(
    id_classroom VARCHAR(100) NOT NULL PRIMARY KEY,
    fk_teacher varchar(2),
    fk_student varchar(2),
    fk_matter varchar(2),
    classDescription varchar(255)
);