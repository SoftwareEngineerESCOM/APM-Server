package com.apms.learningUnitStatus;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class LearningUnitStatus {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    public LearningUnitStatus() {
        
    }
}
