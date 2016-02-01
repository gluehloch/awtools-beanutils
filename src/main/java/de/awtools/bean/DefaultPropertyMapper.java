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

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Führt ein Property-Mapping aus, wie es die Methoden
 * <code>BeanUtils.getProperty()</code> und <code>BeanUtils.setProperty()</code>
 * in der Bibliothek commons-beanutils (@link http://jakarta.apache.org) zur
 * Verfügung stellen. Die gesuchte Eigenschaft kann
 * <code>nested/indexed/mapped</code> oder <code>combo</code> sein. Alle
 * Exceptions aus commons-beanutils werden gefangen und in eine
 * <code>RuntimeException</code> konvertiert.
 * 
 * @author by Andre Winkler
 */
public final class DefaultPropertyMapper implements Mapper {

    /** Auf diese Eigenschaft bezieht sich das Mapping. */
    private final String property;

    /**
     * Konstruktor.
     *
     * @param _property
     */
    public DefaultPropertyMapper(final String _property) {
        property = _property;
    }

    /**
     * Eventuelle Exceptions, die bei der Extraktion auftreten, werden in eine
     * <code>RuntimeException</code> umgewandelt.
     *
     * @see Mapper#getProperty(java.lang.Object)
     */
    public Object getProperty(final Object domainObject) {
        try {
            return PropertyUtils.getProperty(domainObject, property);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Eventuelle Exceptions, die bei der Injektion auftreten, werden in eine
     * <code>RuntimeException</code> umgewandelt.
     *
     * @see Mapper#setProperty(java.lang.Object, java.lang.Object)
     */
    public void setProperty(final Object domainObject, final Object value) {
        try {
            PropertyUtils.setProperty(domainObject, property, value);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

}
