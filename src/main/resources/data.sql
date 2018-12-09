-- add academy
insert into academy values (DEFAULT, 'Ciencias Sociales', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Ciencias Básicas', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Algoritmia y Programación', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Sistemas Digitales', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Ingeniería de Software', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Sistemas Analógicos', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Redes y Sistemas Operativos', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Proyectos Estratégicos y Toma de Decisiones', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Ciencias de la Computación', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Fundamentos de Sistemas Electrónicos', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Sistemas Distribuidos', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));
insert into academy values (DEFAULT, 'Trabajo Terminal', (SELECT id FROM workplace WHERE abbreviation = 'ESCOM'));

-- add academic_program
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería en Sistemas Computacionales', 'Ingeniero', (select id from workplace where abbreviation like 'ESCOM'));
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería en Control y Automatización', 'Ingeniero', (select id from workplace where abbreviation like 'ESIME Zacatenco'));
insert into academic_program (name, title_name, workplace_id) values ('Licenciatura en Comercio Internacional', 'Licenciado', (select id from workplace where abbreviation like 'ESCA ST'));
insert into academic_program (name, title_name, workplace_id) values ('Licenciatura en Física y Matemáticas', 'Licenciado', (select id from workplace where abbreviation like 'ESFM'));
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería Mecatrónica', 'Ingeniero', (select id from workplace where abbreviation like 'UPIITA'));
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería Textil', 'Ingeniero', (select id from workplace where abbreviation like 'ESIT'));
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería Biotecnológica', 'Ingeniero', (select id from workplace where abbreviation like 'UPIBI'));
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería Química Petrolera', 'Ingeniero', (select id from workplace where abbreviation like 'ESIQIE'));
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería Civil', 'Ingeniero', (select id from workplace where abbreviation like 'ESIA Zacatenco'));
insert into academic_program (name, title_name, workplace_id) values ('Ingeniería en Sistemas Ambientales', 'Ingeniero', (select id from workplace where abbreviation like 'ENCB'));
insert into academic_program (name, title_name, workplace_id) values ('Médico Cirujano y Homeópata', 'Licenciado', (select id from workplace where abbreviation like 'ENMH'));
insert into academic_program (name, title_name, workplace_id) values ('Médico Cirujano y Partero', 'Licenciado', (select id from workplace where abbreviation like 'ENMH'));

-- add study_plan
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 250.0, 30.0, 35.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%'), (select id from status_study_plan where name like '%Vigente%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 234.0, 33.0, 31.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería en Control y Automatización%'), (select id from status_study_plan where name like '%Aprobado%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%A distancia%'), 240.0, 34.0, 31.0, 133.0, 2018, (select id from academic_program where name like '%Licenciatura en Comercio Internacional%'), (select id from status_study_plan where name like '%En liquidación%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%A distancia%'), 260.0, 32.0, 31.0, 135.0, 2018, (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%'), (select id from status_study_plan where name like '%Rediseño%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 225.0, 32.0, 31.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería Mecatrónica%'), (select id from status_study_plan where name like '%Vigente%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 250.0, 31.0, 32.0, 132.0, 2018, (select id from academic_program where name like '%Ingeniería Textil%'), (select id from status_study_plan where name like '%En liquidación%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%A distancia%'), 250.0, 30.0, 31.0, 140.0, 2018, (select id from academic_program where name like '%Ingeniería Biotecnológica%'), (select id from status_study_plan where name like '%Rediseño%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 235.0, 30.0, 33.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería Química Petrolera%'), (select id from status_study_plan where name like '%Vigente%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%A distancia%'), 245.0, 31.0, 31.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería Civil%'), (select id from status_study_plan where name like '%Vigente%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 255.0, 31.0, 30.0, 138.0, 2018, (select id from academic_program where name like '%Ingeniería en Sistemas Ambientales%'), (select id from status_study_plan where name like '%Creación%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 255.0, 31.0, 30.0, 138.0, 2018, (select id from academic_program where name like '%Médico Cirujano y Homeópata%'), (select id from status_study_plan where name like '%Vigente%'));
insert into study_plan (modality_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id, status_study_plan_id) values ((select id from modality where name like '%Escolarizado%'), 255.0, 31.0, 30.0, 138.0, 2018, (select id from academic_program where name like '%Médico Cirujano y Partero%'), (select id from status_study_plan where name like '%Liquidado%'));

-- add semester 
insert into semester (semester_number, study_plan_id) (select 1, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 2, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 3, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 4, id from study_plan);
-- insert into semester (semester_number, study_plan_id) (select 5, id from study_plan);
-- insert into semester (semester_number, study_plan_id) (select 6, id from study_plan);
-- insert into semester (semester_number, study_plan_id) (select 7, id from study_plan);
-- insert into semester (semester_number, study_plan_id) (select 8, id from study_plan);

-----------------------
-- add learning_unit --
-----------------------
-- Escuela Num 1
insert into learning_unit values (DEFAULT, 4.39, 7.5, 'Ingenieria de software', 1.5, 3.0, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 4 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));
insert into learning_unit values (DEFAULT, 4.28, 7.5, 'Estructura de Datos', 1.5, 3.0, (select id from academy where name = 'Algoritmia y Programación'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Finalizada'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));
insert into learning_unit values (DEFAULT, 4.4, 7.5, 'Base de Datos', 1.5, 3.0, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));

-- Escuela Num 2
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Fisica Clasica', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Terminal y de Integración%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Ecuaciones Diferenciales', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Ondas Mecanicas', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Institucional%'), (select id from learning_unit_status where name = 'Finalizada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));

-- Escuela Num 3
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Comunicacion Oral y Escrita', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Institucional%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Calidad', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Administracion Estrategica', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Científica Básica%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));

-- Escuela Num 4
insert into learning_unit values (DEFAULT, 0, 9, 'Geometria Analitica', 0, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));
insert into learning_unit values (DEFAULT, 0, 9, 'Analisis Vectorial', 0, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Institucional%'), (select id from learning_unit_status where name = 'Finalizada'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));
insert into learning_unit values (DEFAULT, 0, 9, 'Fisica 3', 3.0, 6.0, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Institucional%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));

-- Escuela Num 5
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Mecanica de la particula', 0, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Finalizada'), (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Circuitos Electricos', 1.5, 1.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Científica Básica%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Electricidad y Magnetismo', 0, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Terminal y de Integración%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));

-- Escuela Num 6
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Metodos Hilados', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Quimica Textil', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Científica Básica%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Higiene y seguridad industrial', 1.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Científica Básica%'), (select id from learning_unit_status where name = 'Finalizada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));

-- Escuela Num 7
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Quimica General', 2, 5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Terminal y de Integración%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Quimica de Soluciones', 2, 4, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Científica Básica%'), (select id from learning_unit_status where name = 'En proceso'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));
insert into learning_unit values (DEFAULT, 3.0, 7.5, 'Quimica Organica 1', 3, 3, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Institucional%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));

-- Escuela Num 8
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Geologia', 1.5, 3.0, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Científica Básica%'), (select id from learning_unit_status where name = 'Finalizada'), (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Dinamica de la Particula', 0, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Profesional%'), (select id from learning_unit_status where name = 'Creada'), (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));
insert into learning_unit values (DEFAULT, 3.5, 7.0, 'Topografia', 4.5, 4.5, (select id from academy where name = 'Ingeniería de Software'), (select id from formation_area where name like '%Terminal y de Integración%'), (select id from learning_unit_status where name = 'Asignada'), (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));

--registros nuevos


-- add synthetic_program

-- add human resource
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Chávez', 'Oscar', 'Barrera', (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'ESCOM'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('González', 'Emiliano', 'Hinojosa', (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'UPIITA'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Frías', 'Erika', 'Covarrubias', (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'ESCOM'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Jiménez', 'Eduardo', 'Hernádez', (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'UPIITA'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Rojas', 'Arturo', 'Rivas', (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'UPIBI'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('González', 'Daniela', 'Hernández', (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'ESCOM'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Figueroa', 'Hugo', 'Bernal', (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'ESIME Zacatenco'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Castrejón', 'Miguel', 'Sánchez', (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'DES'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Castillo', 'Alejandra', 'Jiménez', (select id from title where abbreviation like '%Lic.%'), (select id from workplace where abbreviation like 'DES'));
insert into human_resource (second_surname, name, first_surname, title_id, workplace_id) values ('Guerra', 'David', 'Vargas', (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'DES'));

insert into human_resource_positions values ((select id from human_resource where name like '%Oscar%'), (select id from position where abbreviation like '%Dir.'));
insert into human_resource_positions values ((select id from human_resource where name like '%Emiliano%'), (select id from position where abbreviation like '%Dir.'));
insert into human_resource_positions values ((select id from human_resource where name like '%Erika%'), (select id from position where abbreviation like '%Sub. Ac.%'));
insert into human_resource_positions values ((select id from human_resource where name like '%Eduardo%'), (select id from position where abbreviation like '%Sub. Ac.%'));
insert into human_resource_positions values ((select id from human_resource where name like '%Arturo%'), (select id from position where abbreviation like '%Sub. Ac.%'));
insert into human_resource_positions values ((select id from human_resource where name like '%Daniela%'), (select id from position where abbreviation like '%Doc.%'));
insert into human_resource_positions values ((select id from human_resource where name like '%Hugo%'), (select id from position where abbreviation like '%Doc.%'));
insert into human_resource_positions values ((select id from human_resource where name like '%Miguel%'), (select id from position where abbreviation like '%Doc.%'));
insert into human_resource_positions values ((select id from human_resource where name like '%Alejandra%'), (select id from position where abbreviation like '%Doc.%'));
insert into human_resource_positions values ((select id from human_resource where name like '%David%'), (select id from position where abbreviation like '%Dir.'));

-- add user_apms
insert into user_apms (is_account_blocked, password, token, human_resource_id, email) values (false, 'admin1', '1', (select id from human_resource where name like '%Oscar%'), 'admin1@test.com');
insert into user_apms (is_account_blocked, password, token, human_resource_id, email) values (false, 'test1', '2', (select id from human_resource where name like '%Emiliano%'), 'test1@test.com');
insert into user_apms (is_account_blocked, password, token, human_resource_id, email) values (false, 'test2', '3', (select id from human_resource where name like '%Erika%'), 'test2@test.com');
insert into user_apms (is_account_blocked, password, token, human_resource_id, email) values (false, 'test3', '4', (select id from human_resource where name like '%Miguel%'), 'test3@test.com');
insert into user_apms (is_account_blocked, password, token, human_resource_id, email) values (false, 'test4', '5', (select id from human_resource where name like '%Alejandra%'), 'test4@test.com');
insert into user_apms (is_account_blocked, password, token, human_resource_id, email) values (false, 'test5', '6', (select id from human_resource where name like '%David%'), 'test5@test.com');

-- add user_apms_roles
insert into user_apms_roles values ((select id from user_apms where email like '%admin1@test.com%'), (select id from role where name like '%Jefe de Innovación Educativa%'));
insert into user_apms_roles values ((select id from user_apms where email like '%admin1@test.com%'), (select id from role where name like '%Jefe de la División de Innovacion Académica%'));
insert into user_apms_roles values ((select id from user_apms where email like '%test1@test.com%'), (select id from role where name like '%Docente%'));
insert into user_apms_roles values ((select id from user_apms where email like '%test2@test.com%'), (select id from role where name like '%Analista%'));
insert into user_apms_roles values ((select id from user_apms where email like '%test3@test.com%'), (select id from role where name like '%Analista%'));
insert into user_apms_roles values ((select id from user_apms where email like '%test4@test.com%'), (select id from role where name like '%Jefe de Departamento de Desarrollo e Innovación Curricular%'));
insert into user_apms_roles values ((select id from user_apms where email like '%test5@test.com%'), (select id from role where name like '%Jefe de la División de Innovacion Académica%'));

insert into evaluation_accreditationua values (DEFAULT);


--									--
--		Synthetic Program 			--
--									--

insert into synthetic_program (didactic_orientation, regard, evaluation_accreditationua_id, learning_unit_id) values ('La presente unidad se abordará a partir de la estrategia aprendizaje orientada a proyectos, el docente conducirá el curso con el método heurístico, se realizarán actividades de indagación, análisis y diseño para seleccionar la metodología adecuada al sistema de información que se quiera implementar, aplicando un enfoque de calidad; utilizando herramientas CASE para facilitar el diseño de los diagramas UML, exposiciones, prácticas y la realización de un proyecto en equipo que integre los conceptos generales así como las competencias referentes al uso de patrones de diseño y el manejo las normas calidad del software.
Las actividades que se realizarán en clase fomentarán en los estudiantes algunas técnicas, tales como: trabajo colaborativo y participativo, lluvia de ideas, organizadores gráficos, indagación documental, fichas de trabajo, exposición de temas complementarios, discusión dirigida así como la realización de un proyecto.
Para ello el docente dentro de la planeación establecerá las actividades de aprendizaje a desarrollar y los tiempos para entrega por parte del alumno; así mismo marcara los tiempos de revisión para hacer las observaciones y anotaciones para que el alumno pueda mejorar su aprendizaje, además de establecer las características del proyecto realizado.', 'Elabora un sistema computacional de propósito específico con base en metodologías de Ingeniería de Software.', (SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM learning_unit WHERE name like 'Ingenieria de software'));

insert into content (name, number, content_id) VALUES ('Ingeniería de Software', 1, (SELECT id FROM synthetic_program WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name like 'Ingenieria de software')));
insert into content (name, number, content_id) VALUES ('Proceso de gestión de proyecto', 2, (SELECT id FROM synthetic_program WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name like 'Ingenieria de software')));
insert into content (name, number, content_id) VALUES ('Metodologías', 3, (SELECT id FROM synthetic_program WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name like 'Ingenieria de software')));
insert into content (name, number, content_id) VALUES ('Calidad y normas de calidad', 4, (SELECT id FROM synthetic_program WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name like 'Ingenieria de software')));
insert into content (name, number, content_id) VALUES ('Modelos de Madurez', 5, (SELECT id FROM synthetic_program WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name like 'Ingenieria de software')));
insert into content (name, number, content_id) VALUES ('Temas selectos', 6, (SELECT id FROM synthetic_program WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name like 'Ingenieria de software')));



insert into evaluationua (name, percentage, evaluationua_id) VALUES ('Evaluación formativa', 0.3, (SELECT id FROM evaluationua WHERE id = 1));
insert into evaluationua (name, percentage, evaluationua_id) VALUES ('Sumativa', 0.3, (SELECT id FROM evaluationua WHERE id = 1));
insert into evaluationua (name, percentage, evaluationua_id) VALUES ('rubricas de autoevaluación y coevaluación', 0.4, (SELECT id FROM evaluationua WHERE id = 1));

insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Saberes previos'));
insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Equivalencia en unidad académica del IPN'));
insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Equivalencia en extranjero'));
insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Inscripción normal'));



--									--
--		Extensive Program 			--
--									--

insert into teaching_profile values (DEFAULT, 'Capacidad para el manejo de grupos
Fluidez verbal de ideas
Capacidad de traspasar conocimientos
Manejo de grupos y trabajo colaborativo
Manejo de estrategias para fomentar el aprendizaje autónomo en el alumno
Manejo de estrategias didácticas centradas en el aprendizaje
Aplicación del MEI', 'Responsable
Honesto
Respetuoso
Tolerante
Asertivo
Colaborativo
Participativo', 'Capacidad para el manejo de grupos
Fluidez verbal de ideas
Capacidad de traspasar conocimientos
Manejo de grupos y trabajo colaborativo
Manejo de estrategias para fomentar el aprendizaje autónomo en el alumno
Manejo de estrategias didácticas centradas en el aprendizaje
Aplicación del MEI', 'Experiencia de dos años en en el análisis de Sistemas de Información (Líder de Proyecto)
Experiencia de dos años en el manejo de grupos y en el trabajo colaborativo.
Experiencia de un año como Docente de Nivel Superior.', 'Experiencia de dos años en en el análisis de Sistemas de Información (Líder de Proyecto)
Experiencia de dos años en el manejo de grupos y en el trabajo colaborativo.
Experiencia de un año como Docente de Nivel Superior.');

insert into assigned_time values (DEFAULT, 1.5, 54, 27, 54, 3, 81);

insert into extensive_program values (DEFAULT, 'Esta unidad de aprendizaje contribuye al perfil de egresado de Ingeniería en Sistemas Computacionales, al desarrollar las habilidades de análisis y diseño de proyectos haciendo uso de software de gestión de proyectos así como herramientas CASE, además de integrar los principios de gestión de la calidad regidos por los estándares establecidos para asegurar, gestionar, auditar y certificar la calidad de procesos y productos informáticos así como también planificar y proyectar es estratégicamente (Recursos Hardware y Software, Recursos Humanos, componentes reutilizables) el desarrollo de proyectos de software. Así mismo, se dinamizan las competencias de pensamiento creativo, comunicación asertiva, trabajo colaborativo y participativo.

Se relaciona con las unidades de aprendizaje: Programación Orientada, Bases de Datos y Administración de Proyectos.', 2008, (SELECT id FROM assigned_time WHERE total_semster_hour = 81), (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software'), (SELECT id FROM modality WHERE name LIKE 'Escolarizado'), (SELECT id FROM teaching WHERE name LIKE 'Obligatoria'), (SELECT id FROM teaching_profile WHERE id = 1));

insert into extensive_program_types values ((SELECT id FROM extensive_program WHERE id = 1), (SELECT id FROM type WHERE name LIKE 'Teórica'));
insert into extensive_program_types values ((SELECT id FROM extensive_program WHERE id = 1), (SELECT id FROM type WHERE name LIKE 'Práctica'));

insert into evaluation_system values (DEFAULT, 0.15, 1, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into evaluation_system values (DEFAULT, 0.15, 1, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into evaluation_system values (DEFAULT, 0.15, 2, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into evaluation_system values (DEFAULT, 0.15, 2, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into evaluation_system values (DEFAULT, 0.2, 3, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into evaluation_system values (DEFAULT, 0.2, 3, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));

insert into thematic_unit values (DEFAULT, 'Compara los diferentes modelos de proceso de un sistema software con base en sus características y el tipo de proyecto a desarrollar.', true, 'Encuadre del curso.
La presente unidad se abordará a partir de la estrategia de aprendizaje orientada a proyectos y método heurístico, lo que permitirá la consolidación de las siguientes técnicas de aprendizaje: lluvia de ideas, ficha de trabajo, indagación documental, discusión dirigida, mapas conceptuales, resolución de problemas, exposición en equipo de temas complementarios, propuesta de proyecto y realización de prácticas.', (SELECT id FROM content WHERE name LIKE 'Ingeniería de Software'), (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software'));


insert into learning_evaluation values (DEFAULT, 'Escrita', 'Evidencia de aprendizaje', 0.5);
insert into learning_evaluation values (DEFAULT, 'Continua', 'Ficha de trabajo', 0.05);
insert into learning_evaluation values (DEFAULT, 'Continua', 'Mapa conceptual', 0.05);
insert into learning_evaluation values (DEFAULT, 'Continua', 'Exposición en equipo', 0.1);
insert into learning_evaluation values (DEFAULT, 'Continua', 'Reportes de práctica', 0.15);
insert into learning_evaluation values (DEFAULT, 'Continua', 'Propuesta de Proyecto', 0.05);
insert into learning_evaluation values (DEFAULT, 'Continua', 'Rúbricas de autoevaluación', 0.05);
insert into learning_evaluation values (DEFAULT, 'Continua', 'Rúbrica de coevaluación', 0.05);

insert into topic values (DEFAULT, 1, 'Conceptos básicos de Ingeniería de Software', '1', 0, 0.5, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into topic values (DEFAULT, 1.5, 'Atributos y características del software', '2', 0, 0.5, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into topic values (DEFAULT, 1.5, 'Importancia y aplicación del software', '3', 0, 0.5, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into topic values (DEFAULT, 1.5, 'Ciclo de vida del software', '4', 0.5, 0.5, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));
insert into topic values (DEFAULT, 3.5, 'Modelos de procesos', '5', 1, 1, (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software')));

insert into subtopic values (DEFAULT, 'Lineal secuencial', 1, (SELECT id FROM topic WHERE topics_id IN (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software'))));
insert into subtopic values (DEFAULT, 'Cascada', 2, (SELECT id FROM topic WHERE topics_id IN (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software'))));
insert into subtopic values (DEFAULT, 'Incremental', 3, (SELECT id FROM topic WHERE topics_id IN (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software'))));
insert into subtopic values (DEFAULT, 'Desarrollo Rápido de Aplicaciones', 4, (SELECT id FROM topic WHERE topics_id IN (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software'))));
insert into subtopic values (DEFAULT, 'Prototipos', 5, (SELECT id FROM topic WHERE topics_id IN (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software'))));
insert into subtopic values (DEFAULT, 'Espiral', 6, (SELECT id FROM topic WHERE topics_id IN (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'ngenieria de software'))));



--									--
--			Bibliography 			--
--									--

insert into bibliography VALUES ('788478978588', 'AlfaOmega', 2008, 'Medición y estimación del software: Técnicas y Métodos para mejorar la calidad y la productividad.', (SELECT id FROM country WHERE name like 'M%xico'));
insert into bibliography VALUES ('9701509870', 'AlfaOmega', 2004, 'Análisis y diseño de aplicaciones informáticas de gestión. Una perspectiva de Ingeniería del Software.', (SELECT id FROM country WHERE name like 'M%xico'));
insert into bibliography VALUES ('9789701512678', 'AlfaOmega', 2005, 'Calidad de Sistemas Informáticos.', (SELECT id FROM country WHERE name like 'M_xico'));
insert into bibliography VALUES ('9701054733', 'Mc Graw Hill', 2007, 'Ingeniería del software: Un enfoque Práctico.', (SELECT id FROM country WHERE name like 'M_xico'));
insert into bibliography VALUES ('9789702602064', 'Addison Wesley', 2008, 'Ingeniería de Software.', (SELECT id FROM country WHERE name like 'Espa_a'));

insert into author (name, parental_surname, maternal_surname) VALUES ('Félix Oscar', 'García', 'Rubio');
insert into author (name, parental_surname, maternal_surname) VALUES ('Mario G.', 'Piattini', 'Velthuis');
insert into author (name, parental_surname, maternal_surname) VALUES ('Roger S.', 'Pressman', '');
insert into author (name, parental_surname, maternal_surname) VALUES ('Ian', 'Sommerville', '');

insert into bibliography_authors values ('788478978588', (SELECT id FROM author WHERE name LIKE 'Félix Oscar'));
insert into bibliography_authors values ('9701509870', (SELECT id FROM author WHERE name LIKE 'Mario G.'));
insert into bibliography_authors values ('9789701512678', (SELECT id FROM author WHERE name LIKE 'Mario G.'));
insert into bibliography_authors values ('9701054733', (SELECT id FROM author WHERE name LIKE 'Roger S.'));
insert into bibliography_authors values ('9789702602064', (SELECT id FROM author WHERE name LIKE 'Ian'));

insert into bibliography_relation values (DEFAULT, true, 1, '788478978588', (SELECT id FROM bibliography_type WHERE type LIKE 'Básica'), (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));
insert into bibliography_relation values (DEFAULT, true, 1, '9701509870', (SELECT id FROM bibliography_type WHERE type LIKE 'Básica'), (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));
insert into bibliography_relation values (DEFAULT, true, 1, '9789701512678', (SELECT id FROM bibliography_type WHERE type LIKE 'Básica'), (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));
insert into bibliography_relation values (DEFAULT, true, 1, '9701054733', (SELECT id FROM bibliography_type WHERE type LIKE 'Básica'), (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));
insert into bibliography_relation values (DEFAULT, true, 1, '9789702602064', (SELECT id FROM bibliography_type WHERE type LIKE 'Básica'), (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));

--

insert into bibliography_thematic_units values ('9701509870', (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));
insert into bibliography_thematic_units values ('9701054733', (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));
insert into bibliography_thematic_units values ('9789702602064', (SELECT id FROM thematic_unit WHERE learning_unit_id = (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software')));


-- insert into schooling_grade (speciality, academic_level_id) values ('Computación', (SELECT id FROM academic_level WHERE name like 'Maestro'));

-- insert into teaching_profile_schooling_grades values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM schooling_grade WHERE speciality LIKE 'Computación' AND academic_level_id = (SELECT id FROM academic_level WHERE name like 'Maestro')));

-- insert into attitude (name) values ('Responsable');
-- insert into attitude (name) values ('Honesto');
-- insert into attitude (name) values ('Respetuoso');
-- insert into attitude (name) values ('Tolerante');
-- insert into attitude (name) values ('Asertivo');
-- insert into attitude (name) values ('Colaborativo');
-- insert into attitude (name) values ('Participativo');

-- insert into teaching_profile_attitude values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM attitude WHERE name LIKE 'Responsable'));
-- insert into teaching_profile_attitude values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM attitude WHERE name LIKE 'Honesto'));
-- insert into teaching_profile_attitude values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM attitude WHERE name LIKE 'Respetuoso'));
-- insert into teaching_profile_attitude values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM attitude WHERE name LIKE 'Tolerante'));
-- insert into teaching_profile_attitude values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM attitude WHERE name LIKE 'Asertivo'));
-- insert into teaching_profile_attitude values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM attitude WHERE name LIKE 'Colaborativo'));
-- insert into teaching_profile_attitude values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM attitude WHERE name LIKE 'Participativo'));

-- insert into knowledge (name) values ('Lenguaje de Modelado Unificado');
-- insert into knowledge (name) values ('Ingeniería de Software');
-- insert into knowledge (name) values ('Programación en un lenguaje de alto nivel.');
-- insert into knowledge (name) values ('Modelos de Madurez y Mejora de Procesos');
-- insert into knowledge (name) values ('Metodologías Ágiles');
-- insert into knowledge (name) values ('Idioma Inglés');
-- insert into knowledge (name) values ('MEI');

-- insert into teaching_profile_knowledges values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM knowledge WHERE name LIKE 'Lenguaje de Modelado Unificado'));
-- insert into teaching_profile_knowledges values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM knowledge WHERE name LIKE 'Ingeniería de Software'));
-- insert into teaching_profile_knowledges values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM knowledge WHERE name LIKE 'Programación en un lenguaje de alto nivel.'));
-- insert into teaching_profile_knowledges values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM knowledge WHERE name LIKE 'Modelos de Madurez y Mejora de Procesos'));
-- insert into teaching_profile_knowledges values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM knowledge WHERE name LIKE 'Metodologías Ágiles'));
-- insert into teaching_profile_knowledges values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM knowledge WHERE name LIKE 'Idioma Inglés'));
-- insert into teaching_profile_knowledges values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM knowledge WHERE name LIKE 'MEI'));

-- insert into ability (name) values ('Capacidad para el manejo de grupos');
-- insert into ability (name) values ('Fluidez verbal de ideas');
-- insert into ability (name) values ('Capacidad de traspasar conocimientos');
-- insert into ability (name) values ('Manejo de grupos y trabajo colaborativo');
-- insert into ability (name) values ('Manejo de estrategias para fomentar el aprendizaje autónomo en el alumno');
-- insert into ability (name) values ('Manejo de estrategias didácticas centradas en el aprendizaje');
-- insert into ability (name) values ('Aplicación del MEI');

-- insert into teaching_profile_ability values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM ability WHERE name LIKE 'Capacidad para el manejo de grupos'));
-- insert into teaching_profile_ability values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM ability WHERE name LIKE 'Fluidez verbal de ideas'));
-- insert into teaching_profile_ability values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM ability WHERE name LIKE 'Capacidad de traspasar conocimientos'));
-- insert into teaching_profile_ability values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM ability WHERE name LIKE 'Manejo de grupos y trabajo colaborativo'));
-- insert into teaching_profile_ability values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM ability WHERE name LIKE 'Manejo de estrategias para fomentar el aprendizaje autónomo en el alumno'));
-- insert into teaching_profile_ability values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM ability WHERE name LIKE 'Manejo de estrategias didácticas centradas en el aprendizaje'));
-- insert into teaching_profile_ability values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM ability WHERE name LIKE 'Aplicación del MEI'));

-- insert into professional_experience (name) values ('Experiencia de dos años en en el análisis de Sistemas de Información (Líder de Proyecto)');
-- insert into professional_experience (name) values ('Experiencia de dos años en el manejo de grupos y en el trabajo colaborativo.');
-- insert into professional_experience (name) values ('Experiencia de un año como Docente de Nivel Superior.');

-- insert into teaching_profile_professional_experiences values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM professional_experience WHERE name LIKE 'Experiencia de dos años en en el análisis de Sistemas de Información (Líder de Proyecto)'));
-- insert into teaching_profile_professional_experiences values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM professional_experience WHERE name LIKE 'Experiencia de dos años en el manejo de grupos y en el trabajo colaborativo.'));
-- insert into teaching_profile_professional_experiences values ((SELECT id FROM teaching_profile WHERE id = 1), (SELECT id FROM professional_experience WHERE name LIKE 'Experiencia de un año como Docente de Nivel Superior.'));

-- insert into assigned_time values (DEFAULT, 1.5, 54, 27, 54, 3, 81);

-- insert into extensive_program values (DEFAULT, 'Esta unidad de aprendizaje contribuye al perfil de egresado de Ingeniería en Sistemas Computacionales, al desarrollar las habilidades de análisis y diseño de proyectos haciendo uso de software de gestión de proyectos así como herramientas CASE, además de integrar los principios de gestión de la calidad regidos por los estándares establecidos para asegurar, gestionar, auditar y certificar la calidad de procesos y productos informáticos así como también planificar y proyectar es estratégicamente (Recursos Hardware y Software, Recursos Humanos, componentes reutilizables) el desarrollo de proyectos de software. Así mismo, se dinamizan las competencias de pensamiento creativo, comunicación asertiva, trabajo colaborativo y participativo.

-- Se relaciona con las unidades de aprendizaje: Programación Orientada, Bases de Datos y Administración de Proyectos.', 2008, (SELECT id FROM assigned_time WHERE total_semster_hour = 81), (SELECT id FROM learning_unit WHERE name LIKE 'Ingenieria de software'), (SELECT id FROM modality WHERE name LIKE 'Escolarizado'), (SELECT id FROM teaching WHERE name LIKE 'Obligatoria'), (SELECT id FROM teaching_profile WHERE id = 1));

-- insert into extensive_program_types values ((SELECT id FROM extensive_program WHERE id = 1), (SELECT id FROM type WHERE name LIKE 'Teórica'));
-- insert into extensive_program_types values ((SELECT id FROM extensive_program WHERE id = 1), (SELECT id FROM type WHERE name LIKE 'Práctica'));

