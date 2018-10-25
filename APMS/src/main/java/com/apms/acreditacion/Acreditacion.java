package com.apms.acreditacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apms.unidaddeaprendizaje.UnidadesDeAprendizaje;

@Entity
@Table(name = "Acreditacion")
public class Acreditacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_unidadDeAprendizaje")
	private UnidadesDeAprendizaje unidadDeAprendizaje;

}
