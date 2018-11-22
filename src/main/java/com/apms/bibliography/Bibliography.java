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

	public Bibliography() {
	}
}
