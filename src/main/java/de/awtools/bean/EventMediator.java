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
 * @link http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4353056
 *
 * Workaraound for Java before 1.5.
 *
 * Although the index of a changed element of an indexed property is known to
 * setter methods, there currently is no standard way to propagate this information
 * to listening clients, that is, classes IndexedPropertyChangeEvent and
 * IndexedPropertyChangeSupport are missing. A listener has to iterate over the
 * whole property to identify the element that has actually changed. This is
 * inconvenient in general, and unacceptable if the number of property elements is
 * large.
 *
 * Feel free to use the implementation found in the workaround section. The method
 * signatures already take into account that non-int (ie, key) indexed properties
 * maybe are allowed in future Beans specifications. See Beans 1.01 spec (Section
 * 7.2, "Indexed Properties", pages 40/41): "Property indexes must be Java
 * "int"s. We may relax this restriction in the future to allow other index types."
 * Size of compiled class files: 1792 bytes (IndexedPropertyChangeSupport) and
 * 1100 bytes (IndexedPropertyChangeEvent).
 */

package de.awtools.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.commons.lang3.Validate;

/**
 * Ein sogenannter Event-Vermittler/Mediator. Hier können sich
 * <code>PropertyChangeListener</code> registrieren lassen
 *
 * @author by Andre Winkler
 */
public class EventMediator implements EventMediatorService {

	private final PropertyChangeSupport support;

	/**
	 * Default-Konstruktor. Wird verwendet wenn eine Klasse von EventMediator
	 * erben möchte.
	 */
	public EventMediator() {
		support = new PropertyChangeSupport(this);
	}

	/**
	 * Konstruktor.
	 * 
	 * @param sourceBean
	 *            Das Bean als Quelle der Events.
	 */

	public EventMediator(final Object sourceBean) {
		Validate.notNull(sourceBean);
		support = new PropertyChangeSupport(sourceBean);
	}

	/**
	 * Add a PropertyChangeListener to the listener list. The listener is
	 * registered for all properties.
	 * 
	 * @param listener
	 *            The PropertyChangeListener to be added
	 */
	public final synchronized void addPropertyChangeListener(PropertyChangeListener listener) {

		support.addPropertyChangeListener(listener);
	}

	/**
	 * Remove a PropertyChangeListener from the listener list. This removes a
	 * PropertyChangeListener that was registered for all properties.
	 * 
	 * @param listener
	 *            The PropertyChangeListener to be removed
	 */
	public final synchronized void removePropertyChangeListener(PropertyChangeListener listener) {

		support.removePropertyChangeListener(listener);
	}

	/**
	 * Returns an array of all the listeners that were added to the
	 * EventMediator object with addPropertyChangeListener().
	 * <p>
	 * If some listeners have been added with a named property, then the
	 * returned array will be a mixture of PropertyChangeListeners and
	 * <code>PropertyChangeListenerProxy</code>s. If the calling method is
	 * interested in distinguishing the listeners then it must test each element
	 * to see if it's a <code>PropertyChangeListenerProxy</code>, perform the
	 * cast, and examine the parameter.
	 * 
	 * <pre>
	 * PropertyChangeListener[] listeners = bean.getPropertyChangeListeners();
	 * for (int i = 0; i &lt; listeners.length; i++) {
	 * 	if (listeners[i] instanceof PropertyChangeListenerProxy) {
	 * 		PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) listeners[i];
	 * 		if (proxy.getPropertyName().equals(&quot;foo&quot;)) {
	 * 			// proxy is a PropertyChangeListener which was associated
	 * 			// with the property named &quot;foo&quot;
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 * @see java.beans.PropertyChangeListenerProxy
	 * @return all of the <code>PropertyChangeListeners</code> added or an empty
	 *         array if no listeners have been added
	 * @since 1.4
	 */
	public final synchronized PropertyChangeListener[] getPropertyChangeListeners() {
		return support.getPropertyChangeListeners();
	}

	/**
	 * Add a PropertyChangeListener for a specific property. The listener will
	 * be invoked only when a call on firePropertyChange names that specific
	 * property.
	 * 
	 * @param propertyName
	 *            The name of the property to listen on.
	 * @param listener
	 *            The PropertyChangeListener to be added
	 */

	public final synchronized void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {

		support.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * Remove a PropertyChangeListener for a specific property.
	 * 
	 * @param propertyName
	 *            The name of the property that was listened on.
	 * @param listener
	 *            The PropertyChangeListener to be removed
	 */

	public final synchronized void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {

		support.removePropertyChangeListener(propertyName, listener);
	}

	/**
	 * Returns an array of all the listeners which have been associated with the
	 * named property.
	 * 
	 * @param property
	 *            returns the listener of this property
	 * @return all of the <code>PropertyChangeListeners</code> associated with
	 *         the named property or an empty array if no listeners have been
	 *         added
	 */
	public final synchronized PropertyChangeListener[] getPropertyChangeListeners(final String property) {

		return support.getPropertyChangeListeners(property);
	}

	/**
	 * Report a bound property update to any registered listeners. No event is
	 * fired if old and new are equal and non-null.
	 * 
	 * @param propertyName
	 *            The programmatic name of the property that was changed.
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 */
	public final void firePropertyChange(final String propertyName, final Object oldValue, final Object newValue) {

		support.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Report an int bound property update to any registered listeners. No event
	 * is fired if old and new are equal and non-null.
	 * <p>
	 * This is merely a convenience wrapper around the more general
	 * firePropertyChange method that takes Object values.
	 * 
	 * @param propertyName
	 *            The programmatic name of the property that was changed.
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 */
	public final void firePropertyChange(final String propertyName, final int oldValue, final int newValue) {

		support.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Report a boolean bound property update to any registered listeners. No
	 * event is fired if old and new are equal and non-null.
	 * <p>
	 * This is merely a convenience wrapper around the more general
	 * firePropertyChange method that takes Object values.
	 * 
	 * @param propertyName
	 *            The programmatic name of the property that was changed.
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 */
	public final void firePropertyChange(final String propertyName, final boolean oldValue, final boolean newValue) {

		support.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Fire an existing PropertyChangeEvent to any registered listeners. No
	 * event is fired if the given event's old and new values are equal and
	 * non-null.
	 * 
	 * @param evt
	 *            The PropertyChangeEvent object.
	 */
	public final void firePropertyChange(final PropertyChangeEvent evt) {
		support.firePropertyChange(evt);
	}

	/**
	 * Check if there are any listeners for a specific property.
	 * 
	 * @param propertyName
	 *            the property name.
	 * @return true if there are ore or more listeners for the given property
	 */
	public final synchronized boolean hasListeners(final String propertyName) {
		return support.hasListeners(propertyName);
	}

	/**
	 * Report a bound indexed property update to any registered listeners.
	 *
	 * No event is fired if old and new property element at the specified index
	 * are equal and non-null.
	 *
	 * @param propertyName
	 *            The programmatic name of the property that was changed.
	 * @param index
	 *            Indicator specifying the property element that was changed.
	 *
	 *            Currently this must be of type <code>Integer</code>, but this
	 *            may change as soon as non-int property indices (keys) are
	 *            allowed.
	 *
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 **/
	public final synchronized void fireIndexedPropertyChange(final String propertyName, final int index,
			final Object oldValue, final Object newValue) {

		support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
	}

}
