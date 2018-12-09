package com.apms.learningUnit;

import com.apms.academy.Academy;
import com.apms.formationArea.FormationArea;
import com.apms.learningUnitStatus.LearningUnitStatus;
import com.apms.semester.Semester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class LearningUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double TEPICCredits;
    @Column(nullable = false)
    private Double SATCACredits;
    @Column(nullable = false)
    private Double theoryHoursPerWeek;
    @Column(nullable = false)
    private Double practiceHoursPerWeek;
    @ManyToOne
    @JoinColumn(nullable = false)
    private FormationArea formationArea;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Semester semester;

    @ManyToOne
    @JoinColumn(nullable = true)
    private LearningUnitStatus learningUnitStatus;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Academy academy;

    public LearningUnit() {
    }
    public LearningUnit(Integer id, String name, Double tEPICCredits, Double sATCACredits, Double theoryHoursPerWeek,
                        Double practiceHoursPerWeek, FormationArea formationArea, Semester semester, Academy academy) {
        this.id = id;
        this.name = name;
        TEPICCredits = tEPICCredits;
        SATCACredits = sATCACredits;
        this.theoryHoursPerWeek = theoryHoursPerWeek;
        this.practiceHoursPerWeek = practiceHoursPerWeek;
        this.formationArea = formationArea;
        this.semester = semester;
        this.academy = academy;
    }

	@Override
	public String toString() {
		return "LearningUnit [id=" + id + ", name=" + name + ", TEPICCredits=" + TEPICCredits + ", SATCACredits="
				+ SATCACredits + ", theoryHoursPerWeek=" + theoryHoursPerWeek + ", practiceHoursPerWeek="
				+ practiceHoursPerWeek + ", formationArea=" + formationArea + ", semester=" + semester
				+ ", learningUnitStatus=" + learningUnitStatus + ", academy=" + academy + "]";
	}
