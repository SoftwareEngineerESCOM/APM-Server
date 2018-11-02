package com.apms.unidaddeaprendizajedescripcion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoDeUnidad")
public class UnidadDeAprendizajeDescripcion implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "proposito")
	private String proposito;
	@Column(name = "orientacionDidactica")
	private String orientacionDidactica;
	@Column(name = "evaluacionYAcreditacion")
	private String evaluacionYAcreditacion;
	@Column(name = "intencionEducativa")
	private String intencionEducativa;

	public UnidadDeAprendizajeDescripcion() {
		super();
	}

	public UnidadDeAprendizajeDescripcion(String proposito, String orientacionDidactica, String evaluacionYAcreditacion,
			String intencionEducativa) {
		super();
		this.proposito = proposito;
		this.orientacionDidactica = orientacionDidactica;
		this.evaluacionYAcreditacion = evaluacionYAcreditacion;
		this.intencionEducativa = intencionEducativa;
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	public String getOrientacionDidactica() {
		return orientacionDidactica;
	}

	public void setOrientacionDidactica(String orientacionDidactica) {
		this.orientacionDidactica = orientacionDidactica;
	}

	public String getEvaluacionYAcreditacion() {
		return evaluacionYAcreditacion;
	}

	public void setEvaluacionYAcreditacion(String evaluacionYAcreditacion) {
		this.evaluacionYAcreditacion = evaluacionYAcreditacion;
	}

	public String getIntencionEducativa() {
		return intencionEducativa;
	}

	public void setIntencionEducativa(String intencionEducativa) {
		this.intencionEducativa = intencionEducativa;
	}

	@Override
	public String toString() {
		return "UnidadDeAprendizajeDescripcion [id=" + id + ", proposito=" + proposito + ", orientacionDidactica="
				+ orientacionDidactica + ", evaluacionYAcreditacion=" + evaluacionYAcreditacion
				+ ", intencionEducativa=" + intencionEducativa + "]";
	}

}
