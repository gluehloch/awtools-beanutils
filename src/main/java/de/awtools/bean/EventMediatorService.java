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
 */

package de.awtools.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Das Interface für alle Objekte die 'Bounded Properties' zur Verfügung
 * stellen.
 * 
 * @author by Andre Winkler
 */
public interface EventMediatorService {

	/**
	 * Fügt einen <code>PropertyChangeListener</code> diesem Objekt hinzu.
	 * 
	 * @param listener
	 *            Observiert den Zustand dieses Objekts.
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Fügt einen <code>PropertyChangeListener</code> diesem Objekt hinzu,
	 * welches nur an der Eigenschaft <code>property</code> interessiert ist.
	 * 
	 * @param property
	 *            Die zu observierende Eigenschaft.
	 * @param listener
	 *            Observiert den Zustand dieses Objekts.
	 */
	public void addPropertyChangeListener(String property, PropertyChangeListener listener);

	/**
	 * Feuert eine <code>PropertyChangeEvent</code>.
	 * 
	 * @param evt
	 *            Eine <code>PropertyChangeEvent</code>.
	 */
	public void firePropertyChange(PropertyChangeEvent evt);

	/**
	 * Feuert ein <code>PropertyChangeEvent</code>.
	 * 
	 * @param propertyName
	 *            Die Eigenschaft.
	 * @param oldValue
	 *            Der alte Wert.
	 * @param newValue
	 *            Der neue Wert.
	 */
	public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue);

	/**
	 * Feuert ein <code>PropertyChangeEvent</code>.
	 * 
	 * @param propertyName
	 *            Die Eigenschaft.
	 * @param oldValue
	 *            Der alte Wert.
	 * @param newValue
	 *            Der neue Wert.
	 */
	public void firePropertyChange(String propertyName, int oldValue, int newValue);

	/**
	 * Feuert ein <code>PropertyChangeEvent</code>.
	 * 
	 * @param propertyName
	 *            Die Eigenschaft.
	 * @param oldValue
	 *            Der alte Wert.
	 * @param newValue
	 *            Der neue Wert.
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue);

	public void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue);

	/**
	 * Liefert alle <code>PropertyChangeListener</code>.
	 * 
	 * @return Eine Array mit <code>PropertyChangeListener</code>.
	 */
	public PropertyChangeListener[] getPropertyChangeListeners();

	/**
	 * Liefert alle <code>PropertyChangeListener</code> für eine bestimmte
	 * Eigenschaft.
	 * 
	 * @param propertyName
	 *            Der Name der Eigenschaft.
	 * @return Eine Array mit <code>PropertyChangeListener</code>.
	 */
	public PropertyChangeListener[] getPropertyChangeListeners(String propertyName);

	/**
	 * Liefert eine Frage auf die Antwort, ob für folgende Eigenschaft ein
	 * Listener vorliegt.
	 * 
	 * @param propertyName
	 *            Der Name der Eigenschaft auf den die Listener hören.
	 * @return true, es hört ein Listener auf die gesuchte Eigenschaft.
	 */
	public boolean hasListeners(String propertyName);

	/**
	 * Entfernt einen <code>PropertyChangeListener</code>.
	 * 
	 * @param listener
	 *            Entfernt diesen Listener.
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Entfernt einen <code>PropertyChangeListener</code>, welches nur an der
	 * Eigenschaft <code>property</code> interessiert war.
	 * 
	 * @param property
	 *            Die zu observierende Eigenschaft.
	 * @param listener
	 *            Ein <code>PropertyChangeListener</code>.
	 */
	public void removePropertyChangeListener(String property, PropertyChangeListener listener);

}
