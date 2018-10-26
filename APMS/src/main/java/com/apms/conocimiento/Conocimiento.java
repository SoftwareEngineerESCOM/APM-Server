package com.apms.conocimiento;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apms.perfildocente.PerfilDocente;

@Entity
@Table(name = "Conocimiento")
public class Conocimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;

	@ManyToMany(mappedBy = "conocimientos")
	private Set<PerfilDocente> perfilesDocentes = new HashSet<PerfilDocente>();

}
