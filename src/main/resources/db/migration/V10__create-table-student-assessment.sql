CREATE TABLE student_assessment (
    id VARCHAR(100) PRIMARY KEY NOT NULL,
    fk_classroom VARCHAR(100) NOT NULL,
    fk_student VARCHAR(100) NOT NULL,
    fk_matter VARCHAR(100) NOT NULL,
    grade_first DOUBLE,
    grade_second DOUBLE,
    grade_third DOUBLE,
    absences INT,
    academic_year INT
);
