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

	public Autor() {
		super();
	}

	public Autor(String nombre, String primerApellido, Set<Bibliografia> bibliografias) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.bibliografias = bibliografias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public Set<Bibliografia> getBibliografias() {
		return bibliografias;
	}

	public void setBibliografias(Set<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}

}
