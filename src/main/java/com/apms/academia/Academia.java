package com.apms.academia;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apms.unidadacademica.UnidadAcademica;
import com.apms.unidaddeaprendizaje.UnidadDeAprendizaje;

@Entity
@Table(name = "Academia")
public class Academia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;

	/*
	@OneToMany(mappedBy = "academia")
	private Set<UnidadesDeAprendizaje> unidadesDeAprendizaje = new HashSet<UnidadesDeAprendizaje>();
	
	@ManyToOne
	@JoinTable(name = "id_unidadAcademica")
	private UnidadAcademica unidadAcademica;
	 */
	
	public Academia() {
		super();
	}

	public Academia(String nombre, Set<UnidadDeAprendizaje> unidadesDeAprendizaje, UnidadAcademica unidadAcademica) {
		super();
		this.nombre = nombre;
		//this.unidadesDeAprendizaje = unidadesDeAprendizaje;
		//this.unidadAcademica = unidadAcademica;
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

	public void setUnidadesDeAprendizaje(Set<UnidadesDeAprendizaje> unidadesDeAprendizaje) {
		this.unidadesDeAprendizaje = unidadesDeAprendizaje;
	}

	public UnidadAcademica getUnidadAcademica() {
		return unidadAcademica;
	}

	public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
		this.unidadAcademica = unidadAcademica;
	}*/

}
