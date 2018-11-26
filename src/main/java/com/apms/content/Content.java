package com.apms.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.syntheticProgram.SyntheticProgram;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int number;

	// @ManyToOne
	// @JoinColumn(nullable = false)
	// private SyntheticProgram syntheticProgram;

	public Content() {
	}
}
