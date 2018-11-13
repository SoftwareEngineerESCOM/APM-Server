package com.apms.StudyPlanMode;

import javax.persistence.*;

@Entity
public class StudyPlanMode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    public StudyPlanMode() {
    }
}