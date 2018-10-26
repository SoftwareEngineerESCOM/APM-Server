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

}
