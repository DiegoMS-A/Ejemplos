package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//todas las variables deben ser privadas para Hibernate, tener getters and setters e implementar Serializable
// Si no se llama igual @column (name="Nombre")

@SuppressWarnings("serial")
@Entity
@Table
public class alumnos implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String correo;
	@Column
	private String telefono;
	@Column
	private String direccion;

	public alumnos(String nombre, String apellido, String correo, String telefono, String direccion) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDirección() {
		return direccion;
	}

	public void setDirección(String direccion) {
		this.direccion = direccion;
	}

}

//-	Alumnos: id, nombre, apellido, correo, teléfono, dirección