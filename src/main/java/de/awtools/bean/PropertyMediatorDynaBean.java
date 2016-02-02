/*
 * ============================================================================
 * Project awtools-beanutils
 * Copyright (c) 2004-2016 by Andre Winkler. All rights reserved.
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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.DynaClass;

/**
 * Ein <code>BasicDynaBean</code> mit PropertyChange-Mechanismus.
 * 
 * @author by Andre Winkler
 */
public class PropertyMediatorDynaBean extends BasicDynaBean implements EventMediatorService {

	/** serial version id */
	private static final long serialVersionUID = 6602794125909569883L;

	private final EventMediator eventSupport = new EventMediator(this);

	/**
	 * @param _dynaClass
	 *            Eine Beschreibung des <code>DynaBean</code>.
	 */
	public PropertyMediatorDynaBean(final DynaClass _dynaClass) {
		super(_dynaClass);
	}

	/**
	 * Setzt eine Index-Property und feuert das entsprechende Event.
	 *
	 * @param name
	 *            Der Name der Eigenschaft.
	 * @param index
	 *            Der Index der Eigenschaft.
	 * @param value
	 *            Der Wert der Eigenschaft.
	 *
	 * @see BasicDynaBean#set(java.lang.String, int, java.lang.Object)
	 */
	@Override
	public final void set(final String name, final int index, final Object value) {
		Object oldValue = get(name, index);
		super.set(name, index, value);

		eventSupport.fireIndexedPropertyChange(name, new Integer(index), oldValue, value);
	}

	/**
	 * Setzt einen Wert einer Eigenschaft
	 *
	 * @param name
	 *            Der Name der Eigenschaft.
	 * @param value
	 *            Der Wert der Eigenschaft.
	 *
	 * @see BasicDynaBean#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public final void set(final String name, final Object value) {
		Object oldValue = get(name);
		super.set(name, value);

		eventSupport.firePropertyChange(name, oldValue, value);
	}

	/**
	 * Setzt eine Map-Property und feuert das entsprechende Event.
	 *
	 * @param name
	 *            Der Name der Eigenschaft.
	 * @param key
	 *            Der Key der Eigenschaft.
	 * @param value
	 *            Der Wert der Eigenschaft.
	 *
	 * @see BasicDynaBean#set(java.lang.String, String, java.lang.Object)
	 *
	 * @todo Der neue EventMediator unterstützt keine Map-Eigenschaften.
	 */
	@Override
	public final void set(final String name, final String key, final Object value) {
		// Object oldValue = get(name, key);
		super.set(name, key, value);

		// eventSupport.fireIndexedPropertyChange(name, key, oldValue, value);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		eventSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#addPropertyChangeListener(java.lang.String,
	 *      java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(final String property, final PropertyChangeListener listener) {
		eventSupport.addPropertyChangeListener(property, listener);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.beans.PropertyChangeEvent)
	 */
	public void firePropertyChange(final PropertyChangeEvent evt) {
		eventSupport.firePropertyChange(evt);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.lang.String,
	 *      boolean, boolean)
	 */
	public void firePropertyChange(final String propertyName, final boolean oldValue, final boolean newValue) {
		eventSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.lang.String,
	 *      int, int)
	 */
	public void firePropertyChange(final String propertyName, final int oldValue, final int newValue) {
		eventSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.lang.String,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void firePropertyChange(final String propertyName, final Object oldValue, final Object newValue) {
		eventSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#fireIndexedPropertyChange(java.lang.String,
	 *      int, java.lang.Object, java.lang.Object)
	 */
	public void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue) {
		eventSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#getPropertyChangeListeners()
	 */
	public PropertyChangeListener[] getPropertyChangeListeners() {
		return eventSupport.getPropertyChangeListeners();
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#getPropertyChangeListeners(java.lang.String)
	 */
	public PropertyChangeListener[] getPropertyChangeListeners(final String propertyName) {
		return eventSupport.getPropertyChangeListeners(propertyName);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#hasListeners(java.lang.String)
	 */
	public boolean hasListeners(final String propertyName) {
		return eventSupport.hasListeners(propertyName);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(final PropertyChangeListener listener) {
		eventSupport.removePropertyChangeListener(listener);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#removePropertyChangeListener(java.lang.String,
	 *      java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(final String property, final PropertyChangeListener listener) {
		eventSupport.removePropertyChangeListener(property, listener);
	}

}
