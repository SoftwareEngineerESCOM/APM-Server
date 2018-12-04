package com.apms.document;

import java.util.List;
import java.util.HashMap;

import com.apms.accreditationType.AccreditationType;
import com.apms.bibliographyRelation.BibliographyRelation;
import com.apms.content.Content;
import com.apms.evaluationUA.EvaluationUA;
import com.apms.extensiveProgram.ExtensiveProgram;
import com.apms.studyPlan.StudyPlan;
import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.thematicUnit.ThematicUnit;
import com.apms.topic.Topic;



public class LabelsFormat {
	//dataLabels.put("", );
	
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
		dataLabels.put("training_area", syntheticProgram.getLearningUnit().getFormationArea().getName());
		//TEPIC SATCA CREDITS
		dataLabels.put("credits", syntheticProgram.getLearningUnit().getTEPICCredits() + " TEPIC - "
				+ syntheticProgram.getLearningUnit().getSATCACredits() + " SATCA");
		
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
		//TYPE LEARNING UNIT
		String types = "";
		for (int i = 0; i < extensiveProgram.getTypes().size(); i++) {
			types += extensiveProgram.getTypes().get(i);
			if(i+1 < extensiveProgram.getTypes().size())
				types += "-";
		}
		
		dataLabels.put("type_learning_unit", types);
		dataLabels.put("validity", extensiveProgram.getValidity() + "");
		dataLabels.put("modality", extensiveProgram.getModality().getName());
		dataLabels.put("educational_intention", extensiveProgram.getEducationalIntention());
		dataLabels.put("week_theory_hours", extensiveProgram.getAssignedTime().getTheoreticalHourWeek() + "");
		dataLabels.put("week_practice_hours", extensiveProgram.getAssignedTime().getPracticeHourWeek() + "");
		dataLabels.put("semester_theory_hours", extensiveProgram.getAssignedTime().getTheoreticalHourSemester() + "");
		dataLabels.put("semester_practice_hours", extensiveProgram.getAssignedTime().getPracticeHourSemester() + "");
		dataLabels.put("autonomous_learning_hours", extensiveProgram.getAssignedTime().getAutomaticTeaching() + "");
		dataLabels.put("total_semester_hours", extensiveProgram.getAssignedTime().getTotalSemsterHour() + "");
		
		
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
	
	public static HashMap<String,String> createThematicUnitLabels(List<ThematicUnit> thematicUnits){
		HashMap<String,String> dataLabels = new HashMap<>();
		//THEMATIC UNITS IN ORDER
		for (int unit = 1; unit <= thematicUnits.size(); unit++) {
			ThematicUnit thematicUnit = null;
			for (ThematicUnit auxTU : thematicUnits) {
				if(auxTU.getContent().getNumber() == unit) {
					thematicUnit = auxTU;
					break;
				}
			}
			if(thematicUnit == null) {
				System.out.println("No se encontro la Unidad Tematica: " + unit);
				continue;
			}
			dataLabels.put("thematic_unit_no_" + unit, unit + ""); //PONER EN NUMEROS ROMANOS
			dataLabels.put("thematic_unit_" + unit, thematicUnit.getContent().getName());
			dataLabels.put("competence_unit_" + unit, thematicUnit.getCompetenceUnit());
			
			/* THEMATIC UNITS TABLE */
			String contentNumbers = "";
			String contents = "";
			String teacherTheoryHours = "";
			String teacherPracticeHours = "";
			String autonomousTheoryHours = "";
			String autonomousPracticeHours = "";
			String bibliographicKeys = "";
			//TOPICS IN ORDER
			List<Topic> topics = thematicUnit.getTopics();
			for (int index = 1; index <= topics.size(); index++) {
				Topic topic = null;
				for (Topic topicAux : topics) {
					if(Integer.parseInt(topicAux.getNumber()) == index) { //Revisar oportunidad de cambio de topic.getNumber() de String a int
						topic = topicAux;
						break;
					}
				}
				if(topic == null) {
					System.out.println("No se encontro el tema: " + unit);
					continue;
				}
				
				contentNumbers += unit + "." + index;
				contents +=  topic.getName();
			}
			//dataLabels.put("" + unit, );
			
		}
		
		return dataLabels;
	}
	
}
