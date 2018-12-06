package com.apms.document;

import java.util.HashMap;

public class EtiquetasPrueba {
    private HashMap<String,String> etiquetas;

    public EtiquetasPrueba() {
        etiquetas = new HashMap<>();
        etiquetas.put("academic_unit", "Escuela Superior de Cómputo");
        etiquetas.put("academic_program", "Escuela Superior de Cómputo");
        etiquetas.put("learning_unit", "Ingenieria de Software");
        etiquetas.put("semester", "6");
        etiquetas.put("purpose_learning_unit", "Elabora un sistema computacional de propósito específico con base en metodologías de Ingeniería de Software");
        etiquetas.put("contents", "I. Ingeniería de Software\n" +
            "II. Proceso de gestión de proyecto\n" +
            "III. Metodologías\n" +
            "IV. Calidad y normas de calidad\n" +
            "V.	Modelos de Madurez\n" +
            "VI. Temas selectos");
        etiquetas.put("didactic_orientation", "La presente unidad se abordará a partir de la estrategia aprendizaje orientada a proyectos, el docente conducirá  el curso con el método heurístico, se realizarán actividades de indagación, análisis y diseño para seleccionar la metodología adecuada al sistema de información que se quiera implementar, aplicando un enfoque de calidad; utilizando herramientas CASE para facilitar el diseño de los diagramas UML, exposiciones, prácticas y la realización de un proyecto en equipo que integre los conceptos generales así como las competencias referentes al uso de patrones de diseño y el manejo las normas calidad del software.\n" +
            "Las actividades que se realizarán en clase fomentarán en los estudiantes algunas técnicas, tales como: trabajo colaborativo y participativo, lluvia de ideas, organizadores gráficos, indagación documental, fichas de trabajo, exposición de temas complementarios, discusión dirigida así como la realización de un proyecto.\n" +
            "Para ello el docente dentro de la planeación establecerá las actividades de aprendizaje a desarrollar y los tiempos para entrega por parte del alumno; así mismo marcara los tiempos de revisión para hacer las observaciones y anotaciones para que el alumno pueda mejorar su aprendizaje, además de establecer las características del proyecto realizado.");
        etiquetas.put("evaluation_and_accreditation", "La presente Unidad de Aprendizaje se evaluará a partir del portafolio de evidencias, el cual se conforma de: evaluación formativa, sumativa y rubricas de autoevaluación y coevaluación.\n" +
            "Esta unidad de aprendizaje también se puede acreditar mediante:\n" +
            "•	Evaluación de saberes previamente adquiridos, con base en los lineamientos establecidos por la academia.\n" +
            "•	Acreditación en otra UA del IPN u otra institución educativa ó internacional.");
        etiquetas.put("bibliography", "•	García R., Félix O. (2008). Medición y estimación del software: Técnicas y Métodos para mejorar la calidad y la productividad. México: AlfaOmega. ISBN 9788478978588\n" +
            "•	Piattini M., Calvo-Manzano, J (2004). Análisis y diseño de aplicaciones informáticas de gestión. Una perspectiva de Ingeniería del Software. México: Alfaomega. ISBN 9701509870\n" +
            "•	Piattini, M., García, F. (2007) Calidad de Sistemas Informáticos. México: Alfaomega. ISBN 9789701512678\n" +
            "•	Pressman, S. (2005). Ingeniería del software: Un enfoque Práctico. México: Mc Graw Hill. ISBN 9701054733\n" +
            "•	Sommerville, I. (2008) Ingeniería de Software. España: Addison Wesley.ISBN 9789702602064");
        etiquetas.put("type_learning_unit", "Teórico – práctica");
        etiquetas.put("validity", "Agosto 2011");
        etiquetas.put("training_area", "Profesional");
        etiquetas.put("modality", "Presencial");
        etiquetas.put("credits", "33");
        etiquetas.put("educational_intention", "Esta unidad de aprendizaje contribuye al perfil de egresado de Ingeniería en Sistemas Computacionales, al desarrollar las habilidades de análisis y diseño de proyectos haciendo uso de software de gestión de proyectos así como herramientas CASE, además de integrar los principios de gestión de la calidad regidos por los estándares establecidos para asegurar, gestionar, auditar y certificar la calidad de procesos y productos informáticos así como también planificar y proyectar es estratégicamente (Recursos Hardware y Software, Recursos Humanos, componentes reutilizables) el desarrollo de proyectos de software. Así mismo, se dinamizan las competencias de pensamiento creativo, comunicación asertiva, trabajo colaborativo y participativo");
        etiquetas.put("week_theory_hours", "3.0");
        etiquetas.put("week_practice_hours", "1.5");
        etiquetas.put("semester_theory_hours", "54");
        etiquetas.put("semester_practice_hours", "27");
        etiquetas.put("autonomous_learning_hours", "54");
        etiquetas.put("total_semester_hours", "81");
        etiquetas.put("learning_unit_designed_redesigned", "Academia de Ingeniería de Software");
        etiquetas.put("revised_by_ch", "Dr. Flavio Arturo Sánchez Garfias Subdirección Académica");
        etiquetas.put("first_approved_by_ch", "Consejo Tecnico Consultivo Escolar.");
        etiquetas.put("person_approves_ch", "Ing. Apolinar Francisco Cruz Lázaro Presidente del CTCE.");
        etiquetas.put("first_approved_date_ch", "");
        etiquetas.put("second_approved_by_ch", "Comisión de Programas Académicos del Consejo General Consultivo del IPN. 2011");
        etiquetas.put("second_approved_date_ch", "");
        etiquetas.put("authorized_validated_by_ch", "Ing. Rodrigo de Jesús Serrano Domínguez\n Secretario Técnico de la Comisión de Programas Académicos");
        etiquetas.put("academy", "Academia");
        
    }

    public HashMap<String, String> getEtiquetas() {
        return etiquetas;
    }
}
