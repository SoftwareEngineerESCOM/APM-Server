package com.apms.academy;

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
public class Academy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Workplace workplace;
    
	public Academy(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Academy() {
		
	}
        
}
