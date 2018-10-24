package com.apms.tema;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tema")
public class Tema implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name="nombre")
	private String nombre;
    @Column(name="numero")
    private int numero;
    
    public Tema() {

	}
	
    public Tema(String nombre, int numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "{ nombre:"+nombre+", numero:"+numero+"}";
	}
      

}
