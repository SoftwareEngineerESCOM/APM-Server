package com.apms.document;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.apms.extensiveProgram.ExtensiveProgramService;
import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.syntheticProgram.SyntheticProgramService;

public class LearningUnitDocument {
	private SyntheticProgram syntheticProgram;
	private final File firstSection = new File("src/main/resources/document_latex/learning_unit_document/first_part_document.tex");
    private final File secondSectionTemplate = new File("src/main/resources/document_latex/learning_unit_document/second_part_document_template.tex");
    private final File secondSection = new File("src/main/resources/document_latex/learning_unit_document/second_part_document.tex");
    private final File thirdSection = new File("src/main/resources/document_latex/learning_unit_document/third_part_document.tex");
    private final Pattern regex = Pattern.compile("<(.*?)>");
    private HashMap<String,String> dataLabels;
    private int numberUnits;
    private String content;
    
    //Services
    private ExtensiveProgramService extensiveProgramService;
    
    private HashMap<String,String> fillDocumentLabels(){
        return null;
    }

    public LearningUnitDocument() {
        this.dataLabels = new HashMap();
        this.content = "";
        EtiquetasPrueba ep = new EtiquetasPrueba();
        this.dataLabels = ep.getEtiquetas();
        numberUnits = 3;
    }
    
    public LearningUnitDocument(SyntheticProgram syntheticProgram) {
        this.syntheticProgram = syntheticProgram;
    	this.dataLabels = new HashMap();
        this.numberUnits = 0;
        this.content = "";
    }
    
    public void createDocument() throws IOException{
    	fillDataLabels();
        EtiquetasPrueba ep = new EtiquetasPrueba();
        this.dataLabels = ep.getEtiquetas();
        createFirstSection();
        createSecondSection();
        createThirdSection();
        FileWriter writer = new FileWriter("src/main/resources/document_latex/FormatoUnidadAcademica.tex"); //Salida del documento
        writer.write(content);
        writer.close();
        ejecutarCMD("pdflatex -interaction nonstopmode src/main/resources/document_latex/FormatoUnidadAcademica.tex --output-directory=src/main/resources/document_latex/");
    }
    
    private void fillDataLabels() {
    	dataLabels.putAll(LabelsFormat.createSyntheticProgramLabels(syntheticProgram));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createFirstSection() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(firstSection));
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
    
    private void createSecondSection() throws FileNotFoundException, IOException{
        editSecondSectionTemplate();
        //Llenar los labels con los datos de las unidades
        HashMap<String,String> dataUnitsLabels = new HashMap<>();
        //agregar funcion fillUnitLabels conforme al formato de sus etiquetas
        BufferedReader reader = new BufferedReader(new FileReader(secondSection));
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
    
    private void createThirdSection() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(thirdSection));
        //Las etiquetas en esta parte se deberan crear con cierto formato
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
    
    public static void main(String[] args) {
        LearningUnitDocument lum = new LearningUnitDocument();
        try {
            lum.createDocument();
        } catch (IOException ex) {
            ex.toString();
        }
    }
}
