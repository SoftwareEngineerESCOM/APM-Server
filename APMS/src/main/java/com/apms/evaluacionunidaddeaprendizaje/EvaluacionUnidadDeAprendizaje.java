package com.apms.evaluacionunidaddeaprendizaje;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EvaluacionUnidadDeAprendizaje")
public class EvaluacionUnidadDeAprendizaje {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="numeroUnidadTematica")
	private Integer numeroUnidadTematica;
	@Column(name="porcentaje")
	private Double porcentaje;
	@Column(name="periodo")
	private Integer periodo;

}
