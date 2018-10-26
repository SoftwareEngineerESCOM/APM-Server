package com.apms.cargo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apms.perfil.Perfil;
import com.apms.recursohumano.RecursoHumano;

@Entity
@Table(name = "Cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;

	@ManyToMany(mappedBy = "cargos")
	private Set<RecursoHumano> recursosHumanos = new HashSet<RecursoHumano>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cargo_perfil", joinColumns = @JoinColumn(name = "cargoId"), inverseJoinColumns = @JoinColumn(name = "perfilId"))
	private Set<Perfil> perfiles = new HashSet<Perfil>();

}
