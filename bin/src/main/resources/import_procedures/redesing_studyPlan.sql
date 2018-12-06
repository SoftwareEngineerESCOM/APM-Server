CREATE OR REPLACE FUNCTION copy_studyplan(
	studyplan_id integer
	)
	RETURNS integer
	AS $BODY$

	DECLARE new_study_plan_id INTEGER;

	BEGIN
		SELECT nextval('study_plan_id_seq') INTO new_study_plan_id 
		FROM study_plan 
		WHERE id = studyplan_id;

		INSERT INTO study_plan
		SELECT 
		new_study_plan_id,
		total_practice_hours,
		totalsatcacredits,
		totaltepiccredits,
		total_theory_hours,
		date_part('year', CURRENT_DATE),
		academic_program_id,
		modality_id
		FROM study_plan 
		WHERE id = studyplan_id;

		RETURN new_study_plan_id;
	END;
$BODY$
LANGUAGE plpgsql;

ALTER FUNCTION copy_studyplan(integer)
	owner to postgres;

CREATE OR REPLACE FUNCTION copy_semesterstostudyplan(
	studyplan_id integer, new_study_plan_id integer
	)
	RETURNS integer
	AS $BODY$

	BEGIN
		INSERT INTO semester (semester_number, study_plan_id)
		SELECT 
		semester_number,
		new_study_plan_id
		FROM semester 
		WHERE study_plan_id = studyPlan_id;

		RETURN NULL;
	END;
$BODY$
LANGUAGE plpgsql;

ALTER FUNCTION copy_semestertTsStudpPlan(integer, integer)
  owner to postgres;

CREATE OR REPLACE FUNCTION copy_learningUnitsTtSsudyPpan(
	studyplan_id integer, new_study_plan_id integer
	)
	RETURNS integer
	AS $BODY$
	
	DECLARE semestersNumber INTEGER[] := array(SELECT semester_number FROM semester WHERE study_plan_id = studyPlan_id);
	DECLARE semesterNumber INTEGER;

	BEGIN
		FOREACH semesterNumber IN ARRAY semestersNumber LOOP
			INSERT INTO learning_unit (
			satcacredits, 
			tepiccredits, 
			name, 
			practice_hours_per_week, 
			theory_hours_per_week, 
			formation_area_id,
			semester_id
			)
			SELECT 
			satcacredits,
			tepiccredits,
			name,
			practice_hours_per_week, 
			theory_hours_per_week, 
			formation_area_id,
			(SELECT id FROM semester 
				WHERE study_plan_id = new_study_plan_id 
				AND semester_number = semesterNumber
			)
			FROM learning_unit 
			WHERE semester_id = (
				SELECT id FROM semester 
				WHERE study_plan_id = studyPlan_id 
				AND semester_number = semesterNumber
			);
		END LOOP;

		RETURN NULL;
	END;
$BODY$
LANGUAGE plpgsql;

ALTER FUNCTION copy_learningUnitstostudyplan(integer, integer)
	owner to postgres;
 