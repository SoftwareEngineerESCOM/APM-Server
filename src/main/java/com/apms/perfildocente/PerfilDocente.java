package com.apms.perfildocente;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apms.actitud.Actitud;
import com.apms.conocimiento.Conocimiento;
import com.apms.experienciaprofesional.ExperienciaProfesional;
import com.apms.gradodeestudio.GradoDeEstudio;
import com.apms.habilidad.Habilidad;
import com.apms.recursohumano.RecursoHumano;

@Entity
@Table(name="PerfilDocente")
public class PerfilDocente implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gradosDeEstudio_perfilDocente", joinColumns = @JoinColumn(name = "perfilDocenteId"), inverseJoinColumns = @JoinColumn(name = "gradosDeEstudiosId"))
	private Set<GradoDeEstudio> gradosDeEstudio = new HashSet<GradoDeEstudio>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "conociminetos_perfilDocente", joinColumns = @JoinColumn(name = "perfilDocenteId"), inverseJoinColumns = @JoinColumn(name = "conocimientosdId"))
	private Set<Conocimiento> conocimientos = new HashSet<Conocimiento>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "experienciasProfesionales_perfilDocente", joinColumns = @JoinColumn(name = "perfilDocenteId"), inverseJoinColumns = @JoinColumn(name = "experienciasProfesionalesId"))
	private Set<ExperienciaProfesional> experienciasProfesionales = new HashSet<ExperienciaProfesional>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "habilidades_perfilDocentes", joinColumns = @JoinColumn(name = "perfilDocenteId"), inverseJoinColumns = @JoinColumn(name = "hablidadesId"))
	private Set<Habilidad> habilidades = new HashSet<Habilidad>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "actitudes_perfilDocente", joinColumns = @JoinColumn(name = "perfilDocenteId"), inverseJoinColumns = @JoinColumn(name = "actitudesId"))
	private Set<Actitud> actitudes = new HashSet<Actitud>();
    
	public PerfilDocente() {
		
	}
	
	
	
	public Set<GradoDeEstudio> getGradosDeEstudio() {
		return gradosDeEstudio;
	}



	public void setGradosDeEstudio(GradoDeEstudio gradosDeEstudio) {
		this.gradosDeEstudio.add(gradosDeEstudio);
	}



	public Set<ExperienciaProfesional> getExperienciasProfesionales() {
		return experienciasProfesionales;
	}



	public void setExperienciasProfesionales(ExperienciaProfesional experienciasProfesionales) {
		this.experienciasProfesionales.add(experienciasProfesionales);
	}



	public Set<Habilidad> getHabilidades() {
		return habilidades;
	}



	public void setHabilidades(Habilidad habilidades) {
		this.habilidades.add(habilidades);
	}
	
	

	public Set<Conocimiento> getConocimientos() {
		return conocimientos;
	}



	public void setConocimientos(Conocimiento conocimientos) {
		this.conocimientos.add(conocimientos);
	}



	public Set<Actitud> getActitudes() {
		return actitudes;
	}



	public void setActitudes(Actitud actitudes) {
		this.actitudes.add(actitudes);
	}



	@Override
	public String toString() {
		return "{ id:" + id + "}";
	}	
}
