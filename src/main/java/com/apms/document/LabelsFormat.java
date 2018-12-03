package com.apms.document;

import java.util.List;
import java.util.HashMap;

import com.apms.accreditationType.AccreditationType;
import com.apms.bibliography.Bibliography;
import com.apms.bibliographyRelation.BibliographyRelation;
import com.apms.content.Content;
import com.apms.evaluationUA.EvaluationUA;
import com.apms.extensiveProgram.ExtensiveProgram;
import com.apms.studyPlan.StudyPlan;
import com.apms.syntheticProgram.SyntheticProgram;

public class LabelsFormat {
	
	public static HashMap<String,String> createSyntheticProgramLabels(SyntheticProgram syntheticProgram){
		HashMap<String,String> dataLabels = new HashMap<>();
		dataLabels.put("learning_unit", syntheticProgram.getLearningUnit().getName());
		dataLabels.put("semester", syntheticProgram.getLearningUnit().getSemester().getSemesterNumber() + "");
		dataLabels.put("purpose_learning_unit", syntheticProgram.getRegard()); //PURPOSE LEARNING UNIT
		//CONTENTS - TEMATIC UNITS
		String contents = "";
		for (Content content : syntheticProgram.getContent())
			contents += content.getName() + "\\\\";
		dataLabels.put("contents", contents);
		
		dataLabels.put("didactic_orientation", syntheticProgram.getDidacticOrientation());
		//EVALUATION AND ACREDITATION
		String evaluationAndAccreditation = "";
		for (EvaluationUA evaluationUA : syntheticProgram.getEvaluationAccreditationUA().getEvaluationUA())
			evaluationAndAccreditation += evaluationUA.getName() + "\\\\";
		for (AccreditationType accreditationType : syntheticProgram.getEvaluationAccreditationUA().getAccreditationType())
			evaluationAndAccreditation += accreditationType.getName() + "\\\\";
		dataLabels.put("evaluation_and_accreditation", evaluationAndAccreditation);
		
		return dataLabels;
	}
	
	public static HashMap<String,String> createStudyPlanLabels(StudyPlan studyPlan){
		HashMap<String,String> dataLabels = new HashMap<>();
		dataLabels.put("academic_unit", studyPlan.getAcademicProgram().getWorkplace().getName());
		dataLabels.put("academic_program", studyPlan.getAcademicProgram().getName());
		
		
		return dataLabels;
	}
	
	public static HashMap<String,String> createExtensiveProgramLabels(ExtensiveProgram extensiveProgram){
		HashMap<String,String> dataLabels = new HashMap<>();
		
		return dataLabels;
	}
	
	public static HashMap<String,String> createBibliographyLabels(List<BibliographyRelation> bibliographiesR){
		HashMap<String,String> dataLabels = new HashMap<>();
		//BIBLIOGRAPHIES
		String bibliographies = "";
		//Revisar el limite de bibliografias de primera hoja y el tipo de bibliografias
		for (BibliographyRelation bibliographyR : bibliographiesR)
			bibliographies += bibliographyR.getBibliography().getBibliographyCitation() + "\\\\";
		dataLabels.put("bibliography", bibliographies);
		
		return dataLabels;
	}
	
	public static HashMap<String,String> createThematicUnitLabels(){
		HashMap<String,String> dataLabels = new HashMap<>();
		
		return dataLabels;
	}
	
}
