package com.apms.horaunidadtematica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HoraUnidadTematica")
public class HoraUnidadTematica implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="TeoricaTotalDocencia")
	private double teoricaTotalDocencia;	
	@Column(name="PracticaTotalDocencia")
	private double practicaTotalDocencia;
	@Column(name="TotalAutonomo")
	private double totalAutonomo;
	
	public HoraUnidadTematica() {
	}

	public HoraUnidadTematica(double teoricaTotalDocencia, double practicaTotalDocencia, double totalAutonomo) {
		super();
		this.teoricaTotalDocencia = teoricaTotalDocencia;
		this.practicaTotalDocencia = practicaTotalDocencia;
		this.totalAutonomo = totalAutonomo;
	}

	public double getTeoricaTotalDocencia() {
		return teoricaTotalDocencia;
	}

	public void setTeoricaTotalDocencia(double teoricaTotalDocencia) {
		this.teoricaTotalDocencia = teoricaTotalDocencia;
	}

	public double getPracticaTotalDocencia() {
		return practicaTotalDocencia;
	}

	public void setPracticaTotalDocencia(double practicaTotalDocencia) {
		this.practicaTotalDocencia = practicaTotalDocencia;
	}

	public double getTotalAutonomo() {
		return totalAutonomo;
	}

	public void setTotalAutonomo(double totalAutonomo) {
		this.totalAutonomo = totalAutonomo;
	}

	@Override
	public String toString() {
		return "{ id:" + id + ", teoricaTotalDocencia:" + teoricaTotalDocencia
				+ ", practicaTotalDocencia:" + practicaTotalDocencia + ", totalAutonomo:" + totalAutonomo + "}";
	}
}
