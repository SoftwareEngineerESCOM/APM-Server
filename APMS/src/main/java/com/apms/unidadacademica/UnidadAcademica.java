package com.apms.unidadacademica;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apms.programaacademico.ProgramaAcademico;
import com.apms.recursohumano.RecursoHumano;


@Entity
@Table(name="ProgramaAcademico")
public class UnidadAcademica implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name="nombre")
	private String nombre;
    @Column(name="clave")
    private int clave;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "unidadAcademica_programaAcademico", joinColumns = @JoinColumn(name = "unidadAcademicaId"), inverseJoinColumns = @JoinColumn(name = "programaAcademicoId"))
	private Set<ProgramaAcademico> programasAcademicos = new HashSet<ProgramaAcademico>();
    
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "unidadAcademica_recursoHumano", joinColumns = @JoinColumn(name = "unidadAcademicaId"), inverseJoinColumns = @JoinColumn(name = "recursoHumanoId"))
	private Set<RecursoHumano> recursosHumanos = new HashSet<RecursoHumano>();
    
    
    public UnidadAcademica(){
    	
    }
    
	public UnidadAcademica(String nombre, int clave) {
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
	public Set<ProgramaAcademico> getProgramaAcademico() {
        return programasAcademicos;
    }

    public void setProgramaAcademico(ProgramaAcademico programaAcademico) {
        this.programasAcademicos.add(programaAcademico);
    }
    
	public Set<RecursoHumano> getRecursoHumano() {
        return recursosHumanos;
    }

    public void setRecursoHumano(RecursoHumano recursoHumano) {
        this.recursosHumanos.add(recursoHumano);
    }
    
    
	@Override
	public String toString() {
		return "{ id:"+id+", nombre:"+nombre+", clave:"+clave+"}";
	}
	
}
