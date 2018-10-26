package com.apms.autor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apms.bibliografia.Bibliografia;

@Entity
@Table(name = "Autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "primerApellido")
	private String primerApellido;

	@ManyToMany(mappedBy = "autores")
	private Set<Bibliografia> bibliografias = new HashSet<Bibliografia>();

}
