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

/**
 * Ein <code>IndexedPropertyChangeEvent</code>.
 * 
 * @author by Andre Winkler
 */
public class IndexedPropertyChangeEvent extends PropertyChangeEvent {

	/** serial version id */
    private static final long serialVersionUID = -7673094218691298374L;

    /**
	 * Constructs a new IndexedPropertyChangeEvent object.
	 * 
	 * @param _source The bean that fired the event.
	 * @param _propertyName The programmatic name of the property that was changed.
	 * @param _index Indicator specifying the property element that was changed.
	 * @param _oldValue The old value of the property.
	 * @param _newValue The new value of the property.
	 */
	public IndexedPropertyChangeEvent(
	        final Object _source, final String _propertyName,
	        final Object _index, final Object _oldValue,
	        final Object _newValue) {

		super (_source, _propertyName, _oldValue, _newValue);
		try {
		    this.index = ((Integer) _index).intValue ();
		} catch (Exception e) {
		    throw new UnsupportedOperationException
				("index must be non-null Integer (was: "
				        + ((null == _index) ? "null" : _index.getClass ().toString ()));
		}
	}

	// -- index ---------------------------------------------------------------

	private int index;

    /**
     * Currently this is of type <code>Integer</code>, but this may
     * change as soon as non-int property indices (keys) are allowed.
     *
     * @return The index specifying the property element that was
     *         changed, expressed as an Object.
     */
    public Object getIndex() {
        return new Integer(index);
    }

}
