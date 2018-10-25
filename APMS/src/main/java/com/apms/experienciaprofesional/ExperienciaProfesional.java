package com.apms.experienciaprofesional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apms.perfildocente.PerfilDocente;


@Entity
@Table(name="ExperienciaProfesional")
public class ExperienciaProfesional implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(mappedBy = "experienciasProfesionales")
    private Set<PerfilDocente> perfilesDocentes = new HashSet<PerfilDocente>();
	
	@Column(name="Nombre")
	private String nombre;

	public ExperienciaProfesional() {	
	
	}

	public ExperienciaProfesional(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public ExperienciaProfesional(Set<PerfilDocente> perfilesDocentes, String nombre) {
		super();
		this.perfilesDocentes = perfilesDocentes;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<PerfilDocente> getPerfilesDocentes() {
		return perfilesDocentes;
	}

	public void setPerfilesDocentes(Set<PerfilDocente> perfilesDocentes) {
		this.perfilesDocentes = perfilesDocentes;
	}

	@Override
	public String toString() {
		return "{ id:" + id + ", nombre:" + nombre + "}";
	}
}
