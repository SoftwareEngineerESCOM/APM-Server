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
}
