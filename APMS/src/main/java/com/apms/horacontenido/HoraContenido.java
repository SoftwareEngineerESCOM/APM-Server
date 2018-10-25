package com.apms.horacontenido;

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
@Table(name="HoraContenido")
public class HoraContenido implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="TeoricaDocencia")
	private double teoricaDocencia;	
	@Column(name="PracticaDocencia")
	private double practicaDocencia;
	@Column(name="Autonomo")
	private double autonomo;
	
	public HoraContenido() {	
	}

	public HoraContenido(double teoricaDocencia, double practicaDocencia, double autonomo) {
		super();
		this.teoricaDocencia = teoricaDocencia;
		this.practicaDocencia = practicaDocencia;
		this.autonomo = autonomo;
	}

	public double getTeoricaDocencia() {
		return teoricaDocencia;
	}

	public void setTeoricaDocencia(double teoricaDocencia) {
		this.teoricaDocencia = teoricaDocencia;
	}

	public double getPracticaDocencia() {
		return practicaDocencia;
	}

	public void setPracticaDocencia(double practicaDocencia) {
		this.practicaDocencia = practicaDocencia;
	}

	public double getAutonomo() {
		return autonomo;
	}

	public void setAutonomo(double autonomo) {
		this.autonomo = autonomo;
	}

	@Override
	public String toString() {
		return "{ id:" + id + ", teoricaDocencia:" + teoricaDocencia + ", practicaDocencia:"
				+ practicaDocencia + ", autonomo:" + autonomo + "}";
	}

}
