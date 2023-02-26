package com.diego.hibernate.ProyectoHibernate;
import org.hibernate.Session;

import database.HibernateUtil;
import model.alumnos;
import model.asignatura;
import model.ciclos;
import model.profesor;

public class Entrada {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.persist(new alumnos("Diego", "Martinez", "diego@gmail.com", "666666666", "C/falsa 123, Toledo"));
		session.persist(new alumnos("Paco", "Garcia", "paco@gmail.com", "666666667", "C/rio 321, Madrid"));
		session.persist(new alumnos("Fran", "Moreno", "fran@gmail.com", "666666668", "C/ronda 123, Cuenca"));
		session.persist(new ciclos("Desarrollo aplicaciones Multiplataforma", "DAM"));
		session.persist(new ciclos("Prueba2", "PR2"));
		session.persist(new ciclos("Prueba3", "PR3"));
		session.persist(new profesor("Diego", "Martinez", "diego@gmail.com", "666666666", "C/falsa 123, Toledo", true));
		session.persist(new profesor("Diego2", "Martinez2", "diego@gmail.com2", "666666667", "C/falsa 567, Madrid", true));
		session.persist(new profesor("Diego3", "Martinez3", "diego@gmail.com3", "666666668", "C/falsa 321, Melilla", false));
		session.persist(new asignatura("Programacion", "PGR", "Programacion Java"));
		session.persist(new asignatura("Acceso a datos", "AAD", "Conexiones BBDD y lectura de ficheros"));
		session.persist(new asignatura("Programacion Dispositivos Moviles", "PDM", "Programacion Android basada en Kotlin"));
		
		
		session.getTransaction().commit();
		session.close();
		
		
		/*;
		new alumnos;
		new alumnos;*/
	}
}
