package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {

	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_usuario;
	
	@Column(name="nombre")
	@Size(message="Este campo acepta solamente 50 caracteres", max=50)
	@NotEmpty(message="Este campo no puede ser vacio")
	private String nombre;
	
	@Column(name="apellido")
	@Size(message="Este campo acepta solamente 50 caracteres", max=50)
	@NotEmpty(message="Este campo no puede ser vacio")
	private String apellido;
	
	@Column(name="carne")
	@Size(message="Este campo acepta solamente 10 caracteres", max=10)
	@NotEmpty(message="Este campo no puede ser vacio")
	private String carne;
	
	@Column(name="carrera")
	@Size(message="Este campo acepta solamente 100 caracteres", max=100)
	@NotEmpty(message="Este campo no puede ser vacio")
	private String carrera;
	
	public Estudiante() {
		
	}

	public Integer getC_usuario() {
		return c_usuario;
	}

	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
	
}
