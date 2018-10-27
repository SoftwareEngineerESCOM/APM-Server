package com.apms.bibliografia;

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

import com.apms.autor.Autor;
import com.apms.unidaddeaprendizaje.UnidadesDeAprendizaje;
import com.apms.unidadtematica.UnidadTematica;

@Entity
@Table(name = "Bibliografia")
public class Bibliografia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "anioPublicacion")
	private Integer anioPublicacion;
	@Column(name = "editorial")
	private String editorial;
	@Column(name = "edicion")
	private Integer edicion;
	@Column(name = "pais")
	private String pais;

	@ManyToMany(mappedBy = "bibliografias")
	private Set<UnidadTematica> unidadesTematicas = new HashSet<UnidadTematica>();

	@ManyToMany(mappedBy = "bibliografias")
	private Set<UnidadesDeAprendizaje> unidadesDeAprendizaje = new HashSet<UnidadesDeAprendizaje>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bibliografia_autor", joinColumns = @JoinColumn(name = "id_bibliografia"), inverseJoinColumns = @JoinColumn(name = "id_autor"))
	private Set<Autor> autores = new HashSet<Autor>();

	public Bibliografia() {
		super();
	}

	public Bibliografia(String isbn, String titulo, Integer anioPublicacion, String editorial, Integer edicion,
			String pais, Set<UnidadTematica> unidadesTematicas, Set<UnidadesDeAprendizaje> unidadesDeAprendizaje,
			Set<Autor> autores) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
		this.editorial = editorial;
		this.edicion = edicion;
		this.pais = pais;
		this.unidadesTematicas = unidadesTematicas;
		this.unidadesDeAprendizaje = unidadesDeAprendizaje;
		this.autores = autores;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(Integer anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getEdicion() {
		return edicion;
	}

	public void setEdicion(Integer edicion) {
		this.edicion = edicion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<UnidadTematica> getUnidadesTematicas() {
		return unidadesTematicas;
	}

	public void setUnidadesTematicas(Set<UnidadTematica> unidadesTematicas) {
		this.unidadesTematicas = unidadesTematicas;
	}

	public Set<UnidadesDeAprendizaje> getUnidadesDeAprendizaje() {
		return unidadesDeAprendizaje;
	}

	public void setUnidadesDeAprendizaje(Set<UnidadesDeAprendizaje> unidadesDeAprendizaje) {
		this.unidadesDeAprendizaje = unidadesDeAprendizaje;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

}
