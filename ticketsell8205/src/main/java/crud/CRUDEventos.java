package crud;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.transaction.UserTransaction;

import entities.Eventos;

public class CRUDEventos implements Serializable {
	private static final long serialVersionUID = 1L;

	EntityManager em;
	UserTransaction ut;

	public CRUDEventos(EntityManager em, UserTransaction ut) {
		this.em = em;
		this.ut = ut;
	}

	// CREATION methods
	public Eventos createEvent(String titulo, String categoria, String fecha, String ciudad, int sala, String imagen) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
			java.util.Date dateUtils = null;
			try {
				dateUtils = dateFormat.parse(fecha);

			} catch (Exception e) {
				System.err.println("Error parsing the date");
				e.printStackTrace();
			}
			Date date = new Date(dateUtils.getTime());
			ut.begin();
			Eventos newEvent = new Eventos();
			newEvent.setTitulo(titulo);
			newEvent.setCategoria(categoria);
			newEvent.setCiudad(ciudad);
			newEvent.setSala(sala);
			newEvent.setFecha(date);
			newEvent.setImagen(imagen);

			em.persist(newEvent);
			ut.commit();

			return newEvent;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error creating the event.");
			return null;
		}
	}

	// READ methods
	public List<Eventos> getEventList() {
		Query getAllEvents = em.createQuery("SELECT e FROM eventos e");
		@SuppressWarnings("unchecked")
		List<Eventos> resultList = (List<Eventos>) getAllEvents.getResultList();
		return resultList;
	}

	public Eventos getEventById(String id) {
		String search = "" + id;
		try {
			Eventos event = em.find(entities.Eventos.class, search);
			return event;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// UPDATE methods
	public boolean updateEvent(String titulo, String categoria, String fecha, String ciudad, int sala, String imagen) {
		Eventos event = getEventById(titulo);

		if (event == null)
			return false;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm");
		java.util.Date dateUtils = null;
		try {
			dateUtils = dateFormat.parse(fecha);

		} catch (Exception e) {
			System.err.println("Error parsing the date");
			e.printStackTrace();
		}
		Date date = new Date(dateUtils.getTime());

		event.setTitulo(titulo);
		event.setCategoria(categoria);
		event.setCiudad(ciudad);
		event.setSala(sala);
		event.setFecha(date);
		event.setImagen(imagen);

		try {
			ut.begin();
			event = em.merge(event);
			ut.commit();
		} catch (Exception ex) {
			System.out.println("Error while updating the event.");
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	// DELETE methods
	public boolean deleteEvent(String titulo) throws IOException {
		Eventos eventToDelete = getEventById(titulo);

		if (eventToDelete == null)
			return false;

		try {
			ut.begin();
			em.remove(eventToDelete);
			ut.commit();
		} catch (Exception e) {
			System.out.println("Error while deleting the event.");
			e.printStackTrace();
			return false;
		}

		return true;
	}
		
}
