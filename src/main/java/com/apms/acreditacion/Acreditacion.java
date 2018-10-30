package com.apms.acreditacion;

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
@Table(name = "Acreditacion")
public class Acreditacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	/*
	@ManyToOne
	@JoinColumn(name = "id_unidadDeAprendizaje")
	private UnidadesDeAprendizaje unidadDeAprendizaje;
	 */
	public Acreditacion() {
		super();
	}

	public Acreditacion(String nombre, String descripcion, UnidadDeAprendizaje unidadDeAprendizaje) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		//this.unidadDeAprendizaje = unidadDeAprendizaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/*
	public UnidadesDeAprendizaje getUnidadDeAprendizaje() {
		return unidadDeAprendizaje;
	}

	public void setUnidadDeAprendizaje(UnidadesDeAprendizaje unidadDeAprendizaje) {
		this.unidadDeAprendizaje = unidadDeAprendizaje;
	}
	*/

}
