package com.apms.ensenansa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apms.unidaddeaprendizaje.UnidadDeAprendizaje;

@Entity
@Table(name = "Ensenansa")
public class Ensenansa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	/*
	@ManyToMany(mappedBy = "ensenansas")
	private Set<UnidadesDeAprendizaje> unidadesDeAprendizaje = new HashSet<UnidadesDeAprendizaje>();
	*/
	public Ensenansa() {
		super();
	}

	public Ensenansa(String nombre, Set<UnidadDeAprendizaje> unidadesDeAprendizaje) {
		super();
		this.nombre = nombre;
		//this.unidadesDeAprendizaje = unidadesDeAprendizaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	public Set<UnidadesDeAprendizaje> getUnidadesDeAprendizaje() {
		return unidadesDeAprendizaje;
	}

	public void setUnidadesDeAprendizaje(UnidadesDeAprendizaje unidadesDeAprendizaje) {
		this.unidadesDeAprendizaje.add(unidadesDeAprendizaje);
	}
	 */
}
