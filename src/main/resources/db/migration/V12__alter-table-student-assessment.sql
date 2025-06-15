ALTER TABLE student_assessment DROP COLUMN fk_classroom;
ALTER TABLE student_assessment DROP COLUMN fk_student;

ALTER TABLE student_assessment ADD COLUMN id_classroom varchar(100);
ALTER TABLE student_assessment ADD COLUMN id_student varchar(100);