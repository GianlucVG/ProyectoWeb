package com.restaurant.project.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "plato")
public class Plato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nom_plato")
	private String nombre;
	
	@Column(name = "desc_plato", length = 150)
	private String descripcion;
	
	@Column(name = "precio_plato", precision = 3, scale = 2)
	private BigDecimal precio;
	
	@Column(name = "estado")
	private Integer estado;
	
	@Column(name = "foto", nullable = true)
	private byte[] foto;
	
	@Column(name = "nom_archivo", nullable = true)
	private String archivo;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoPlato tipo;
	

	public Plato() {
		super();
		this.estado = 1;
	}
	

	public Plato(Long id, String nombre, String descripcion, BigDecimal precio, TipoPlato tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipo = tipo;
		this.estado = 1;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public TipoPlato getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlato tipo) {
		this.tipo = tipo;
	}
	

}
