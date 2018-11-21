package com.apms.bibliographyRelation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.bibliographyType.BibliographyType;
import com.apms.bibliography.Bibliography;
import com.apms.learningUnit.LearningUnit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BibliographyRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(nullable = false)
	private boolean isClassic;
	@Column(nullable = false)
	private Integer number;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private LearningUnit learningUnit;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Bibliography bibliography;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private BibliographyType bibliographyType;

    public BibliographyRelation() {
        
    }
}
