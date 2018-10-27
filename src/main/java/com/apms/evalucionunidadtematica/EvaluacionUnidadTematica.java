package com.apms.evalucionunidadtematica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apms.unidadtematica.UnidadTematica;

@Entity
@Table(name = "EvaluacionUnidadTematica")
public class EvaluacionUnidadTematica {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "porcentaje")
	private Double porcentaje;
	@Column(name = "tipo")
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "id_unidadTematica")
	private UnidadTematica unidadTematica;

	public EvaluacionUnidadTematica() {
		super();
	}

	public EvaluacionUnidadTematica(String nombre, Double porcentaje, String tipo, UnidadTematica unidadTematica) {
		super();
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.tipo = tipo;
		this.unidadTematica = unidadTematica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UnidadTematica getUnidadTematica() {
		return unidadTematica;
	}

	public void setUnidadTematica(UnidadTematica unidadTematica) {
		this.unidadTematica = unidadTematica;
	}

}
