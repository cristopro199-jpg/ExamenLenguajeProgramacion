package com.cine.app.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpelicula;
    
    private String nombre;
    private String director;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEstreno;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Genero genero;
    

	public Integer getIdpelicula() {
		return idpelicula;
	}

	public void setIdpelicula(Integer idpelicula) {
		this.idpelicula = idpelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

    
}
