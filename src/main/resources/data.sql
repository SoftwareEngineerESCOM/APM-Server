-- add workplace type
insert into workplace_type (abbreviation, description, name) values ('U.Adm.','Administración','Unidad Administrativa');
insert into workplace_type (abbreviation, description, name) values ('U.A.','Centro de estudios','Unidad Académica');

-- add workplace
insert into workplace (abbreviation, name, workplace_type_id) values ('DES', 'Dirección de Estudios Superiores', (select id from workplace_type where name like '%Unidad Administrativa%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('DG', 'Dirección General', (select id from workplace_type where name like '%Unidad Administrativa%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('CGFIE', 'Coordinación General de Formación e Innovación Educativa (CGFIE)', (select id from workplace_type where name like '%Unidad Administrativa%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('DFLE', 'Dirección de Formación en Lenguas Extranjeras', (select id from workplace_type where name like '%Unidad Administrativa%'));
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIME Zacatenco', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Zacatenco', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIME Culhuacán', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Culhuacán', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIME Azcapotzalco', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Azcapotzalco', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIME Ticomán', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Ticomán', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIA Zacatenco', 'Escuela Superior de Ingeniería y Arquitectura (ESIA) Unidad Zacatenco', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIA Tecamachalco', 'Escuela Superior de Ingeniería y Arquitectura (ESIA) Unidad Tecamachalco', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIA Ticomán', 'Escuela Superior de Ingeniería y Arquitectura (ESIA) Unidad Ticomán', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIT', 'Escuela Superior de Ingeniería Textil (ESIT)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESIQIE', 'Escuela Superior de Ingeniería Química e Industrias Extractivas (ESIQIE)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESFM', 'Escuela Superior de Física y Matemáticas (ESFM)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESCOM', 'Escuela Superior de Cómputo (ESCOM)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('UPIICSA', 'Unidad Profesional Interdisciplinaria de Ingeniería y Ciencias Sociales y Administrativas (UPIICSA)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('UPIITA', 'Unidad Profesional Interdisciplinaria en Ingeniería y Tecnologías Avanzadas (UPIITA)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('UPIBI', 'Unidad Profesional Interdisciplinaria de Biotecnología (UPIBI)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('UPIIG', 'Unidad Profesional Interdisciplinaria de Ingeniería, Campus Guanajuato (UPIIG)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('UPIIZ', 'Unidad Profesional Interdisciplinaria de Ingeniería, Campus Zacatecas (UPIIZ)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ENCB', 'Escuela Nacional de Ciencias Biológicas (ENCB)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESM', 'Escuela Superior de Medicina (ESM)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ENMH', 'Escuela Nacional de Medicina y Homeopatía (ENMH)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESEO', 'Escuela Superior de Enfermería y Obstetricia (ESEO)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('CICS UMA', 'Centro Interdisciplinario de Ciencias de la Salud (CICS) Unidad Milpa Alta', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('CICS ST', 'Centro Interdisciplinario de Ciencias de la Salud (CICS) Unidad Santo Tomás', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESCA ST', 'Escuela Superior de Comercio y Administración (ESCA) Unidad Santo Tomás', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESCA Tepepan', 'Escuela Superior de Comercio y Administración (ESCA) Unidad Tepepan', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('ESE', 'Escuela Superior de Economía (ESE)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('EST', 'Escuela Superior de Turismo (EST)', (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace (abbreviation, name, workplace_type_id) values ('CENLEX', 'Centro de Lenguas Extranjeras', (select id from workplace_type where name like '%Unidad Académica%'));

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

-- add study_plan_mode
insert into study_plan_mode (description, name) values ('Escolarizado', 'Escolarizado');
insert into study_plan_mode (description, name) values ('A distancia', 'A distancia');
insert into study_plan_mode (description, name) values ('Mixto', 'Mixto');

-- add study_plan
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%Escolarizado%'), 250.0, 30.0, 35.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%Escolarizado%'), 234.0, 33.0, 31.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería en Control y Automatización%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%A distancia%'), 240.0, 34.0, 31.0, 133.0, 2018, (select id from academic_program where name like '%Licenciatura en Comercio Internacional%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%A distancia%'), 260.0, 32.0, 31.0, 135.0, 2018, (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%Escolarizado%'), 225.0, 32.0, 31.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería Mecatrónica%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%Escolarizado%'), 250.0, 31.0, 32.0, 132.0, 2018, (select id from academic_program where name like '%Ingeniería Textil%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%A distancia%'), 250.0, 30.0, 31.0, 140.0, 2018, (select id from academic_program where name like '%Ingeniería Biotecnológica%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%Escolarizado%'), 235.0, 30.0, 33.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería Química Petrolera%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%A distancia%'), 245.0, 31.0, 31.0, 137.0, 2018, (select id from academic_program where name like '%Ingeniería Civil%'));
insert into study_plan (mode_id, total_practice_hours, totalsatcacredits, totaltepiccredits, total_theory_hours, year, academic_program_id) values ((select id from study_plan_mode where name like '%Escolarizado%'), 255.0, 31.0, 30.0, 138.0, 2018, (select id from academic_program where name like '%Ingeniería en Sistemas Ambientales%'));

-- add semester 
insert into semester (semester_number, study_plan_id) (select 1, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 2, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 3, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 4, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 5, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 6, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 7, id from study_plan);
insert into semester (semester_number, study_plan_id) (select 8, id from study_plan);

-----------------------
-- add learning_unit --
-----------------------
-- Escuela Num 1
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (4.39, 7.5, 'Profesional', 'Ingenieria de software', 1.5, 54, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (4.28, 7.5, 'Profesional', 'Estructura de Datos', 1.5, 3.0, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (4.4, 7.5, 'Profesional', 'Base de Datos', 1.5, 3.0, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Sistemas Computacionales%')));

-- Escuela Num 2
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Fisica Clasica', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Ecuaciones Diferenciales', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Ondas Mecanicas', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería en Control y Automatización%')));

-- Escuela Num 3
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Comunicacion Oral y Escrita', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Calidad', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Administracion Estrategica', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Comercio Internacional%')));

-- Escuela Num 4
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (0, 9, 'Profesional', 'Geometria Analitica', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (0, 9, 'Profesional', 'Analisis Vectorial', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (0, 9, 'Profesional', 'Fisica 3', 3.0, 6.0, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Licenciatura en Física y Matemáticas%')));

-- Escuela Num 5
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Mecanica de la particula', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Circuitos Electricos', 1.5, 1.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Electricidad y Magnetismo', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Mecatrónica%')));

-- Escuela Num 6
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Metodos Hilados', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Quimica Textil', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Higiene y seguridad industrial', 1.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Textil%')));

-- Escuela Num 7
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Quimica General', 2, 5, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Quimica de Soluciones', 2, 4, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.0, 7.5, 'Profesional', 'Quimica Organica 1', 3, 3, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Biotecnológica%')));

-- Escuela Num 8
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Geologia', 1.5, 3.0, (select s.id from semester s, study_plan sp where s.semester_number = 1 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Dinamica de la Particula', 0, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 2 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));
insert into learning_unit (satcacredits, tepiccredits, formation_area, name, practice_hours_per_week, theory_hours_per_week, semester_id) values (3.5, 7.0, 'Profesional', 'Topografia', 4.5, 4.5, (select s.id from semester s, study_plan sp where s.semester_number = 3 and s.study_plan_id = sp.id and sp.academic_program_id = (select id from academic_program where name like '%Ingeniería Química Petrolera%')));


-- add titles
insert into title (abbreviation, description, name) values ('Abg.', ' Persona que posee el título de Abogado/a', 'Abogado/a');
insert into title (abbreviation, description, name) values ('Arq.', ' Persona que posee el título de Arquitecto/a', 'Arquitecto/a');
insert into title (abbreviation, description, name) values ('C.P.T.', ' Persona que posee el título de Contador público titulado', 'Contador público titulado');
insert into title (abbreviation, description, name) values ('Dr.', ' Persona que posee el título de Doctor', 'Doctor');
insert into title (abbreviation, description, name) values ('Dra.', ' Persona que posee el título de Doctora', 'Doctora');
insert into title (abbreviation, description, name) values ('Ing.', ' Persona que posee el título de Ingeniero/a', 'Ingeniero/a');
insert into title (abbreviation, description, name) values ('Lic.', ' Persona que posee el título de Licenciado/a', 'Licenciado/a');
insert into title (abbreviation, description, name) values ('Mtr.', ' Persona que posee el título de Máster || Magíster', 'Máster || Magíster');
insert into title (abbreviation, description, name) values ('Mtro.', ' Persona que posee el título de Maestro || Ministro', 'Maestro || Ministro');
insert into title (abbreviation, description, name) values ('Mtra.', ' Persona que posee el título de Maestra || Ministra', 'Maestra || Ministra');
insert into title (abbreviation, description, name) values ('Tec.', ' Persona que posee el título de Técnico', 'Técnico');
-- insert into title (abbreviation, description, name) values ('Dir.', ' Persona que posee el título de Director/a', 'Director/a');
-- insert into title (abbreviation, description, name) values ('Pdte.', ' Persona que posee el título de Presidente', 'Presidente');
-- insert into title (abbreviation, description, name) values ('Magtr.', ' Persona que posee el título de Magíster', 'Magíster');
-- insert into title (abbreviation, description, name) values ('Gral.', ' Persona que posee el título de General', 'General');
-- insert into title (abbreviation, description, name) values ('Alm.', ' Persona que posee el título de Almirante', 'Almirante');
-- insert into title (abbreviation, description, name) values ('Tte.', ' Persona que posee el título de Teniente', 'Teniente');
-- insert into title (abbreviation, description, name) values ('Cap.', ' Persona que posee el título de Capitán', 'Capitán');
-- insert into title (abbreviation, description, name) values ('Crnl.', ' Persona que posee el título de Coronel', 'Coronel');
-- insert into title (abbreviation, description, name) values ('Sarg.', ' Persona que posee el título de Sargento', 'Sargento');

-- add positions
insert into position (abbreviation, description, name) values ('Dir.', 'Director', 'Director');
insert into position (abbreviation, description, name) values ('Doc.', 'Docente', 'Docente');
insert into position (abbreviation, description, name) values ('JDES.', 'Jefa Dirección Estudios Superiores', 'Jefa Dirección Estudios Superiores');
insert into position (abbreviation, description, name) values ('Anl.', 'Analista', 'Analista');
insert into position (abbreviation, description, name) values ('Sub. Ac.', 'Subdirector Académico', 'Subdirector Académico');

-- add roles
insert into role (description, name) values ('Encargado de: ', 'Analista');
insert into role (description, name) values ('Encargado de: ', 'Jefe de Departamento de Desarrollo e Innovación Curricular');
insert into role (description, name) values ('Encargado de: ', 'Jefe de Innovación Educativa');
insert into role (description, name) values ('Encargado de: ', 'Jefe de la División de Innovacion Académica');
insert into role (description, name) values ('Encargado de: plan de estudios,unidades de aprendizaje y programa sintético', 'Docente');

-- add human resource
insert into human_resource values ('1234567890', 'Chávez', 'Oscar', 'Barrera', (select id from position where abbreviation like '%Dir.%'), (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'ESCOM'));
insert into human_resource values ('1000000001', 'González', 'Emiliano', 'Hinojosa', (select id from position where abbreviation like '%Dir.%'), (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'UPIITA'));
insert into human_resource values ('9876543210', 'Frías', 'Erika', 'Covarrubias', (select id from position where abbreviation like '%Sub. Ac.%'), (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'ESCOM'));
insert into human_resource values ('1000000003', 'Jiménez', 'Eduardo', 'Hernádez', (select id from position where abbreviation like '%Sub. Ac.%'), (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'UPIITA'));
insert into human_resource values ('1000000004', 'Rojas', 'Arturo', 'Rivas', (select id from position where abbreviation like '%Sub. Ac.%'), (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'UPIBI'));
insert into human_resource values ('1000000005', 'González', 'Daniela', 'Hernández', (select id from position where abbreviation like '%Doc.%'), (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'ESCOM'));
insert into human_resource values ('1000000006', 'Figueroa', 'Hugo', 'Bernal', (select id from position where abbreviation like '%Doc.%'), (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'ESIME Zacatenco'));
insert into human_resource values ('1000000007', 'Castrejón', 'Miguel', 'Sánchez', (select id from position where abbreviation like '%Doc.%'), (select id from title where abbreviation like '%Mtro.%'), (select id from workplace where abbreviation like 'ESFM'));
insert into human_resource values ('1000000008', 'Castillo', 'Alejandra', 'Jiménez', (select id from position where abbreviation like '%Doc.%'), (select id from title where abbreviation like '%Lic.%'), (select id from workplace where abbreviation like 'ESIT'));
insert into human_resource values ('1000000009', 'Guerra', 'David', 'Vargas', (select id from position where abbreviation like '%Dir.%'), (select id from title where abbreviation like '%Dr.%'), (select id from workplace where abbreviation like 'UPIBI'));

-- add user
insert into user_apms values ((select id from human_resource where name like '%Oscar%'), true, 'admin1', '1', (select id from human_resource where name like '%Oscar%'));
insert into user_apms values ((select id from human_resource where name like '%Emiliano%'), true, 'test1', '2', (select id from human_resource where name like '%Emiliano%'));
insert into user_apms values ((select id from human_resource where name like '%Erika%'), false, 'test2', '3', (select id from human_resource where name like '%Erika%'));
insert into user_apms values ((select id from human_resource where name like '%Eduardo%'), true, 'test3', '4', (select id from human_resource where name like '%Eduardo%'));
insert into user_apms values ((select id from human_resource where name like '%Arturo%'), false, 'test4', '5', (select id from human_resource where name like '%Arturo%'));

-- add message
insert into message values (0, 'Esta es la descripción', 'Matrícula y/o contraseña no válidas.');
insert into message values (1, 'Esta es la descripción', '¿Está seguro que desea editar el Programa Académico?');
insert into message values (2, 'Esta es la descripción', '¿Está seguro que desea cancelar la consulta de Programas Académicos?');
insert into message values (3, 'Esta es la descripción', '¿Está seguro que desea registrar un Programa Académico?');
insert into message values (4, 'Esta es la descripción', 'Los campos marcados con (*) son obligatorios.');
insert into message values (5, 'Esta es la descripción', 'Registro finalizado exitosamente.');
insert into message values (6, 'Esta es la descripción', '¿Está seguro que desea cancelar el registro?');
insert into message values (7, 'Esta es la descripción', 'Los catálogos necesarios no se han cargado, favor de intentarlo más tarde.');
insert into message values (8, 'Esta es la descripción', 'El libro con el ISBN "Número de ISBN" ya existe.');
insert into message values (9, 'Esta es la descripción', 'Por el momento no se puede realizar el registro.');
insert into message values (10, 'Esta es la descripción', 'Error: Primero debe seleccionar el punto en donde se agregará el comentario');
insert into message values (11, 'Esta es la descripción', 'Error: Debe agregar un texto al nuevo comentario.');
insert into message values (12, 'Esta es la descripción', 'Ingrese su comentario en el nuevo campo de la bitácora.');
insert into message values (13, 'Esta es la descripción', 'Revisión de paquete finalizada. Paquete enviado.');
insert into message values (14, 'Esta es la descripción', 'Error al finalizar paquete.');
insert into message values (15, 'Esta es la descripción', '¿Está seguro que desea cancelar la revisión? Se perderán las anotaciones que no hayas guardado anteriormente.');
insert into message values (16, 'Esta es la descripción', '¿Está seguro de finalizar la revisión?');
insert into message values (17, 'Esta es la descripción', 'Sección Aprobada.');
insert into message values (18, 'Esta es la descripción', 'Revisión de Sección Finalizada.');
insert into message values (19, 'Esta es la descripción', 'Anotaciones en sección guardadas correctamente.');
insert into message values (20, 'Esta es la descripción', 'Los campos no fueron contestados correctamente.');
insert into message values (21, 'Esta es la descripción', 'No hay usuarios registrados con ese cargo.');
insert into message values (22, 'Esta es la descripción', '¿Está seguro de eliminar al empleado ''Nombre'' con matrícula: ''Matrícula'' del sistema?');
insert into message values (23, 'Esta es la descripción', 'Los porcentajes de evaluación no cumplen con el porcentaje total.');
insert into message values (24, 'Esta es la descripción', 'Por el momento la página solicitada no esta disponible.');
insert into message values (25, 'Esta es la descripción', 'Servicios no disponibles por el momento.');
insert into message values (26, 'Esta es la descripción', 'La matrícula ingresada no se encuentra registrada en el sistema.');
insert into message values (27, 'Esta es la descripción', 'Empleado modificado.');
insert into message values (28, 'Esta es la descripción', 'El autor: "Nombre Primer Apellido Segundo Apellido" ya existe.');
insert into message values (29, 'Esta es la descripción', '¿Está seguro que desea cancelar? Se perderán todos los avances sin guardar.');
insert into message values (30, 'Esta es la descripción', '¿Está seguro que desea finalizar? Ya no podrá realizar modificaciones.');
insert into message values (31, 'Esta es la descripción', 'Los cambios se guardaron exitosamente.');
insert into message values (32, 'Esta es la descripción', 'Todos los campos son obligatorios.');
insert into message values (33, 'Esta es la descripción', 'El Recurso Humano con la Matrícula de Empleado [Número de Matrícula de Empleado] ya existe.');
insert into message values (34, 'Esta es la descripción', '¿Está seguro que desea Eliminar al Recurso Humano con Matricula [no.matricula]?');
insert into message values (35, 'Esta es la descripción', 'Inconsistencia en los datos. Verifique los campos e intente de nuevo.');
insert into message values (36, 'Esta es la descripción', 'Error, el usuario ya existe en el sistema.');
insert into message values (37, 'Esta es la descripción', 'Ha ocurrido un error al guardar los datos.');
insert into message values (38, 'Esta es la descripción', '¿Está seguro que desea eliminar la Unidad de Aprendizaje [Nombre de la Unidad de Aprendizaje]?.');
insert into message values (39, 'Esta es la descripción', '¿Está seguro que desea eliminar el Semestre [Número del Semestre]?.');
insert into message values (40, 'Esta es la descripción', '¿Está seguro que desea generar una tarea para el registro de un nuevo Plan de Estudios?');
insert into message values (41, 'Esta es la descripción', 'Debe llenar el Programa Sintético para realizar este registro');
insert into message values (42, 'Esta es la descripción', 'Fecha invalida.');
