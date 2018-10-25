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
import com.apms.unidaddeaprendizaje.UnidadesDeAprendizaje;

@Entity
@Table(name = "Academia")
public class Academia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "academia")
	private Set<UnidadesDeAprendizaje> unidadesDeAprendizaje = new HashSet<UnidadesDeAprendizaje>();

	@ManyToOne
	@JoinTable(name = "id_unidadAcademica")
	private UnidadAcademica unidadAcademica;

}
