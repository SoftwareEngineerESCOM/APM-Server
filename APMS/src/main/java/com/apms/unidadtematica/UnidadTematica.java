package com.apms.unidadtematica;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.apms.bibliografia.Bibliografia;
import com.apms.evalucionunidadtematica.EvaluacionUnidadTematica;
import com.apms.programaacademico.ProgramaAcademico;
import com.apms.recursohumano.RecursoHumano;
import com.apms.tema.Tema;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="UnidadTematica")
public class UnidadTematica implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	@Column(name="numero")
	private int numero;
	@Column(name="unidadDeCompetencia")
	private int unidadDeCompetencia;
	@Column(name="estrategiasDeAprendizaje")
	private String estrategiasDeAprendizaje;
	
	/*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evaluacion", nullable = false)
    EvaluacionUnidadTematica evaluacion;
	*/
    
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "unidadTematica_practica", joinColumns = @JoinColumn(name = "unidaTematicaId"), inverseJoinColumns = @JoinColumn(name = "practicaId"))
	private Set<ProgramaAcademico> practicas = new HashSet<ProgramaAcademico>();
    
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "unidadTematica_bibliografia", joinColumns = @JoinColumn(name = "unidadTematicaId"), inverseJoinColumns = @JoinColumn(name = "bibliografiaId"))
	private Set<Bibliografia> bibliografias = new HashSet<Bibliografia>();
    */
	public UnidadTematica(String nombre, int numero, int unidadDeCompetencia, String estrategiasDeAprendizaje,
			EvaluacionUnidadTematica evaluacion, Set<ProgramaAcademico> practicas, Set<Bibliografia> bibliografias) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.unidadDeCompetencia = unidadDeCompetencia;
		this.estrategiasDeAprendizaje = estrategiasDeAprendizaje;
		//this.evaluacion = evaluacion;
		this.practicas = practicas;
		//this.bibliografias = bibliografias;
	}
	
	public UnidadTematica() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getUnidadDeCompetencia() {
		return unidadDeCompetencia;
	}

	public void setUnidadDeCompetencia(int unidadDeCompetencia) {
		this.unidadDeCompetencia = unidadDeCompetencia;
	}

	public String getEstrategiasDeAprendizaje() {
		return estrategiasDeAprendizaje;
	}

	public void setEstrategiasDeAprendizaje(String estrategiasDeAprendizaje) {
		this.estrategiasDeAprendizaje = estrategiasDeAprendizaje;
	}
	/*
	public EvaluacionUnidadTematica getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(EvaluacionUnidadTematica evaluacion) {
		this.evaluacion = evaluacion;
	}*/

	public Set<ProgramaAcademico> getPracticas() {
		return practicas;
	}

	public void setPracticas(Set<ProgramaAcademico> practicas) {
		this.practicas = practicas;
	}
	/*
	public Set<Bibliografia> getBibliografias() {
		return bibliografias;
	}

	public void setBibliografias(Set<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}
	 */
	@Override
	public String toString() {
		return "{UnidadTematica : [id=" + id + ", nombre=" + nombre + ", numero=" + numero + ", unidadDeCompetencia="
				+ unidadDeCompetencia + ", estrategiasDeAprendizaje=" + estrategiasDeAprendizaje + ", practicas=" + practicas + "]}";
	}
		
}
