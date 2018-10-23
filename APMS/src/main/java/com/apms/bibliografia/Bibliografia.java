package com.apms.bibliografia;

public class Bibliografia {
	private Integer id;
	private String ISBN;
	private String titulo;
	private String anioPublicacion;
	private String editorial;
	private String edicion;
	private String pais;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(String anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
