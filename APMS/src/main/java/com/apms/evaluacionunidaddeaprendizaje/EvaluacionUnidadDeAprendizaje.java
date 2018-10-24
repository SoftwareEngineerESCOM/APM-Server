package com.apms.evaluacionunidaddeaprendizaje;

public class EvaluacionUnidadDeAprendizaje {
	private Integer id;
	private Integer numeroUnidadTematica;
	private Double porcentaje;
	private Integer periodo;

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

}
