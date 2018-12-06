-- add academic_level
insert into learning_unit_task (learningUnit, user_apms, startDate, deadLine) values ((select id from learning_unit limit 1), (select id from user_apms limit 1), "13-12-2018", "24-12-2018");
insert into learning_unit_task (learningUnit, user_apms, startDate, deadLine) values ((select id from learning_unit limit 1 offset 1), (select id from user_apms limit 1), "14-12-2018", "17-12-2018");
insert into learning_unit_task (learningUnit, user_apms, startDate, deadLine) values ((select id from learning_unit limit 1 offset 2), (select id from user_apms limit 1), "17-12-2018", "20-12-2018");
insert into learning_unit_task (learningUnit, user_apms, startDate, deadLine) values ((select id from learning_unit limit 1 offset 3), (select id from user_apms limit 1), "09-12-2018", "11-12-2018");
insert into learning_unit_task (learningUnit, user_apms, startDate, deadLine) values ((select id from learning_unit limit 1 offset 4), (select id from user_apms limit 1), "11-12-2018", "13-12-2018");
