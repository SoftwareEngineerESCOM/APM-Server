package com.apms.perfil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apms.cargo.Cargo;

@Entity
@Table(name="Perfil")
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/*
	@ManyToMany(mappedBy = "perfiles")
    private Set<Cargo> cargos = new HashSet<Cargo>();
	*/
	
	@Column(name="Nombre")
	private String nombre;
	
	public Perfil() {	
	}

	public Perfil(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Perfil(Set<Cargo> cargos, String nombre) {
		super();
		//this.cargos = cargos;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	public Set<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(Set<Cargo> cargos) {
		this.cargos = cargos;
	}*/

	@Override
	public String toString() {
		return "{ id:" + id + ", nombre:" + nombre + "}";
	}
}
