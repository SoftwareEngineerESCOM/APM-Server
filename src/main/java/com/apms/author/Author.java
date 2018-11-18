package com.apms.author;

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

public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    @Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String parentalSurname;
	@Column(nullable = false)
	private String maternalSurname;
	
    public Author(){
    }
}
