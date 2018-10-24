package com.apms.precondicion;

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
@Table(name="Precondicion")
public class Precondicion implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name="UnidadRequerida")
	private String unidadRequerida;
    @Column(name="Tipo")
    private String tipo;
    
    public Precondicion(){
    	
    }
    
	public Precondicion(String unidadRequerida, String tipo) {
		super();
		this.unidadRequerida = unidadRequerida;
		this.tipo = tipo;
	}
	
	public String getUnidadRequerida() {
		return unidadRequerida;
	}
	public void setUnidadRequerida(String unidadRequerida) {
		this.unidadRequerida = unidadRequerida;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "{ id:"+id+", unidadRequerida:"+unidadRequerida+", tipo:"+tipo+"}";
	}
      
	
}