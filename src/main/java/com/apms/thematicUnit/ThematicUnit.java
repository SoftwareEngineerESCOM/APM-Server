package com.apms.thematicUnit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import com.apms.bibliography.Bibliography;
import com.apms.content.Content;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ThematicUnit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
	@Column(nullable = false)
	private String comptetitiveUnit;
	@Column(nullable = false)
	private String learningEstrategy;
    @OneToOne
    @JoinColumn(nullable=false)
    private Content content; 
    @ManyToMany
    private List<Bibliography> bibliography;
    
    public ThematicUnit(){
    }
}
