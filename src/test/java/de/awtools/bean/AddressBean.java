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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Test-Java-Bean.
 * 
 * @author  Andre Winkler
 */
public class AddressBean {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    private String street;

    private String city;

    private int zip;

    /**
     * @return Returns the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param _city The city to set.
     */
    public void setCity(final String _city) {
        Object oldValue = city;
        city = _city;
        support.firePropertyChange("city", oldValue, city);
    }

    /**
     * @return Returns the street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param _street The street to set.
     */
    public void setStreet(final String _street) {
        Object oldValue = street;
        street = _street;
        support.firePropertyChange("street", oldValue, street);
    }

    /**
     * @return Returns the zip.
     */
    public int getZip() {
        return zip;
    }

    /**
     * @param _zip The zip to set.
     */
    public void setZip(final int _zip) {
        int oldValue = zip;
        zip = _zip;
        support.firePropertyChange("zip", oldValue, zip);
    }

    /**
     * Einen {@link PropertyChangeListener} einbauen.
     *
     * @param listener Ein {@link PropertyChangeListener}.
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Entfernt einen {@link PropertyChangeListener}.
     *
     * @param listener Ein {@link PropertyChangeListener}.
     */
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

}
