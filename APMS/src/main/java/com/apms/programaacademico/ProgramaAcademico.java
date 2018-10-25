package com.apms.programaacademico;

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
@Table(name="ProgramaAcademico")
public class ProgramaAcademico implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name="nombre")
	private String nombre;
    @Column(name="clave")
    private int clave;

	@ManyToMany(mappedBy = "unidad_academica")
    private Set<UnidadAcademica> unidadAcademica = new HashSet<UnidadAcademica>();
    
    
    
    public ProgramaAcademico(){
    	super();
    }
    
	public ProgramaAcademico(String nombre, int clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public Set<UnidadAcademica> getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica.add(unidadAcademica);
    }
	@Override
	public String toString() {
		return "{ id:"+id+", nombre:"+nombre+", clave:"+clave+"}";
	}
      
	
}