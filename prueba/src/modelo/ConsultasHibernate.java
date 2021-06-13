package modelo;

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
	
	public Armadura obtenerArmamadura(SessionFactory sessionFactory, String nombreArmadura){
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
	
	public static void main(String[] args) {
		ConsultasHibernate ch = new ConsultasHibernate();
		SessionFactory sf = ch.obtenerSessionFactory();
		
		System.out.println(ch.obtenerRaza("DAIMAH", sf).toString());
		System.out.println(ch.obtenerListaNombreNephilim(sf));
		System.out.println(ch.obtenerNombresVentaja(sf).toString());
		System.out.println(ch.obtenerBeneficioDesventajaSeleccionada(sf, "MIOPIA"));
	}
}
