package com.apms.academicProgram;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.workplace.Workplace;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AcademicProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String titleName;
    @ManyToOne
	@JoinColumn(nullable = false)
    private Workplace workplace;
    

    public AcademicProgram() {
        
    }
}