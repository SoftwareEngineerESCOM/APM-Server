package com.apms.plandeestudios;

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

import com.apms.unidaddeaprendizaje.UnidadesDeAprendizaje;



@Entity
@Table(name="PlanDeEstudios")
public class PlanDeEstudios implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/*@ManyToMany(mappedBy = "planesDeEstudio")
    private Set<UnidadesDeAprendizaje> unidadesDeAprendizaje = new HashSet<UnidadesDeAprendizaje>();
	*/
	@Column(name="Año")
	private int año;	
	@Column(name="Modalidad")
	private String modalidad ;
	@Column(name="SumatoriaCreditosTEPIC")
	private double sumatoriaCreditosTEPIC;
	@Column(name="SumatoriaCreditosSATCA")
	private double sumatoriaCreditosSATCA;
	
	public PlanDeEstudios() {
	}
	
	public PlanDeEstudios(int año, String modalidad, double sumatoriaCreditosTEPIC, double sumatoriaCreditosSATCA) {
		super();
		this.año = año;
		this.modalidad = modalidad;
		this.sumatoriaCreditosTEPIC = sumatoriaCreditosTEPIC;
		this.sumatoriaCreditosSATCA = sumatoriaCreditosSATCA;
	}

	public PlanDeEstudios(Set<UnidadesDeAprendizaje> unidadesDeAprendizaje, int año, String modalidad,
			double sumatoriaCreditosTEPIC, double sumatoriaCreditosSATCA) {
		super();
		//this.unidadesDeAprendizaje = unidadesDeAprendizaje;
		this.año = año;
		this.modalidad = modalidad;
		this.sumatoriaCreditosTEPIC = sumatoriaCreditosTEPIC;
		this.sumatoriaCreditosSATCA = sumatoriaCreditosSATCA;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public double getSumatoriaCreditosTEPIC() {
		return sumatoriaCreditosTEPIC;
	}

	public void setSumatoriaCreditosTEPIC(double sumatoriaCreditosTEPIC) {
		this.sumatoriaCreditosTEPIC = sumatoriaCreditosTEPIC;
	}

	public double getSumatoriaCreditosSATCA() {
		return sumatoriaCreditosSATCA;
	}

	public void setSumatoriaCreditosSATCA(double sumatoriaCreditosSATCA) {
		this.sumatoriaCreditosSATCA = sumatoriaCreditosSATCA;
	}
	/*
	public Set<UnidadesDeAprendizaje> getUnidadesDeAprendizaje() {
		return unidadesDeAprendizaje;
	}

	public void setUnidadesDeAprendizaje(Set<UnidadesDeAprendizaje> unidadesDeAprendizaje) {
		this.unidadesDeAprendizaje = unidadesDeAprendizaje;
	}*/

	@Override
	public String toString() {
		return "{ id:" + id + ", año:" + año + ", modalidad:" + modalidad + ", sumatoriaCreditosTEPIC:"
				+ sumatoriaCreditosTEPIC + ", sumatoriaCreditosSATCA:" + sumatoriaCreditosSATCA + "}";
	}
	
}
