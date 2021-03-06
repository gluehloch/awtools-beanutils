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

import org.apache.commons.beanutils.LazyDynaBean;

/**
 * Ein <code>BasicDynaBean</code> mit PropertyChange-Mechanismus.
 * 
 * @author by Andre Winkler
 */
public class PropertyMediatorLazyDynaBean extends LazyDynaBean implements EventMediatorService {

	/** serial version id */
	private static final long serialVersionUID = -6776482471140906565L;

	private final EventMediator eventSupport = new EventMediator(this);

	@Override
	public void set(String key, Object value) {
		Object oldValue = get(key);
		super.set(key, value);
		firePropertyChange(key, oldValue, value);
	}

	@Override
	public void set(String key, int index, Object value) {
		Object oldValue = get(key);
		super.set(key, value);
		firePropertyChange(key, oldValue, value);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		eventSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#addPropertyChangeListener(java.lang.String,
	 *      java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
		eventSupport.addPropertyChangeListener(property, listener);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.beans.PropertyChangeEvent)
	 */
	public void firePropertyChange(PropertyChangeEvent evt) {
		eventSupport.firePropertyChange(evt);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.lang.String,
	 *      boolean, boolean)
	 */
	public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
		eventSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.lang.String,
	 *      int, int)
	 */
	public void firePropertyChange(String propertyName, int oldValue, int newValue) {
		eventSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#firePropertyChange(java.lang.String,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
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
	public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
		return eventSupport.getPropertyChangeListeners(propertyName);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#hasListeners(java.lang.String)
	 */
	public boolean hasListeners(String propertyName) {
		return eventSupport.hasListeners(propertyName);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		eventSupport.removePropertyChangeListener(listener);
	}

	/**
	 * @see de.gluehloch.util.bean.EventMediatorService#removePropertyChangeListener(java.lang.String,
	 *      java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
		eventSupport.removePropertyChangeListener(property, listener);
	}

}
