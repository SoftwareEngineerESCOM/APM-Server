package com.apms.bibliography;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.apms.author.Author;
import com.apms.country.Country;

import com.apms.thematicUnit.ThematicUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bibliography {
	@Id
	@Column(nullable = false, unique = true)
	private String ISBN;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private int publicationYear;
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private List<Author> authors = new ArrayList<Author>(3);
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Country publicationPlace;

	@Column(nullable = false)
	private String editorial;

	@ManyToMany
	@JoinColumn(nullable = false)
	private List<ThematicUnit> thematicUnits;

	public Bibliography() {
	}
	
	public String getBibliographyCitation() {
		String bibliographyC = "";
		//Authors
		for (int i = 0; i < authors.size(); i++) {
			Author author = authors.get(i);
			bibliographyC += author.getParentalSurname() + " "
					+ author.getParentalSurname() + ", ";
			String[] names = author.getName().split(" ");
			for (String name : names)
				bibliographyC += name.charAt(0) + ". ";
			if(i+1 < authors.size())
				bibliographyC += ", ";
		}
		
		bibliographyC += "(" + publicationYear + ") "
				+ title + ", " //Titulo en cursivas
				+ getPublicationPlace().getName() + ". "
				+ editorial + ". "
				+ "ISBN: " + ISBN;
		
		return bibliographyC;
	}
}
