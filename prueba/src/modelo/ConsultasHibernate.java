package modelo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConsultasHibernate {
	
	public SessionFactory obtenerSessionFactory() {
		SessionFactory sf = null;
		
		try {
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		
		return sf;
		
	}
	
	public void cerrarSession(SessionFactory sessionFactory) {
		sessionFactory.close();
	}
	
	public ObservableList<String> obtenerListaNombreNephilim(SessionFactory sessionFactory){
		ObservableList<String> nombreListaNephilim = FXCollections.observableArrayList();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Raza r WHERE r.nombre LIKE concat(:nombreRaza,'%') OR r.nombre = :Humano");
			query.setParameter("nombreRaza", "NEPHILIM");
			query.setParameter("Humano", "HUMANO");
			List<Raza> listaRaza = query.list();
			String nombreNephilim;
			
			for (Raza raza : listaRaza) {
				nombreNephilim = raza.getNombre();
				nombreListaNephilim.add(nombreNephilim);
			}
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaNephilim;
		
	}
	
	public Raza obtenerRaza(String razaSeleccionada, SessionFactory sessionFactory){
		Session session = null;
		Raza raza;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Raza r WHERE r.nombre = :nombreRaza");
			query.setParameter("nombreRaza", razaSeleccionada);
			raza = (Raza) query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return raza;
		
	}
	
	public ObservableList<String> obtenerListaArmas(SessionFactory sessionFactory){
		ObservableList<String> nombreListaArmas = FXCollections.observableArrayList();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Arma a WHERE a.tipo not in (:municiones)");
			query.setParameter("municiones", "Municion");
			List<Arma> listaArma = query.list();
			String nombresArmas;
			
			for (Arma arma : listaArma) {
				nombresArmas = arma.getNombre();
				nombreListaArmas.add(nombresArmas);
			}
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaArmas;
		
	}
	
	public Arma obtenerArma(SessionFactory sessionFactory, String nombreArma){
		Arma arma;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Arma a WHERE a.nombre = :nombreArma");
			query.setParameter("nombreArma", nombreArma);
			arma = (Arma)query.getSingleResult();
			
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return arma;
		
	}
	
	public ObservableList<String> obtenerListaArmaduras(SessionFactory sessionFactory){
		ObservableList<String> nombreListasArmaduras = FXCollections.observableArrayList();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Armadura");
			List<Armadura> listaArmadura = query.list();
			String nombresArmaduras;
			
			for (Armadura armadura : listaArmadura) {
				nombresArmaduras = armadura.getNombre();
				nombreListasArmaduras.add(nombresArmaduras);
			}
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListasArmaduras;
		
	}
	
	public Armadura obtenerArmadura(SessionFactory sessionFactory, String nombreArmadura){
		Armadura armadura;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Armadura a WHERE a.nombre = :nombreArmadura");
			query.setParameter("nombreArmadura", nombreArmadura);
			armadura = (Armadura)query.getSingleResult();
			
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return armadura;
		
	}
	
	public Categoria obtenerCategoria(String categoriaSeleccionada, SessionFactory sessionFactory) {
		Session session = null;
		Categoria categoria;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Categoria c WHERE c.nombre = :nombreCategoria");
			query.setParameter("nombreCategoria", categoriaSeleccionada);
			categoria = (Categoria) query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return categoria;
	}
	
	public ObservableList<String> obtenerNombresVentaja(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaVentaja = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Ventaja");
			List<Ventaja> listaVentaja = query.list();
			String nombreVentaja;
			
			for (Ventaja ventaja : listaVentaja) {
				nombreVentaja = ventaja.getNombre();
				nombreListaVentaja.add(nombreVentaja);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaVentaja;
	}
	
	public int obtenerCosteVentajaSeleccionada(SessionFactory sessionFactory, String nombreVentaja) {
		Session session = null;
		Ventaja ventaja;
		int coste;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Ventaja v WHERE v.nombre = :nombreVentaja");
			query.setParameter("nombreVentaja", nombreVentaja);
			ventaja = (Ventaja)query.getSingleResult();
			coste = ventaja.getCoste();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return coste;
	}
	
	public Ventaja obtenerVentajaSeleccionada(SessionFactory sessionFactory, String nombreVentaja) {
		Session session = null;
		Ventaja ventaja;
		int coste;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Ventaja v WHERE v.nombre = :nombreVentaja");
			query.setParameter("nombreVentaja", nombreVentaja);
			ventaja = (Ventaja)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return ventaja;
	}
	
	public ObservableList<String> obtenerNombresDesventaja(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaVentaja = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Desventaja");
			List<Desventaja> listaVentaja = query.list();
			String nombreVentaja;
			
			for (Desventaja ventaja : listaVentaja) {
				nombreVentaja = ventaja.getNombre();
				nombreListaVentaja.add(nombreVentaja);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaVentaja;
	}
	
	public int obtenerBeneficioDesventajaSeleccionada(SessionFactory sessionFactory, String nombreDesventaja) {
		Session session = null;
		Desventaja desventaja;
		int coste;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Desventaja d WHERE d.nombre = :nombreDesventaja");
			query.setParameter("nombreDesventaja", nombreDesventaja);
			desventaja = (Desventaja)query.getSingleResult();
			coste = desventaja.getBeneficio();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return coste;
	}
	
	public Desventaja obtenerDesventajaSeleccionada(SessionFactory sessionFactory, String nombreDesventaja) {
		Session session = null;
		Desventaja desventaja;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Desventaja d WHERE d.nombre = :nombreDesventaja");
			query.setParameter("nombreDesventaja", nombreDesventaja);
			desventaja = (Desventaja)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return desventaja;
	}
	
	public ObservableList<String> obtenerListaTablasEstilo(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaTablasEstilos = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaEstilo");
			List<TablaEstilo> listaTablasEstilo = query.list();
			String nombreTablaEstilo;
			
			for (TablaEstilo tablaEstilo : listaTablasEstilo) {
				nombreTablaEstilo = tablaEstilo.getNombre();
				nombreListaTablasEstilos.add(nombreTablaEstilo);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaTablasEstilos;
	}
	
	public TablaEstilo obtenerTablasEstiloSeleccionada(SessionFactory sessionFactory, String nombreTablaEstilo) {
		Session session = null;
		TablaEstilo tablaEstilo;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaEstilo t WHERE t.nombre = :nombreTablaEstilo");
			query.setParameter("nombreTablaEstilo", nombreTablaEstilo);
			tablaEstilo = (TablaEstilo)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return tablaEstilo;
	}
	
	public ObservableList<String> obtenerListaArtesMarciales(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaArtesMarciales = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM ArteMarcial");
			List<ArteMarcial> listaArtesMarciales = query.list();
			String nombreArteMarcial;
			
			for (ArteMarcial arteMarcial : listaArtesMarciales) {
				nombreArteMarcial = arteMarcial.getNombre();
				nombreListaArtesMarciales.add(nombreArteMarcial);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaArtesMarciales;
	}

	public ArteMarcial obtenerArteMarcialSeleccionada(SessionFactory sessionFactory, String nombreArteMarcialSeleccionada) {
		Session session = null;
		ArteMarcial arteMarcial;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM ArteMarcial at WHERE at.nombre = :nombreArteMarcialSeleccionada");
			query.setParameter("nombreArteMarcialSeleccionada", nombreArteMarcialSeleccionada);
			arteMarcial = (ArteMarcial)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return arteMarcial;
	}
	
	public ObservableList<String> obtenerListaViasMagicas(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaVias = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaViasMagia");
			List<TablaViasMagia> listaVias = query.list();
			String nombreVia;
			
			for (TablaViasMagia tablaViasMagia : listaVias) {
				nombreVia = tablaViasMagia.getNombre();
				nombreListaVias.add(nombreVia);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaVias;
	}

	public TablaViasMagia obtenerViaMagiaSeleccionada(SessionFactory sessionFactory, String nombreViaMagiaSeleccionada) {
		Session session = null;
		TablaViasMagia tablaViasMagia;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaViasMagia tvm WHERE tvm.nombre = :nombreViaMagiaSeleccionada");
			query.setParameter("nombreViaMagiaSeleccionada", nombreViaMagiaSeleccionada);
			tablaViasMagia = (TablaViasMagia)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return tablaViasMagia;
	}
	
	public ObservableList<String> listaTablasMagias(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaTablasMagia = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaMagia");
			List<TablaMagia> listaTablasMagia = query.list();
			String nombreTablaMagia;
			
			for (TablaMagia tablaMagia : listaTablasMagia) {
				nombreTablaMagia = tablaMagia.getNombre();
				nombreListaTablasMagia.add(nombreTablaMagia);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaTablasMagia;
	}

	public TablaMagia obtenerTablaMagia(SessionFactory sessionFactory, String nombreTablaMagiaSeleccionada) {
		Session session = null;
		TablaMagia tablaMagia;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaMagia tm WHERE tm.nombre = :nombreTablaMagiaSeleccionada");
			query.setParameter("nombreTablaMagiaSeleccionada", nombreTablaMagiaSeleccionada);
			tablaMagia = (TablaMagia)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return tablaMagia;
	}
	
	public ObservableList<String> listaConjurosLibreAcceso(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaConjurosLibreAcceso = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaConjurosLibreAcceso");
			List<TablaConjurosLibreAcceso> listaConjurosLibreAcceso = query.list();
			String nombreConjuroLibreAcceso;
			
			for (TablaConjurosLibreAcceso tablaConjurosLibreAcceso : listaConjurosLibreAcceso) {
				nombreConjuroLibreAcceso = tablaConjurosLibreAcceso.getNombre();
				nombreListaConjurosLibreAcceso.add(nombreConjuroLibreAcceso);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaConjurosLibreAcceso;
	}

	public TablaConjurosLibreAcceso obtenerConjuroLibreAccesoSeleccionado(SessionFactory sessionFactory, String nombreConjuroLibreAccesoSeleccionada) {
		Session session = null;
		TablaConjurosLibreAcceso conjuroLibreAcceso;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM TablaConjurosLibreAcceso tcla WHERE tcla.nombre = :nombreConjuroLibreAccesoSeleccionada");
			query.setParameter("nombreConjuroLibreAccesoSeleccionada", nombreConjuroLibreAccesoSeleccionada);
			conjuroLibreAcceso = (TablaConjurosLibreAcceso)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return conjuroLibreAcceso;
	}
	
	public ObservableList<String> listaPoderesPsiquicos(SessionFactory sessionFactory) {
		Session session = null;
		ObservableList<String> nombreListaPoderesPsiquicos = FXCollections.observableArrayList();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM PoderPsiquico");
			List<PoderPsiquico> listaPoderesPsiquicos = query.list();
			String nombrePoderPsiquico;
			
			for (PoderPsiquico poderPsiquico : listaPoderesPsiquicos) {
				nombrePoderPsiquico = poderPsiquico.getNombre();
				nombreListaPoderesPsiquicos.add(nombrePoderPsiquico);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return nombreListaPoderesPsiquicos;
	}

	public PoderPsiquico obtenerPoderPsiquicoSeleccionado(SessionFactory sessionFactory, String nombrePoderPsiquicoSeleccionado) {
		Session session = null;
		PoderPsiquico poderPsiquico;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM PoderPsiquico pp WHERE pp.nombre = :nombrePoderPsiquicoSeleccionado");
			query.setParameter("nombrePoderPsiquicoSeleccionado", nombrePoderPsiquicoSeleccionado);
			poderPsiquico = (PoderPsiquico)query.getSingleResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
				
			}
		}
		return poderPsiquico;
	}

	public int insertarPersonaje(SessionFactory sessionFactory, Personaje personaje, Lv lv, PdsCategoriaId pdsCategoriaId, PdsCategoria pdsCategoria) {
		Session session = null;
		int idPersonaje = 0;
		
		try {

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Personaje nuevoPersonaje = new Personaje();
			nuevoPersonaje.setApariencia(personaje.getApariencia());
			nuevoPersonaje.setNombre(personaje.getNombre());
			nuevoPersonaje.setArmaduras(personaje.getArmaduras());
			nuevoPersonaje.setArteMarcials(personaje.getArteMarcials());
			nuevoPersonaje.setCaracteristicas(personaje.getCaracteristicas());
			nuevoPersonaje.setRaza(personaje.getRaza());
			nuevoPersonaje.setPoderPsiquicos(personaje.getPoderPsiquicos());
			nuevoPersonaje.setTablaConjurosLibreAccesos(personaje.getTablaConjurosLibreAccesos());
			nuevoPersonaje.setVentajas(personaje.getVentajas());
			nuevoPersonaje.setDesventajas(personaje.getDesventajas());
			nuevoPersonaje.setLv(lv);
			
			session.saveOrUpdate(nuevoPersonaje);
			idPersonaje = nuevoPersonaje.getIdPersonaje();
			
			lv.setPersonaje(nuevoPersonaje);
			session.saveOrUpdate(lv);
			

			TablaVentajaPersonajeId tablaVentajaPersonajeId = new TablaVentajaPersonajeId();
			/*Inserta las ventajas del personaje guardado*/
			for (Iterator<Ventaja> it = nuevoPersonaje.getVentajas().iterator(); it.hasNext();) {
				Ventaja ventaja = it.next();
				tablaVentajaPersonajeId.setIdPersonaje(idPersonaje);
				tablaVentajaPersonajeId.setIdVentaja(ventaja.getIdVentaja());
				session.saveOrUpdate(tablaVentajaPersonajeId);
			}
			

			TablaVentajaPersonajeId tablaDesventajaPersonajeId = new TablaVentajaPersonajeId();
			/*Inserta las desventajas del personaje guardado*/
			for (Iterator<Desventaja> it = nuevoPersonaje.getDesventajas().iterator(); it.hasNext();) {
				Desventaja desventaja = it.next();
				tablaDesventajaPersonajeId.setIdPersonaje(idPersonaje);
				tablaDesventajaPersonajeId.setIdVentaja(desventaja.getIdDesventaja());
				session.saveOrUpdate(tablaDesventajaPersonajeId);
			}
			
			
			
			PdsCategoriaId pdsCategoriaIdNuevo = new PdsCategoriaId();
			pdsCategoriaIdNuevo.setPdsPrimariasComunes(pdsCategoria.getPdsPrimariasComunes().getPdsPrimariasComunes());
			pdsCategoriaIdNuevo.setPdsPrimariasKi(pdsCategoria.getPdsPrimariasKi().getPdsPrimariasKi());
			pdsCategoriaIdNuevo.setPdsPrimariasMisticas(pdsCategoria.getPdsPrimariasMisticas().getPdsPrimariasMisticas());
			pdsCategoriaIdNuevo.setPdsPrimariasPsiquicas(pdsCategoria.getPdsPrimariasPsiquicas().getPdsPrimariasPsiquicas());
			pdsCategoriaIdNuevo.setPdsSecundariasAtleticas(pdsCategoria.getPdsSecundariasAtleticas().getPdsSecundariasAtleticas());
			pdsCategoriaIdNuevo.setPdsSecundariasSociales(pdsCategoria.getPdsSecundariasSociales().getPdsSecundariasSociales());
			pdsCategoriaIdNuevo.setPdsSecundariasPerceptivas(pdsCategoria.getPdsSecundariasPerceptivas().getPdsSecundariasPerceptivas());
			pdsCategoriaIdNuevo.setPdsSecundariasIntelectuales(pdsCategoria.getPdsSecundariasIntelectuales().getPdsSecundariasIntelectuales());
			pdsCategoriaIdNuevo.setPdsSecundariasVigor(pdsCategoria.getPdsSecundariasVigor().getPdsSecundariasVigor());
			pdsCategoriaIdNuevo.setPdsSecundariasSubterfugio(pdsCategoria.getPdsSecundariasSubterfugio().getPdsSecundariasSubterfugio());
			pdsCategoriaIdNuevo.setPdsSecundariasCreativas(pdsCategoria.getPdsSecundariasCreativas().getPdsSecundariasCreativas());
			pdsCategoriaIdNuevo.setIdCategoria(pdsCategoria.getCategoria().getIdCategoria());
			pdsCategoriaIdNuevo.setIdPersonaje(idPersonaje);
			
			session.saveOrUpdate(pdsCategoriaIdNuevo);
			
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return idPersonaje;
	}
	
	public Personaje obtenerPersonaje(SessionFactory sessionFactory, int idPersonaje) {
		Session session = null;
		Personaje personaje = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Personaje p WHERE p.idPersonaje = :idPersonaje");
			query.setParameter("idPersonaje", idPersonaje);
			personaje = (Personaje)query.getSingleResult();

			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return personaje;
	}
	
	
	
}
