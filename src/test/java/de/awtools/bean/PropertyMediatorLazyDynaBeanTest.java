/*
 * $Id: PropertyMediatorLazyDynaBeanTest.java 2297 2010-07-23 07:11:30Z andrewinkler $
 * ============================================================================
 * Project awtools-beanutils
 * Copyright (c) 2004-2010 by Andre Winkler. All rights reserved.
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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testet die Klasse <code>PropertyMediatorLazyDynaBean</code>.
 * 
 * @version $LastChangedRevision: 2297 $ $LastChangedDate: 2010-07-23 09:11:30 +0200 (Fr, 23 Jul 2010) $
 * @author by Andre Winkler, $LastChangedBy: andrewinkler $
 */
public class PropertyMediatorLazyDynaBeanTest {

    private int callCounter = 0;

    @Test
    public void testPropertyMediatorLazyBean() {
        PropertyMediatorLazyDynaBean bean = new PropertyMediatorLazyDynaBean();
        bean.addPropertyChangeListener(new MyPropertyChangeListener());
        bean.set("propertyName", "oldValue");
        Assert.assertEquals(1, callCounter);
        bean.set("propertyName", "newValue");
        Assert.assertEquals(2, callCounter);
    }

    private class MyPropertyChangeListener implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent evt) {
            Assert.assertEquals("propertyName", evt.getPropertyName());
            callCounter++;
        }
    }

    @Before
    public void setUp() {
        callCounter = 0;
    }

}
