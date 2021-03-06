package com.apms.document;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.apms.accreditationType.AccreditationType;
import com.apms.bibliographyRelation.BibliographyRelation;
import com.apms.content.Content;
import com.apms.evaluationSystem.EvaluationSystem;
import com.apms.evaluationUA.EvaluationUA;
import com.apms.extensiveProgram.ExtensiveProgram;
import com.apms.learningEvaluation.LearningEvaluation;
import com.apms.practice.Practice;
import com.apms.practiceRelation.PracticeRelation;
import com.apms.studyPlan.StudyPlan;
import com.apms.subtopic.Subtopic;
import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.teachingProfile.TeachingProfile;
import com.apms.thematicUnit.ThematicUnit;
import com.apms.topic.Topic;



public class LabelsFormat {
	
	public static HashMap<String,String> createSyntheticProgramLabels(SyntheticProgram syntheticProgram){
		HashMap<String,String> dataLabels = new HashMap<>();
		dataLabels.put("learning_unit", syntheticProgram.getLearningUnit().getName());
		dataLabels.put("semester", syntheticProgram.getLearningUnit().getSemester().getSemesterNumber() + "");
		dataLabels.put("purpose_learning_unit", syntheticProgram.getRegard());
		
		//CONTENTS - TEMATIC UNITS
		String contents = "";
		for (Content content : syntheticProgram.getContent())
			contents += "\\\\item " + content.getName() + "\n";
		dataLabels.put("contents", contents);
		
		dataLabels.put("didactic_orientation", syntheticProgram.getDidacticOrientation());
		
		//EVALUATION AND ACREDITATION
		String evaluationAndAccreditation = "";
		String accreditation = "";
		for (EvaluationUA evaluationUA : syntheticProgram.getEvaluationAccreditationUA().getEvaluationUA())
			evaluationAndAccreditation +=  "\\\\item " + evaluationUA.getName();
		for (AccreditationType accreditationType : syntheticProgram.getEvaluationAccreditationUA().getAccreditationType()) {
			accreditation += "\\\\item " + accreditationType.getName();
			evaluationAndAccreditation += "\\\\item " + accreditationType.getName();
		}
		dataLabels.put("evaluation_and_accreditation", evaluationAndAccreditation);
		dataLabels.put("accreditation", accreditation);
		
		dataLabels.put("training_area", syntheticProgram.getLearningUnit().getFormationArea().getName());
		
		//TEPIC SATCA CREDITS
		dataLabels.put("credits", syntheticProgram.getLearningUnit().getTEPICCredits() + " TEPIC - "
				+ syntheticProgram.getLearningUnit().getSATCACredits() + " SATCA");
		
		dataLabels.put("academy", syntheticProgram.getLearningUnit().getAcademy().getName());
		
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
			types += extensiveProgram.getTypes().get(i).getName();
			if(i+1 < extensiveProgram.getTypes().size())
				types += " - ";
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
		
		//**TEACHER PROFILE INFO**//
		TeachingProfile teachingProfile = extensiveProgram.getTeachingProfile();
		
		//SCHOOLING GRADE INFO
		String schoolingGradeStr = "";
		String[] schoolingGrades = teachingProfile.getSchoolingGrades().split("\n"); //Separar cadena por algun simbolo
		for (int i = 0; i < schoolingGrades.length; i++) {
			schoolingGradeStr += schoolingGrades[i];
			if(i+1 < schoolingGrades.length) {
				if(i+2 < schoolingGrades.length)
					schoolingGradeStr += ", ";
				else
					schoolingGradeStr += " o ";
			}
		}
		dataLabels.put("specialty_and_academic_level_required", schoolingGradeStr);
		
		//KNOWLEDGES
		String knowledgesStr = "";
		String[] knowledges = teachingProfile.getKnowledges().split("\n"); //Separar cadena por algun simbolo
		for (String knowledge : knowledges) {
			knowledgesStr += "\\\\item " + knowledge; //Checar formato de latex ************
		}
		dataLabels.put("teacher_profile_knowledge", knowledgesStr);
		
		//EXPERIENCE PROFILE
		String professionalExperienceStr = "";
		String[] professionalExperiences = teachingProfile.getProfessionalExperiences().split("\n"); //Separar cadena por algun simbolo
		for (String professionalExperience : professionalExperiences) {
			professionalExperienceStr += "\\\\item " + professionalExperience; //Checar formato de latex ************
		}
		dataLabels.put("teacher_profile_experience", professionalExperienceStr);
		
		//COMPETENCES PROFILE
		String abilityStr = "";
		String[] abilities = teachingProfile.getAbility().split("\n"); //Separar cadena por algun simbolo
		for (String ability : abilities) {
			abilityStr += "\\\\item " + ability; //Checar formato de latex ************
		}
		dataLabels.put("teacher_profile_competence", abilityStr);
		
		//ATTITUDES PROFILE
		String attitudeStr = "";
		String[] attitudes = teachingProfile.getAttitude().split("\n"); //Separar cadena por algun simbolo
		for (String attitude : attitudes) {
			attitudeStr += "\\\\item " + attitude; //Checar formato de latex ************
		}
		dataLabels.put("teacher_profile_attitudes", attitudeStr);
		return dataLabels;
	}
	
	
	public static HashMap<String,String> createBibliographyLabels(List<BibliographyRelation> bibliographiesR){
		HashMap<String,String> dataLabels = new HashMap<>();
		//BIBLIOGRAPHIES FIRST PAGE
		String bibliographies = "";
		//LIMIT OF BIBLIOGRAPHIES IN FIRST PAGE = 5
		int limit = 0;
		for (BibliographyRelation bibliographyR : bibliographiesR) {
			if(bibliographyR.isClassic()) {
				bibliographies += "\\\\item " + bibliographyR.getBibliography().getBibliographyCitation();
				if(++limit == 5) 	//LIMIT
					break;
			}
		}
		dataLabels.put("bibliography", bibliographies);
		
		//BIBLIOGRAPHIES INFO PAGE
		String bibliographiesInfo = "";
		for (BibliographyRelation bibliographyR : bibliographiesR) {
			bibliographiesInfo += bibliographyR.getNumber() + "&";  //Revisar si se deben ordenar
			//ABBREVIATION
			if(bibliographyR.getBibliographyType().getAbbreviation().equals("B"))
				bibliographiesInfo += "X &  &";
			else
				bibliographiesInfo += " & X &";
			//BIBLIOGRAPHIE CITATIONS
			bibliographiesInfo += bibliographyR.getBibliography().getBibliographyCitation() + "\\\\\\\\ ";
		}
		dataLabels.put("bibliographies_info", bibliographiesInfo);
		
		return dataLabels;
	}
	
	//****CLAVES BIBLIOGRAFICAS FALTANTES****
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
			
			//***THEMATIC UNITS TABLE ***//
			String unitContentStr = "";
			//VARIABLES FOR THE TOTAL HOURS
			Double teacherTheoryHours = 0.0;
			Double teacherPracticeHours = 0.0;
			Double autonomousTheoryHours = 0.0;
			Double autonomousPracticeHours = 0.0;
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
					System.out.println("No se encontro el tema: " + unit + "." + index);
					continue;
				}
				
				unitContentStr += unit + "." + index + " & ";
				unitContentStr +=  topic.getName() + " & ";
				unitContentStr += topic.getTheoricHours() + " & ";
				unitContentStr += topic.getPracticalHours() + " & ";
				unitContentStr += topic.getAutonomousHours() + " & 0.0 &";
				unitContentStr += "Sin Clave"  + " \\\\\\\\ "; //Busqueda de claves bibliografias por clave
				//suma de las horas de aprendizaje
				teacherTheoryHours += topic.getTheoricHours();
				teacherPracticeHours += topic.getPracticalHours();
				autonomousTheoryHours += topic.getAutonomousHours();
				
				//SUBTOPICS IN ORDER
				if(topic.getSubtopics() != null) {
					List<Subtopic> subtopics = topic.getSubtopics();
					for (int subindex = 1; subindex <= subtopics.size(); subindex++) {
						Subtopic subtopic = null;
						for (Subtopic subtopicAux : subtopics) {
							if(subtopicAux.getNumber() == subindex) {
								subtopic = subtopicAux;
								break;
							}
						}
						if(subtopic == null) {
							System.out.println("No se encontro el subtema: " + unit + "." + index + "." + subindex);
							continue;
						}
						unitContentStr += unit + "." + index + "." + subindex + " & ";
						unitContentStr += subtopic.getName() + " & ";
						unitContentStr += " & ";
						unitContentStr += " & ";
						unitContentStr += " & ";
						unitContentStr += " & ";
						unitContentStr += " \\\\\\\\ ";
					}
				}
			}
			dataLabels.put("unit_contents_" + unit, unitContentStr);
			dataLabels.put("total_theoretical_hours_with_teacher_" + unit, teacherTheoryHours + "");
			dataLabels.put("total_practical_hours_with_teacher_" + unit, teacherPracticeHours + "");
			dataLabels.put("total_autonomous_theoretical_hours_" + unit, autonomousTheoryHours + "");
			dataLabels.put("total_autonomous_practice_hours_" + unit, autonomousPracticeHours + "");
			dataLabels.put("learning_strategies_" + unit, thematicUnit.getLearningStrategy());
			//****** EVALUACION DE LOS APRENDIZAJES
			String learningEvaluationStr = "";
			List<LearningEvaluation> learningEvaluationE = new ArrayList<>();
			List<LearningEvaluation> learningEvaluationC = new ArrayList<>();
			for (LearningEvaluation learningEvaluation : thematicUnit.getLearningEvaluations()) {
				if(learningEvaluation.getEvaluationType().equals("Escrita"))
					learningEvaluationE.add(learningEvaluation);
				else
					learningEvaluationC.add(learningEvaluation);
			}
			for (int i = 0; i < learningEvaluationE.size(); i++) {
				if(i == 0)
					learningEvaluationStr += "Evaluación escrita:";
				learningEvaluationStr += "\\\\newline " + learningEvaluationE.get(i).getName() + "\\\\tab[0.5cm] " + (learningEvaluationE.get(i).getPercentage()*100) + "\\\\% "; //Revisar tabulacion
			}
			for (int i = 0; i < learningEvaluationC.size(); i++) {
				if(i == 0)
					learningEvaluationStr += "\\\\newline Evaluación continua:";
				learningEvaluationStr += "\\\\newline " + learningEvaluationC.get(i).getName() + "\\\\tab[0.5cm] " + (learningEvaluationC.get(i).getPercentage()*100) + "\\\\% "; //Revisar tabulacion
			}
			dataLabels.put("evaluation_learning_" + unit, learningEvaluationStr);
			
			
		}
		
		//EVALUATION PROCEDURE TABLE
		String evaluationProcedureStr = "";
		for (int period = 1; period <= 3; period++) { //Ajustar a numero de periodos
			List<ThematicUnit> thematicUsPeriod = new ArrayList<>();
			// Unidad tematica ya no tiene como atributo ssistema de evaluacion, sistema de evaluacion
			//tiene unidad tematica
			/*for(ThematicUnit thematicUnit : thematicUnits) {
				if(thematicUnit.getEvaluationSystem().getPeriod() == period)
					thematicUsPeriod.add(thematicUnit);
			}*/
			if(thematicUsPeriod.isEmpty()) {
				//Periodo sin unidades tematicas
				continue;
			}
			evaluationProcedureStr += period + "&";
			List<Integer> units = new ArrayList<>();
			for (ThematicUnit thematicUnit : thematicUsPeriod) {
				if(!units.contains(thematicUnit.getContent().getNumber())) {
					units.add(thematicUnit.getContent().getNumber());  //Talvez ordenar las unidades tematicas
				}
			}
			for (int unit = 0; unit < units.size(); unit++) {
				evaluationProcedureStr += unit;
				if(unit+1 <= units.size())
					evaluationProcedureStr += ",";
				else
					evaluationProcedureStr += "&";
			}
			/*for (ThematicUnit thematicUnit : thematicUsPeriod) {
				evaluationProcedureStr += thematicUnit.getEvaluationSystem().getEvaluationProcedure() + "\\tab[0.5cm]" 
						+ thematicUnit.getEvaluationSystem().getPercentage() + "\\%\n\n"; //Revisar si sirven los saltos de linea				
			}*/
			evaluationProcedureStr += "\\\\";
		}
		dataLabels.put("evaluation_procedure_by_period", evaluationProcedureStr);
		
		return dataLabels;
	}
	
	
	public static HashMap<String,String> createEvualuationSystemLabels(List<EvaluationSystem> evaluationSystems){
		HashMap<String,String> dataLabels = new HashMap<>();
		String evaluationProcedureStr = "";
		
		//Llenar tabla Por Periodo y luego por unidades
		int period = 0;
		Double percentageP = 0.0;
		for (int unit = 1; unit <= evaluationSystems.size(); unit++) {
			//Encontrar unidades en orden
			EvaluationSystem evaluationSystem = null;
			for (EvaluationSystem evaluationSystemAux : evaluationSystems) {
				if(evaluationSystemAux.getThematicUnit().getContent().getNumber() == unit) {
					evaluationSystem = evaluationSystemAux;
					break;
				}
			}
			if(evaluationSystem == null) {
				continue;
			}
			//Revisar si es nuevo periodo
			if(evaluationSystem.getPeriod() != period) {
				if(period == 1) {
					dataLabels.put("period_percentage_1", String.format("%.0f" , (percentageP*100)));
				}else if(period == 2) {
					dataLabels.put("period_percentage_2", String.format("%.0f" , (percentageP*100)));
				}
				period++;
				percentageP = 0.0;
				evaluationProcedureStr += period + " & ";
			} else {
				evaluationProcedureStr += " & ";
			}
			
			evaluationProcedureStr += " \\\\RNum{" + unit + "} & ";
			
			List<LearningEvaluation> learningEvaluations = evaluationSystem.getThematicUnit().getLearningEvaluations();
			//Sumar porcentajes por unidad
			Double escrita = 0.0, continua = 0.0;
			for (LearningEvaluation learningEvaluation : learningEvaluations) {
				if(learningEvaluation.getEvaluationType().equals("Escrita"))
					escrita += learningEvaluation.getPercentage();
				else
					continua += learningEvaluation.getPercentage();
			}
			//Escribir porcentajes
			if(continua != (0.0))
				evaluationProcedureStr += "Evaluación Continua \\\\tab[1.15cm] " + String.format("%.0f" , (continua*100)) + "\\\\% \\\\newline ";
			if(escrita != (0.0))
				evaluationProcedureStr += "Evidencia de Aprendizaje \\\\tab[0.5cm] " + String.format("%.0f" , (escrita*100)) + "\\\\% ";
			evaluationProcedureStr += "\\\\\\\\ ";
			percentageP += evaluationSystem.getPercentage();
		}
		dataLabels.put("period_percentage_3", String.format("%.0f" , (percentageP*100)));
		dataLabels.put("evaluation_procedure_by_period", evaluationProcedureStr);
		return dataLabels;
	}
	
	
	
	public static HashMap<String,String> createPracticeRelationLabels(PracticeRelation practiceRelation){

		HashMap<String,String> dataLabels = new HashMap<>();
		//**PRACTICES TABLE**//
		String practicesTableStr = "";
		List<Practice> practices = practiceRelation.getPractices();
		for (int numPractice = 1; numPractice <= practices.size(); numPractice++) {
			Practice practice = null;
			for (Practice practiceAux : practices) {
				if(practiceAux.getNumber() == numPractice) {
					practice = practiceAux;
					break;
				}
			}
			if(practice == null) {
				System.out.println("No se encontro la practica no: " + numPractice);
				continue;
			}
			practicesTableStr += practice.getNumber() + "&"; //PRACTICE NUMBER
			practicesTableStr += practice.getName() + "&"; //PRACTICE NAME
			practicesTableStr += "\\\\RNum{" + practice.getThematicUnit().getContent().getNumber() + "} &"; //PRACTICE THEMATIC UNIT NUMBER **pasar a numeros romanos 
			practicesTableStr += practice.getLength() + "&"; //PRACTICE LENGHT
			practicesTableStr += practiceRelation.getPlaceOfPractice() + "\\\\\\\\"; //PRACTICE PLACE
		}
		dataLabels.put("practice_relationship", practicesTableStr);
		
		dataLabels.put("total_hours_practices", practiceRelation.getTotalHours() + "");
		
		//EVALUATION AND ACCREDITATION PRACTICES
		String practiceREStr = "";
		String[] practiceEA = practiceRelation.getAccreditation().split("\n");
		for (String line : practiceEA) {
			line = line.replace("%", "\\\\%");
			practiceREStr += line + "\\\\newline "; //Revisar formato de porcentajes y texto
		}
		dataLabels.put("evaluation_and_accreditation_practices", practiceREStr);
		
		return dataLabels;
	}
	
	
}
