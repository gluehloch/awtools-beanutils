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

/**
 * Definiert eine Schnittstelle für das Mapping von Eigenschaften zwischen
 * GUI-Modellen und Domainobjekten.
 * 
 * @author by Andre Winkler
 */
public interface Mapper {

    /**
     * Liefert einen Wert aus einem Domänenobjekt.
     * 
     * @param domainObject Das betreffende Domänenobjekt.
     * @return Der Wert dieser Eigenschaft.
     */
    public Object getProperty(Object domainObject);

    /**
     * Setzt eine Eigenschaft in einem Domänenobjekt.
     *
     * @param domainObject Das betreffende Domänenobjekt.
     * @param value Der Wert dieser Eigenschaft.
     */
    public void setProperty(Object domainObject, Object value);
}
