package com.apms.tiempoasignado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TiempoAsignado")
public class TiempoAsignado implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name="horaTeoricaSemana")
    private double horaTeoricaSemana;
    @Column(name="horaPracticaSemana")
    private double horaPracticaSemana;
    @Column(name="horaTeoricaSemestre")
    private double horaTeoricaSemestre;
    @Column(name="horaPracticaSemestre")
    private double horaPracticaSemestre;    
    @Column(name="horaAprendizajeAutonomo")
    private double horaAprendizajeAutonomo;
    @Column(name="horaTotalSemestre")
    private double horaTotalSemestre;
    
    public TiempoAsignado() {
    	super();
    }
    
    public TiempoAsignado(double horaTeoricaSemana, double horaPracticaSemana, double horaTeoricaSemestre,
			double horaPracticaSemestre, double horaAprendizajeAutonomo, double horaTotalSemestre) {
		
		super();
		this.horaTeoricaSemana = horaTeoricaSemana;
		this.horaPracticaSemana = horaPracticaSemana;
		this.horaTeoricaSemestre = horaTeoricaSemestre;
		this.horaPracticaSemestre = horaPracticaSemestre;
		this.horaAprendizajeAutonomo = horaAprendizajeAutonomo;
		this.horaTotalSemestre = horaTotalSemestre;
	}

	public double getHoraTeoricaSemana() {
		return horaTeoricaSemana;
	}

	public void setHoraTeoricaSemana(double horaTeoricaSemana) {
		this.horaTeoricaSemana = horaTeoricaSemana;
	}

	public double getHoraPracticaSemana() {
		return horaPracticaSemana;
	}

	public void setHoraPracticaSemana(double horaPracticaSemana) {
		this.horaPracticaSemana = horaPracticaSemana;
	}

	public double getHoraTeoricaSemestre() {
		return horaTeoricaSemestre;
	}

	public void setHoraTeoricaSemestre(double horaTeoricaSemestre) {
		this.horaTeoricaSemestre = horaTeoricaSemestre;
	}

	public double getHoraPracticaSemestre() {
		return horaPracticaSemestre;
	}

	public void setHoraPracticaSemestre(double horaPracticaSemestre) {
		this.horaPracticaSemestre = horaPracticaSemestre;
	}

	public double getHoraAprendizajeAutonomo() {
		return horaAprendizajeAutonomo;
	}

	public void setHoraAprendizajeAutonomo(double horaAprendizajeAutonomo) {
		this.horaAprendizajeAutonomo = horaAprendizajeAutonomo;
	}

	public double getHoraTotalSemestre() {
		return horaTotalSemestre;
	}

	public void setHoraTotalSemestre(double horaTotalSemestre) {
		this.horaTotalSemestre = horaTotalSemestre;
	}

	@Override
	public String toString() {
		return "{TiempoAsignado [horaTeoricaSemana=" + horaTeoricaSemana + ", horaPracticaSemana=" + horaPracticaSemana
				+ ", horaTeoricaSemestre=" + horaTeoricaSemestre + ", horaPracticaSemestre=" + horaPracticaSemestre
				+ ", horaAprendizajeAutonomo=" + horaAprendizajeAutonomo + ", horaTotalSemestre=" + horaTotalSemestre
				+ "]}";
	}
    
    
    
}
