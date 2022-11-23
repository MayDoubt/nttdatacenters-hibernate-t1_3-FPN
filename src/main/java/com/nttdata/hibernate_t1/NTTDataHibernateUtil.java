package com.nttdata.hibernate_t1;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Configuration class
 * 
 * @author Fernando Pérez Nieto
 *
 */
public class NTTDataHibernateUtil {
	

	/** SessionFactory */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Utility class constructor
	 */
	private NTTDataHibernateUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Create SessionFactory
	 */
	static {

		try {

			// Generación de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {

			// Error de inicialización.
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Return sessionFactory object.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}

