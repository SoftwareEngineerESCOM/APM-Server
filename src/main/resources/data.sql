-- add titles
insert into title values(1,'Lic.','Persona con licenciatura','Licenciado');insert into title values(2,'Ing.','Persona con ingenieria','Ingeniero');insert into title values(3,'M.C.','Persona con maestria','Maestro en Ciencias');insert into title values(4,'Dr.','Persona con doctorado','Doctor');
-- add positions
insert into position values(1,'Dir.','Es el director académico','Director');insert into position values(2,'Sub.Ac.','Es el subdirector académico','Subdirector Académico');insert into position values(3,'Docente','Es un docente','Docente');
-- add roles
insert into role values(1,'Revisa tareas','Analista U.A.');insert into role values(2,'Revisa tareas','Analista DES');insert into role values(3,'Jefes de la DES','Jefe de división de innovación academica');insert into role values(4,'Jefes de la DES','Jefe de departamento de desarrollo e innovación');insert into role values(5,'Jefe de innovación educativa','Registra programas académicos y registra solo recursos humanos');insert into role values(6,'Docente','Registra: plan de estudios,unidades de aprendizaje y programa sintético');
-- add workplace type
insert into workplace_type values(1,'U.AD','Administración','Unidad Administrativa');insert into workplace_type values(2,'U.A','Centro de estudios','Unidad Académica');
-- add workplace
insert into workplace values(1,'ESCOM','Escuela Superior de Cómputo',1);insert into workplace values(2,'DES','Dirección de Estudios Superiores',2);
-- add academic_program
insert into academic_program values(1,'Ingenieria en Sistemas Computacionales',2,1);
-- add study_plan
insert into study_plan values(1,'Escolarizado',250.0,32.0,31.0,137.0,4,1);
-- add semester
insert into semester values(1,1,1);
insert into semester values(2,2,1);
insert into semester values(3,3,1);
insert into semester values(4,4,1);
-- add learning_unit
insert into learning_unit values(1,4.39,7.5,'Profesional','Ingenieria de software',1.5,54,3);
-- add human resource
insert into human_resource values(1,'Chavez','Oscar','Barrera',1,2,2);
-- add user
insert into user_apms values(1,true,'dmin1234','1',1);
