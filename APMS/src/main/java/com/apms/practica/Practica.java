package com.apms.practica;

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

import com.apms.unidadtematica.UnidadTematica;

@Entity
@Table(name="Practica")
public class Practica implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(mappedBy = "practicas")
    private Set<UnidadTematica> unidadesTematicas = new HashSet<UnidadTematica>();
	
	@Column(name="Nombre")
	private String nombre;	
	@Column(name="Numero")
	private int numero ;
	@Column(name="Duracion")
	private double duracion;
	@Column(name="Lugar")
	private String lugar;
		
	public Practica() {
	}

	public Practica(String nombre, int numero, double duracion, String lugar) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.duracion = duracion;
		this.lugar = lugar;
	}

	public Practica(Set<UnidadTematica> unidadesTematicas, String nombre, int numero, double duracion, String lugar) {
		super();
		this.unidadesTematicas = unidadesTematicas;
		this.nombre = nombre;
		this.numero = numero;
		this.duracion = duracion;
		this.lugar = lugar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Set<UnidadTematica> getUnidadesTematicas() {
		return unidadesTematicas;
	}

	public void setUnidadesTematicas(Set<UnidadTematica> unidadesTematicas) {
		this.unidadesTematicas = unidadesTematicas;
	}

	@Override
	public String toString() {
		return "{ id:" + id + ", nombre:" + nombre + ", numero:" + numero + ", duracion:" + duracion
				+ ", lugar:" + lugar + "}";
	}

}
