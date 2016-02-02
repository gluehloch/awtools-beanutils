/*
 * ============================================================================
 * Project awtools-beanutils
 * Copyright (c) 2000-2016 by Andre Winkler. All rights reserved.
 * ============================================================================
 *          GNU LESSER GENERAL PUBLIC LICENSE
 *  TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package de.awtools.bean;

/**
 * Eine Utility Klasse zur Instanzierung von Bean Objekten. Im wesentlichen
 * handelt es sich um Wrapper Methoden, die Aufrufe an <code>Class</code>
 * kapseln und die potentiellen 'Checked Exceptions' in 'RuntimeExceptions'
 * umwandeln.
 * 
 * @author by Andre Winkler
 */
public final class BeanInstanceUtils {

	/** Utility Klasse. */
	private BeanInstanceUtils() {
	}

	/**
	 * Instanziert eine Klasse über deren Paket- und Klassenbezeichner. Falls
	 * dieser Vorgang fehlschlägt, wird eine RuntimeException geworfen.
	 * 
	 * @param className
	 *            Der Klassenname.
	 * @return Das erzeugte Objekt.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T instantiate(final String className) {
		try {
			Class<T> clazz = (Class<T>) Class.forName(className);
			return BeanInstanceUtils.instantiate(clazz);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Instanziert eine Klasse über dessen Class Objekt. Falls dieser Vorgang
	 * fehlschlägt, wird eine RuntimeException geworfen.
	 *
	 * @param clazz
	 *            Die zu instanzierende Klasse.
	 * @return Das erzeugte Objekt.
	 */
	public static <T> T instantiate(final Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException ex) {
			throw new RuntimeException(ex);
		} catch (IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
	}

}
