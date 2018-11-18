package com.apms.bibliographyType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class BibliographyType{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
    private boolean isClassic;
    
    public BibliographyType(){
    }
}
