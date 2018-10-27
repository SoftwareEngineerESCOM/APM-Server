package com.apms.tema;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apms.unidadtematica.UnidadTematica;

@Entity
@Table(name = "Tema")
public class Tema implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "numero")
	private int numero;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_UnidadTematica", nullable = false)
	UnidadTematica unidadTematica;

	public Tema() {
		super();
	}

	public Tema(String nombre, int numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
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

	public UnidadTematica getUnidadTematica() {
		return unidadTematica;
	}

	public void setUnidadTematica(UnidadTematica unidadTematica) {
		this.unidadTematica = unidadTematica;
	}

	@Override
	public String toString() {
		return "{ nombre:" + nombre + ", numero:" + numero + "}";
	}

}
