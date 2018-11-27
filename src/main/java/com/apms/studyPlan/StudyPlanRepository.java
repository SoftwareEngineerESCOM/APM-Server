package com.apms.studyPlan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPlanRepository extends JpaRepository<StudyPlan, Integer> {
	@Query(value = "SELECT * FROM study_plan WHERE academic_program_id = :id ORDER BY id DESC", nativeQuery = true)
	List<StudyPlan> getStudyPlansByAcademicProgramId(@Param("id") Integer Id);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO semester (semester_number, study_plan_id) SELECT semester_number, :new_study_plan_id	FROM semester WHERE study_plan_id = :studyplan_id", nativeQuery = true)
	void setSemestersToCopy(@Param("studyplan_id") Integer studyplan_id, @Param("new_study_plan_id") Integer new_study_plan_id);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO learning_unit (satcacredits, tepiccredits, name, practice_hours_per_week, theory_hours_per_week, formation_area_id, semester_id) SELECT satcacredits, tepiccredits, name, practice_hours_per_week, theory_hours_per_week, formation_area_id, (SELECT id FROM semester WHERE study_plan_id = :new_study_plan_id AND semester_number = :semesternumber) FROM learning_unit WHERE semester_id = (SELECT id FROM semester WHERE study_plan_id = :studyplan_id AND semester_number = :semesternumber)", nativeQuery = true)
	void setLearningUnitsToCopy(@Param("studyplan_id") Integer studyplan_id, @Param("new_study_plan_id") Integer new_study_plan_id, @Param("semesternumber") Integer semesternumber);

	@Nullable
	@Query(value = "SELECT * FROM study_plan WHERE status_study_plan_id IN (SELECT id FROM status_study_plan WHERE id = 1 OR id = 2 OR id = 3) AND academic_program_id = :id LIMIT 1", nativeQuery = true)
	StudyPlan getNewStudyPlan(@Param("id") Integer id);
}
