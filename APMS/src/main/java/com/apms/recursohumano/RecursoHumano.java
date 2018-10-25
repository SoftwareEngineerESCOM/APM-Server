package com.apms.recursohumano;

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

import com.apms.unidadacademica.UnidadAcademica;


@Entity
@Table(name="RecursoHumano")
public class RecursoHumano implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name="titulo")
	private String titulo;
    @Column(name="nombre")
	private String nombre;
    @Column(name="primerApellido")
	private String primerApellido;
    @Column(name="segundoApellido")
	private String segundoApellido;
    
    @ManyToMany(mappedBy = "unidad_academica")
    private Set<UnidadAcademica> unidadAcademica = new HashSet<UnidadAcademica>();

    public RecursoHumano() {
		super();
	}
    
	public RecursoHumano(String titulo, String nombre, String primerApellido, String segundoApellido) {
		super();
		this.titulo = titulo;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Set<UnidadAcademica> getUnidadAcademica() {
		return unidadAcademica;
	}

	public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
		this.unidadAcademica.add(unidadAcademica);
	}
    
    
    

}
