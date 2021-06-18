package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

	public List<Personaje> listaPersonajes(SessionFactory sessionFactory){
		Session session = null;
		List<Personaje> personajes = new ArrayList<Personaje>();
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Personaje");
			personajes = query.list();
			
			
			 
			 
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if (session != null) {
				session.close();
				
			}
		}
		return personajes;
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
	
	public void eliminarPersonaje(SessionFactory sessionFactory, int idPersonaje) {
		Session session = null;
		Personaje personaje = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Personaje p WHERE p.idPersonaje = :idPersonaje");
			query.setParameter("idPersonaje", idPersonaje);
			personaje = (Personaje)query.getSingleResult();
		
			session.delete(personaje.getCaracteristicas());
			
			session.delete(personaje.getPdsPrimariasComunes());
			
			session.delete(personaje.getPdsPrimariasKi());
			
			session.delete(personaje.getPdsPrimariasMisticas());
			
			session.delete(personaje.getPdsPrimariasPsiquicas());
			
			session.delete(personaje.getPdsSecundariasAtleticas());
			
			session.delete(personaje.getPdsSecundariasCreativas());
			
			session.delete(personaje.getPdsSecundariasIntelectuales());
			
			session.delete(personaje.getPdsSecundariasPerceptivas());
			
			session.delete(personaje.getPdsSecundariasSociales());
			
			session.delete(personaje.getPdsSecundariasSubterfugio());
			
			session.delete(personaje.getPdsSecundariasVigor());
			
			for (Ventaja ventaja : personaje.getVentajas()) {
				ventaja.setPersonajes(null);
				session.update(ventaja);
				
			}
			
			for (Desventaja desventaja : personaje.getDesventajas()) {
				desventaja.setPersonajes(null);
				session.update(desventaja);
				
			}
			
			for (Arma arma : personaje.getArmas()) {
				
				arma.setPersonajes(null);
				arma.setPersonajes(null);
				session.update(arma);
				
			}
			
			for (Armadura armadura :  personaje.getArmaduras()) {
				armadura.setPersonajes(null);
				session.update(armadura);
				
			}
			
			for (ArteMarcial arteMarcial : personaje.getArteMarcials()) {
				arteMarcial.setPersonajes(null);
				session.update(arteMarcial);
				
			}
			
			for (TablaConjurosLibreAcceso tablasConjurosLibreAcceso : personaje.getTablaConjurosLibreAccesos()) {
				tablasConjurosLibreAcceso.setPersonajes(null);
				session.update(tablasConjurosLibreAcceso);
				
			}
			
			for (PoderPsiquico poderPsiquico : personaje.getPoderPsiquicos()) {
				poderPsiquico.setPersonajes(null);
				session.update(poderPsiquico);
				
			}
			
			for (TablaEstilo tablaEstilo : personaje.getTablaEstilos()) {
				tablaEstilo.setPersonajes(null);
				session.update(tablaEstilo);
				
			}
			
			session.delete(personaje);
			

			
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
	}
	
	public int insertarPersonaje(SessionFactory sessionFactory, Personaje personaje, Caracteristicas caracteristicas, PdsPrimariasComunes pdsPrimariasComunes, 
			PdsPrimariasKi pdsPrimariasKi, PdsPrimariasMisticas pdsPrimariasMisticas, PdsPrimariasPsiquicas pdsPrimariasPsiquicas, 
			PdsSecundariasAtleticas pdsSecundariasAtleticas, PdsSecundariasSociales pdsSecundariasSociales, PdsSecundariasCreativas pdsSecundariasCreativas, 
			PdsSecundariasIntelectuales pdsSecundariasIntelectuales, PdsSecundariasPerceptivas pdsSecundariasPerceptivas, PdsSecundariasSubterfugio pdsSecundariasSubterfugio, 
			PdsSecundariasVigor pdsSecundariasVigor, Set<Ventaja> ventajas, Set<Desventaja> desventajas, Set<Arma> armas, Set<Armadura> armaduras, 
			Set<ArteMarcial> tablaArteMarcial, Set<TablaConjurosLibreAcceso> tablaConjurosLibreAcceso, Set<PoderPsiquico> tablaPoderesPsiquicos, Set<TablaEstilo> tablaEstilos) {
		Session session = null;
		int idPersonaje = 0;
		
		try {

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Personaje nuevoPersonaje = new Personaje();
			nuevoPersonaje.setApariencia(personaje.getApariencia());
			nuevoPersonaje.setImagen(personaje.getImagen());
			nuevoPersonaje.setNivel(personaje.getNivel());
			nuevoPersonaje.setEdad(personaje.getEdad());
			nuevoPersonaje.setNombre(personaje.getNombre());
			nuevoPersonaje.setOrigen(personaje.getOrigen());
			nuevoPersonaje.setEtnia(personaje.getEtnia());
			
			nuevoPersonaje.setDescripcion(personaje.getDescripcion());
			nuevoPersonaje.setParticularidades(personaje.getParticularidades());
			nuevoPersonaje.setObjetivos(personaje.getObjetivos());
			nuevoPersonaje.setHistoria(personaje.getHistoria());
			nuevoPersonaje.setCansancioEspecial(personaje.getCansancioEspecial());
			nuevoPersonaje.setRegeneracionEspecial(personaje.getRegeneracionEspecial());
			nuevoPersonaje.setPvEspecial(personaje.getPvEspecial());
			nuevoPersonaje.setCvInvertido(personaje.getCvInvertido());
			nuevoPersonaje.setTurnoEspecial(personaje.getTurnoEspecial());
			
			nuevoPersonaje.setVestimentaAccesorios(personaje.getDescripcion());
			nuevoPersonaje.setContactos(personaje.getContactos());
			nuevoPersonaje.setEquipoCombate(personaje.getEquipoCombate());
			nuevoPersonaje.setEquipoVariado(personaje.getEquipoVariado());
			nuevoPersonaje.setTitulosPosesiones(personaje.getTitulosPosesiones());
			nuevoPersonaje.setJoyas(personaje.getJoyas());
			nuevoPersonaje.setMonedasOro(personaje.getMonedasOro());
			nuevoPersonaje.setMonedasPlata(personaje.getMonedasPlata());
			nuevoPersonaje.setMonedasCobre(personaje.getMonedasCobre());
			
			nuevoPersonaje.setArmas(personaje.getArmas());
			nuevoPersonaje.setArmaduras(personaje.getArmaduras());
			nuevoPersonaje.setArteMarcials(personaje.getArteMarcials());
			nuevoPersonaje.setCaracteristicas(personaje.getCaracteristicas());
			nuevoPersonaje.setRaza(personaje.getRaza());
			nuevoPersonaje.setCategoria(personaje.getCategoria());
			nuevoPersonaje.setPoderPsiquicos(personaje.getPoderPsiquicos());
			nuevoPersonaje.setTablaConjurosLibreAccesos(personaje.getTablaConjurosLibreAccesos());
			nuevoPersonaje.setVentajas(personaje.getVentajas());
			nuevoPersonaje.setDesventajas(personaje.getDesventajas());
			
			Set<Personaje> personajes = new HashSet<Personaje>();
			personajes.add(nuevoPersonaje);
			
			session.save(nuevoPersonaje);
			
			idPersonaje = nuevoPersonaje.getIdPersonaje();
			
			
			caracteristicas.setPersonaje(nuevoPersonaje);
			session.save(caracteristicas);
			
			pdsPrimariasComunes.setPersonaje(nuevoPersonaje);
			pdsPrimariasComunes.setIdPersonaje(idPersonaje);
			session.save(pdsPrimariasComunes);
			
			pdsPrimariasKi.setPersonaje(nuevoPersonaje);
			pdsPrimariasKi.setIdPersonaje(idPersonaje);
			pdsPrimariasMisticas.setPersonaje(nuevoPersonaje);
			pdsPrimariasMisticas.setIdPersonaje(idPersonaje);
			pdsPrimariasPsiquicas.setPersonaje(nuevoPersonaje);
			pdsPrimariasPsiquicas.setIdPersonaje(idPersonaje);
			session.save(pdsPrimariasKi);
			session.save(pdsPrimariasMisticas);
			session.save(pdsPrimariasPsiquicas);
			
			pdsSecundariasVigor.setPersonaje(nuevoPersonaje);
			pdsSecundariasVigor.setIdPersonaje(idPersonaje);
			pdsSecundariasSubterfugio.setPersonaje(nuevoPersonaje);
			pdsSecundariasSubterfugio.setIdPersonaje(idPersonaje);
			pdsSecundariasAtleticas.setPersonaje(nuevoPersonaje);
			pdsSecundariasAtleticas.setIdPersonaje(idPersonaje);
			pdsSecundariasCreativas.setPersonaje(nuevoPersonaje);
			pdsSecundariasCreativas.setIdPersonaje(idPersonaje);
			pdsSecundariasIntelectuales.setPersonaje(nuevoPersonaje);
			pdsSecundariasIntelectuales.setIdPersonaje(idPersonaje);
			pdsSecundariasPerceptivas.setPersonaje(nuevoPersonaje);
			pdsSecundariasPerceptivas.setIdPersonaje(idPersonaje);
			pdsSecundariasSociales.setPersonaje(nuevoPersonaje);
			pdsSecundariasSociales.setIdPersonaje(idPersonaje);
			session.save(pdsSecundariasVigor);
			session.save(pdsSecundariasSubterfugio);
			session.save(pdsSecundariasAtleticas);
			session.save(pdsSecundariasCreativas);
			session.save(pdsSecundariasIntelectuales);
			session.save(pdsSecundariasPerceptivas);
			session.save(pdsSecundariasSociales);
			
			for (Ventaja ventaja : ventajas) {
				ventaja.setPersonajes(personajes);
				session.update(ventaja);
				
			}
			
			for (Desventaja desventaja : desventajas) {
				desventaja.setPersonajes(personajes);
				session.update(desventaja);
				
			}
			
			for (Arma arma : armas) {
				
				arma.setPersonajes(personajes);
				session.update(arma);
				
			}
			
			for (Armadura armadura : armaduras) {
				armadura.setPersonajes(personajes);
				session.update(armadura);
				
			}
			
			for (ArteMarcial arteMarcial : tablaArteMarcial) {
				arteMarcial.setPersonajes(personajes);
				session.update(arteMarcial);
				
			}
			
			for (TablaConjurosLibreAcceso tablasConjurosLibreAcceso : tablaConjurosLibreAcceso) {
				tablasConjurosLibreAcceso.setPersonajes(personajes);
				session.update(tablasConjurosLibreAcceso);
				
			}
			
			for (PoderPsiquico poderPsiquico : tablaPoderesPsiquicos) {
				poderPsiquico.setPersonajes(personajes);
				session.update(poderPsiquico);
				
			}
			
			for (TablaEstilo tablaEstilo : tablaEstilos) {
				tablaEstilo.setPersonajes(personajes);
				session.update(tablaEstilo);
				
			}
			
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
	
	public int actualizarPersonaje(SessionFactory sessionFactory, Personaje personaje, Caracteristicas caracteristicas, PdsPrimariasComunes pdsPrimariasComunes, 
			PdsPrimariasKi pdsPrimariasKi, PdsPrimariasMisticas pdsPrimariasMisticas, PdsPrimariasPsiquicas pdsPrimariasPsiquicas, 
			PdsSecundariasAtleticas pdsSecundariasAtleticas, PdsSecundariasSociales pdsSecundariasSociales, PdsSecundariasCreativas pdsSecundariasCreativas, 
			PdsSecundariasIntelectuales pdsSecundariasIntelectuales, PdsSecundariasPerceptivas pdsSecundariasPerceptivas, PdsSecundariasSubterfugio pdsSecundariasSubterfugio, 
			PdsSecundariasVigor pdsSecundariasVigor, Set<Ventaja> ventajas, Set<Desventaja> desventajas, Set<Arma> armas, Set<Armadura> armaduras, 
			Set<ArteMarcial> tablaArteMarcial, Set<TablaConjurosLibreAcceso> tablaConjurosLibreAcceso, Set<PoderPsiquico> tablaPoderesPsiquicos, Set<TablaEstilo> tablaEstilos) {
		Session session = null;
		int idPersonaje = 0;
		
		try {

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Personaje WHERE nombre = :nombrePersonaje");
			query.setParameter("nombrePersonaje",personaje.getNombre());
			
			Personaje personajeSeleccionado = (Personaje) query.getSingleResult();
			
			int idPersonajeActualizado = personajeSeleccionado.getIdPersonaje();
			
			personajeSeleccionado.setIdPersonaje(idPersonajeActualizado);
			personajeSeleccionado.setApariencia(personaje.getApariencia());
			personajeSeleccionado.setImagen(personaje.getImagen());
			personajeSeleccionado.setNivel(personaje.getNivel());
			personajeSeleccionado.setEdad(personaje.getEdad());
			personajeSeleccionado.setNombre(personaje.getNombre());
			personajeSeleccionado.setOrigen(personaje.getOrigen());
			personajeSeleccionado.setEtnia(personaje.getEtnia());
			personajeSeleccionado.setDescripcion(personaje.getDescripcion());
			personajeSeleccionado.setParticularidades(personaje.getParticularidades());
			personajeSeleccionado.setObjetivos(personaje.getObjetivos());
			personajeSeleccionado.setHistoria(personaje.getHistoria());
			personajeSeleccionado.setCansancioEspecial(personaje.getCansancioEspecial());
			personajeSeleccionado.setRegeneracionEspecial(personaje.getRegeneracionEspecial());
			personajeSeleccionado.setPvEspecial(personaje.getPvEspecial());
			personajeSeleccionado.setCvInvertido(personaje.getCvInvertido());
			personajeSeleccionado.setTurnoEspecial(personaje.getTurnoEspecial());
			
			personajeSeleccionado.setDescripcion(personaje.getDescripcion());
			personajeSeleccionado.setContactos(personaje.getContactos());
			personajeSeleccionado.setEquipoCombate(personaje.getEquipoCombate());
			personajeSeleccionado.setEquipoVariado(personaje.getEquipoVariado());
			personajeSeleccionado.setTitulosPosesiones(personaje.getTitulosPosesiones());
			personajeSeleccionado.setJoyas(personaje.getJoyas());
			personajeSeleccionado.setMonedasOro(personaje.getMonedasOro());
			personajeSeleccionado.setMonedasPlata(personaje.getMonedasPlata());
			personajeSeleccionado.setMonedasCobre(personaje.getMonedasCobre());
			
			personajeSeleccionado.setArmas(personaje.getArmas());
			personajeSeleccionado.setArmaduras(personaje.getArmaduras());
			personajeSeleccionado.setArteMarcials(personaje.getArteMarcials());
			personajeSeleccionado.setCaracteristicas(personaje.getCaracteristicas());
			personajeSeleccionado.setRaza(personaje.getRaza());
			personajeSeleccionado.setCategoria(personaje.getCategoria());
			personajeSeleccionado.setPoderPsiquicos(personaje.getPoderPsiquicos());
			personajeSeleccionado.setTablaConjurosLibreAccesos(personaje.getTablaConjurosLibreAccesos());
			personajeSeleccionado.setVentajas(personaje.getVentajas());
			personajeSeleccionado.setDesventajas(personaje.getDesventajas());
//			personajeSeleccionado.setPdsPrimariasComunes(pdsPrimariasComunes);
//			personajeSeleccionado.setPdsPrimariasKi(pdsPrimariasKi);
//			personajeSeleccionado.setPdsPrimariasMisticas(pdsPrimariasMisticas);
//			personajeSeleccionado.setPdsPrimariasPsiquicas(pdsPrimariasPsiquicas);
//			personajeSeleccionado.setPdsSecundariasAtleticas(pdsSecundariasAtleticas);
//			personajeSeleccionado.setPdsSecundariasCreativas(pdsSecundariasCreativas);
//			personajeSeleccionado.setPdsSecundariasIntelectuales(pdsSecundariasIntelectuales);
//			personajeSeleccionado.setPdsSecundariasPerceptivas(pdsSecundariasPerceptivas);
//			personajeSeleccionado.setPdsSecundariasSociales(pdsSecundariasSociales);
//			personajeSeleccionado.setPdsSecundariasSubterfugio(pdsSecundariasSubterfugio);
//			personajeSeleccionado.setPdsSecundariasVigor(pdsSecundariasVigor);
			

			
			Set<Personaje> personajes = new HashSet<Personaje>();
			personajes.add(personajeSeleccionado);
			
//			session.persist(personajeSeleccionado);
			
			caracteristicas.setIdPersonaje(idPersonajeActualizado);
			caracteristicas.setPersonaje(personajeSeleccionado);
			session.merge(caracteristicas);
			
			pdsPrimariasComunes.setPersonaje(personajeSeleccionado);
			pdsPrimariasComunes.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			session.merge(pdsPrimariasComunes);
			
			pdsPrimariasKi.setPersonaje(personajeSeleccionado);
			pdsPrimariasKi.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsPrimariasMisticas.setPersonaje(personajeSeleccionado);
			pdsPrimariasMisticas.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsPrimariasPsiquicas.setPersonaje(personajeSeleccionado);
			pdsPrimariasPsiquicas.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			session.merge(pdsPrimariasKi);
			session.merge(pdsPrimariasMisticas);
			session.merge(pdsPrimariasPsiquicas);
			
			pdsSecundariasVigor.setPersonaje(personajeSeleccionado);
			pdsSecundariasVigor.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsSecundariasSubterfugio.setPersonaje(personajeSeleccionado);
			pdsSecundariasSubterfugio.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsSecundariasAtleticas.setPersonaje(personajeSeleccionado);
			pdsSecundariasAtleticas.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsSecundariasCreativas.setPersonaje(personajeSeleccionado);
			pdsSecundariasCreativas.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsSecundariasIntelectuales.setPersonaje(personajeSeleccionado);
			pdsSecundariasIntelectuales.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsSecundariasPerceptivas.setPersonaje(personajeSeleccionado);
			pdsSecundariasPerceptivas.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			pdsSecundariasSociales.setPersonaje(personajeSeleccionado);
			pdsSecundariasSociales.setIdPersonaje(personajeSeleccionado.getIdPersonaje());
			session.merge(pdsSecundariasVigor);
			session.merge(pdsSecundariasSubterfugio);
			session.merge(pdsSecundariasAtleticas);
			session.merge(pdsSecundariasCreativas);
			session.merge(pdsSecundariasIntelectuales);
			session.merge(pdsSecundariasPerceptivas);
			session.merge(pdsSecundariasSociales);
			
			for (Ventaja ventaja : ventajas) {				
//				ventaja.setPersonajes(null);
//				session.update(ventaja);
				ventaja.setPersonajes(personajes);
				session.merge(ventaja);
				
			}
//			
			for (Desventaja desventaja : desventajas) {
				desventaja.setPersonajes(personajes);
				session.merge(desventaja);
				
			}
//			
			for (Arma arma : armas) {
				arma.setPersonajes(personajes);
				session.merge(arma);
				
			}
//			
			for (Armadura armadura : armaduras) {
				armadura.setPersonajes(personajes);
				session.merge(armadura);
				
			}
//			
			for (ArteMarcial arteMarcial : tablaArteMarcial) {
				arteMarcial.setPersonajes(personajes);
				session.merge(arteMarcial);
				
			}
//			
			for (TablaConjurosLibreAcceso tablasConjurosLibreAcceso : tablaConjurosLibreAcceso) {
				tablasConjurosLibreAcceso.setPersonajes(personajes);
				session.merge(tablasConjurosLibreAcceso);
				
			}
//			
			for (PoderPsiquico poderPsiquico : tablaPoderesPsiquicos) {
				poderPsiquico.setPersonajes(personajes);
				session.merge(poderPsiquico);
				
			}
//			
			for (TablaEstilo tablaEstilo : tablaEstilos) {
				tablaEstilo.setPersonajes(personajes);
				session.merge(tablaEstilo);
				
			}
			
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
	
	
	
}