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
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (4.39, 7.5, (select id from formation_area where name like '%Profesional%'), 'Ingenieria de software', 1.5, 3.0, (select s.id from semester s, study_plan sp where s.semester_number = 4 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (4.28, 7.5, (select id from formation_area where name like '%Profesional%'), 'Estructura de Datos', 1.5, 3.0, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (4.4, 7.5, (select id from formation_area where name like '%Profesional%'), 'Base de Datos', 1.5, 3.0, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));

-- Escuela Num 2
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Terminal y de Integración%'), 'Fisica Clasica', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Profesional%'), 'Ecuaciones Diferenciales', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Institucional%'), 'Ondas Mecanicas', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));

-- Escuela Num 3
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Institucional%'), 'Comunicacion Oral y Escrita', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Profesional%'), 'Calidad', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Científica Básica%'), 'Administracion Estrategica', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));

-- Escuela Num 4
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (0, 9, (select id from formation_area where name like '%Profesional%'), 'Geometria Analitica', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (0, 9, (select id from formation_area where name like '%Institucional%'), 'Analisis Vectorial', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (0, 9, (select id from formation_area where name like '%Institucional%'), 'Fisica 3', 3.0, 6.0, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));

-- Escuela Num 5
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Profesional%'), 'Mecanica de la particula', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Científica Básica%'), 'Circuitos Electricos', 1.5, 1.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Terminal y de Integración%'), 'Electricidad y Magnetismo', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));

-- Escuela Num 6
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Profesional%'), 'Metodos Hilados', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Científica Básica%'), 'Quimica Textil', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Científica Básica%'), 'Higiene y seguridad industrial', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));

-- Escuela Num 7
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Terminal y de Integración%'), 'Quimica General', 2, 5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Científica Básica%'), 'Quimica de Soluciones', 2, 4, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, (select id from formation_area where name like '%Institucional%'), 'Quimica Organica 1', 3, 3, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));

-- Escuela Num 8
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Científica Básica%'), 'Geologia', 1.5, 3.0, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Profesional%'), 'Dinamica de la Particula', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area_id, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, (select id from formation_area where name like '%Terminal y de Integración%'), 'Topografia', 4.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));

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

-- insert into learning_unit_evaluation (name, percentage, evaluation_accreditationua_id) VALUES ('Evaluación formativa', 0.3, (SELECT id FROM evaluationua WHERE id = 1));
-- insert into learning_unit_evaluation (name, percentage, evaluation_accreditationua_id) VALUES ('Sumativa', 0.3, (SELECT id FROM evaluationua WHERE id = 1));
-- insert into learning_unit_evaluation (name, percentage, evaluation_accreditationua_id) VALUES ('rubricas de autoevaluación y coevaluación', 0.4, (SELECT id FROM evaluationua WHERE id = 1));

insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Saberes previos'));
insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Equivalencia en unidad académica del IPN'));
insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Equivalencia en extranjero'));
insert into evaluation_accreditationua_accreditation_type (evaluation_accreditationua_id, accreditation_type_id) VALUES ((SELECT id FROM evaluation_accreditationua WHERE id = 1), (SELECT id FROM accreditation_type WHERE name like 'Inscripción normal'));

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
