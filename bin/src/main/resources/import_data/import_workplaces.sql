-- add workplace
insert into workplace values (1, 'DES', 'Dirección de Estudios Superiores', null, (select id from workplace_type where name like '%Unidad Administrativa%')); 
insert into workplace values (2, 'DG', 'Dirección General', null, (select id from workplace_type where name like '%Unidad Administrativa%')); 
insert into workplace values (3, 'CGFIE', 'Coordinación General de Formación e Innovación Educativa (CGFIE)', null, (select id from workplace_type where name like '%Unidad Administrativa%')); 
insert into workplace values (4, 'DFLE', 'Dirección de Formación en Lenguas Extranjeras', null, (select id from workplace_type where name like '%Unidad Administrativa%'));
insert into workplace values (5, 'ESIME Zacatenco', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Zacatenco', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (6, 'ESIME Culhuacán', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Culhuacán', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (7, 'ESIME Azcapotzalco', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Azcapotzalco', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (8, 'ESIME Ticomán', 'Escuela Superior de Ingeniería Mecánica y Eléctrica (ESIME) Unidad Ticomán', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (9, 'ESIA Zacatenco', 'Escuela Superior de Ingeniería y Arquitectura (ESIA) Unidad Zacatenco', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (10, 'ESIA Tecamachalco', 'Escuela Superior de Ingeniería y Arquitectura (ESIA) Unidad Tecamachalco', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (11, 'ESIA Ticomán', 'Escuela Superior de Ingeniería y Arquitectura (ESIA) Unidad Ticomán', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (12, 'ESIT', 'Escuela Superior de Ingeniería Textil (ESIT)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (13, 'ESIQIE', 'Escuela Superior de Ingeniería Química e Industrias Extractivas (ESIQIE)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (14, 'ESFM', 'Escuela Superior de Física y Matemáticas (ESFM)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (15, 'ESCOM', 'Escuela Superior de Cómputo (ESCOM)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (16, 'UPIICSA', 'Unidad Profesional Interdisciplinaria de Ingeniería y Ciencias Sociales y Administrativas (UPIICSA)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (17, 'UPIITA', 'Unidad Profesional Interdisciplinaria en Ingeniería y Tecnologías Avanzadas (UPIITA)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (18, 'UPIBI', 'Unidad Profesional Interdisciplinaria de Biotecnología (UPIBI)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (19, 'UPIIG', 'Unidad Profesional Interdisciplinaria de Ingeniería, Campus Guanajuato (UPIIG)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (20, 'UPIIZ', 'Unidad Profesional Interdisciplinaria de Ingeniería, Campus Zacatecas (UPIIZ)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (21, 'ENCB', 'Escuela Nacional de Ciencias Biológicas (ENCB)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (22, 'ESM', 'Escuela Superior de Medicina (ESM)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (23, 'ENMH', 'Escuela Nacional de Medicina y Homeopatía (ENMH)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (24, 'ESEO', 'Escuela Superior de Enfermería y Obstetricia (ESEO)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (25, 'CICS UMA', 'Centro Interdisciplinario de Ciencias de la Salud (CICS) Unidad Milpa Alta', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (26, 'CICS ST', 'Centro Interdisciplinario de Ciencias de la Salud (CICS) Unidad Santo Tomás', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (27, 'ESCA ST', 'Escuela Superior de Comercio y Administración (ESCA) Unidad Santo Tomás', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (28, 'ESCA Tepepan', 'Escuela Superior de Comercio y Administración (ESCA) Unidad Tepepan', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (29, 'ESE', 'Escuela Superior de Economía (ESE)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (30, 'EST', 'Escuela Superior de Turismo (EST)', null, (select id from workplace_type where name like '%Unidad Académica%')); 
insert into workplace values (31, 'CENLEX', 'Centro de Lenguas Extranjeras', null, (select id from workplace_type where name like '%Unidad Académica%'));
