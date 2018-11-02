package com.apms.evaluacionunidaddeaprendizaje;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apms.unidaddeaprendizaje.UnidadDeAprendizaje;

@Entity
@Table(name = "EvaluacionUnidadDeAprendizaje")
public class EvaluacionUnidadDeAprendizaje {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "numeroUnidadTematica")
	private Integer numeroUnidadTematica;
	@Column(name = "porcentaje")
	private Double porcentaje;
	@Column(name = "periodo")
	private Integer periodo;
	@ManyToOne
	@JoinColumn(name = "id_unidadDeAprendizaje")
	private UnidadDeAprendizaje unidadDeAprendizaje;

	public Integer getNumeroUnidadTematica() {
		return numeroUnidadTematica;
	}

	public void setNumeroUnidadTematica(Integer numeroUnidadTematica) {
		this.numeroUnidadTematica = numeroUnidadTematica;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public UnidadDeAprendizaje getUnidadDeAprendizaje() {
		return unidadDeAprendizaje;
	}

	public void setUnidadDeAprendizaje(UnidadDeAprendizaje unidadDeAprendizaje) {
		this.unidadDeAprendizaje = unidadDeAprendizaje;
	}

}
