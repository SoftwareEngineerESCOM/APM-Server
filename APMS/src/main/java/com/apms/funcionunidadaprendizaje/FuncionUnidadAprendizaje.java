package com.apms.funcionunidadaprendizaje;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FuncionUnidadAprendizaje")
public class FuncionUnidadAprendizaje implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public FuncionUnidadAprendizaje() {
	}

	@Override
	public String toString() {
		return "{ id:" + id + "}";
	}

}
