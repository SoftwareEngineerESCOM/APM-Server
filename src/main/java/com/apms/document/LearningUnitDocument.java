package com.apms.document;

import java.util.logging.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.apms.bibliographyRelation.BibliographyRelation;
import com.apms.extensiveProgram.ExtensiveProgram;
import com.apms.learningUnit.LearningUnit;
import com.apms.practiceRelation.PracticeRelation;
import com.apms.studyPlan.StudyPlan;
import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.syntheticProgram.SyntheticProgramService;
import com.apms.thematicUnit.ThematicUnit;

public class LearningUnitDocument {
	private LearningUnit learningUnit;
	private SyntheticProgram syntheticProgram; 
	private StudyPlan studyPlan; 
	private ExtensiveProgram extensiveProgram; 
	private List<BibliographyRelation> bibliographysRelation; 
	private List<ThematicUnit> thematicUnits; 
	private PracticeRelation practiceRelation;
	private final File firstSection = new File("src/main/resources/document_latex/learning_unit_document/first_part_document.tex");
    private final File secondSectionTemplate = new File("src/main/resources/document_latex/learning_unit_document/second_part_document_template.tex");
    private final File secondSection = new File("src/main/resources/document_latex/learning_unit_document/second_part_document.tex");
    private final File thirdSection = new File("src/main/resources/document_latex/learning_unit_document/third_part_document.tex");
    private final Pattern regex = Pattern.compile("<(.*?)>");
    private final String url = "src/main/resources/document_latex/FormatoUnidadAcademica.pdf";
    private HashMap<String,String> dataLabels;
    private String content;
    private int numberUnits;

	private SyntheticProgramService syntheticProgramService;
        
    public LearningUnitDocument(LearningUnit learningUnit, SyntheticProgram syntheticProgram, StudyPlan studyPlan,
			ExtensiveProgram extensiveProgram, List<BibliographyRelation> bibliographysRelation,
			List<ThematicUnit> thematicUnits, PracticeRelation practiceRelation) {
		this.learningUnit = learningUnit;
		this.syntheticProgram = syntheticProgram;
		this.studyPlan = studyPlan;
		this.extensiveProgram = extensiveProgram;
		this.bibliographysRelation = bibliographysRelation;
		this.thematicUnits = thematicUnits;
		this.practiceRelation = practiceRelation;
		this.numberUnits = syntheticProgram.getContent().size(); //Numero de unidades tematicas
	}

	public String getUrl() {
    	return url;
    }
    
    public void createDocument() throws IOException{
    	this.content = "";
    	fillDataLabels();
    	editSecondSectionTemplate();
    	replaceLabelsInfo(firstSection); //Llenar datos primera seccion
    	replaceLabelsInfo(secondSection); //Llenar datos segunda seccion
    	replaceLabelsInfo(thirdSection); //Llenar datos tercera seccion
        FileWriter writer = new FileWriter("src/main/resources/document_latex/FormatoUnidadAcademica.tex"); //Salida del documento
        writer.write(content);
        writer.close();
        ejecutarCMD("pdflatex -interaction nonstopmode src/main/resources/document_latex/FormatoUnidadAcademica.tex --output-directory=src/main/resources/document_latex/");
    }
    
    private void fillDataLabels() {
    	dataLabels = new HashMap<>();
    	System.out.println("Aqui andamosh");
    	
    	dataLabels.putAll(LabelsFormat.createSyntheticProgramLabels(syntheticProgram));
    	dataLabels.putAll(LabelsFormat.createStudyPlanLabels(studyPlan));
    	dataLabels.putAll(LabelsFormat.createExtensiveProgramLabels(extensiveProgram));
    	dataLabels.putAll(LabelsFormat.createBibliographyLabels(bibliographysRelation));
    	dataLabels.putAll(LabelsFormat.createThematicUnitLabels(thematicUnits));
    	dataLabels.putAll(LabelsFormat.createPracticeRelationLabels(practiceRelation));	
    }

    private void replaceLabelsInfo(File file) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        Matcher regexMatcher;
        while (line != null){
            List<String> matchList = new ArrayList<>();
            regexMatcher  = regex.matcher(line);

            while (regexMatcher.find()) //Finds Matching Pattern in String
                matchList.add(regexMatcher.group(1)); //Fetching Group from String

            for (String match : matchList) {
                System.out.println("Match: " + match);
                if(dataLabels.get(match) != null)
                	line = line.replaceFirst("<" + match + ">", dataLabels.get(match));
                else
                	line = line.replaceFirst("<" + match + ">", "S/I");
            }
            this.content += line + System.lineSeparator();
            line = reader.readLine();
        }
        reader.close();
    }
    
    private void editSecondSectionTemplate() throws IOException{
        //SE NECESITARA RECUPERAR EL NUMERO DE UNIDADES DE LA MATERIA
        String contentTemplate = "";
        //Creacion de etiquetas para todas las uniades
        for (int unit = 1; unit <= numberUnits; unit++) {
            BufferedReader reader = new BufferedReader(new FileReader(secondSectionTemplate));
            String line = reader.readLine();
            Matcher regexMatcher;
            while (line != null){
                List<String> matchList = new ArrayList<>();
                regexMatcher  = regex.matcher(line);

                while (regexMatcher.find()) //Finds Matching Pattern in String
                    matchList.add(regexMatcher.group(1)); //Fetching Group from String

                for (String match : matchList) {
                    if(match.contains("#")){
                        String newLabel = match.replace("#", unit + "");
                        line = line.replaceFirst("<" + match + ">", "<" + newLabel + ">");
                    } else{
                        line = line.replaceFirst("<" + match + ">", dataLabels.get(match));
                    }
                }
                contentTemplate += line + System.lineSeparator();
                line = reader.readLine();
            }
            reader.close();
        }
        FileWriter writer = new FileWriter(secondSection);
        writer.write(contentTemplate);
        writer.close();
    }
    
    private void ejecutarCMD(String cmd){
        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine())!= null) {
                System.out.println(line);
            }
            reader.close();
            p.waitFor();
        } catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);            
        }
    }
}
