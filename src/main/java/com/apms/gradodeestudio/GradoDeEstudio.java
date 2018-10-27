package com.apms.gradodeestudio;

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
@Table(name="GradoDeEstudio")
public class GradoDeEstudio implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(mappedBy = "gradosDeEstudio")
    private Set<PerfilDocente> perfilesDocentes = new HashSet<PerfilDocente>();
	
	@Column(name="NivelAcademico")
	private String nivelAcademico;
	
	@Column(name="Especialidad")
	private String especialidad;

	public GradoDeEstudio() {
	}
	
	public GradoDeEstudio(String nivelAcademico, String especialidad) {
		super();
		this.nivelAcademico = nivelAcademico;
		this.especialidad = especialidad;
	}

	public GradoDeEstudio(Set<PerfilDocente> perfilesDocentes, String nivelAcademico, String especialidad) {
		super();
		this.perfilesDocentes = perfilesDocentes;
		this.nivelAcademico = nivelAcademico;
		this.especialidad = especialidad;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Set<PerfilDocente> getPerfilesDocentes() {
		return perfilesDocentes;
	}

	public void setPerfilesDocentes(Set<PerfilDocente> perfilesDocentes) {
		this.perfilesDocentes = perfilesDocentes;
	}

	@Override
	public String toString() {
		return "{ id:" + id + ", nivelAcademico:" + nivelAcademico + ", especialidad:" + especialidad + "}";
	}
	

}
