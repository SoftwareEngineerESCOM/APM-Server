package com.apms.bibliography;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.bibliographyType.BibliographyType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bibliography {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String ISBN;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private int publicationYear;
	@Column(nullable = false)
	private String publicationPlace;
	@ManyToOne
	@JoinColumn(nullable = false)
	private BibliographyType bibliographyType;

	public Bibliography() {
	}
}
