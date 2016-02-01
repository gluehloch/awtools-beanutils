/*
 * $Id: BeanIntrospectionTest.java 2297 2010-07-23 07:11:30Z andrewinkler $
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

import static org.junit.Assert.assertEquals;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;

/**
 * Testet das Verhalten von Java Beans mittels Bean-Introspection und
 * BeanPropertyDescriptor.
 * 
 * @author  $Author: andrewinkler $
 * @version $Revision: 2297 $ $Date: 2010-07-23 09:11:30 +0200 (Fr, 23 Jul 2010) $
 */
public class BeanIntrospectionTest {

    @Test
    public void testAddressBeanPropertyDescriptor() throws Exception {
        AddressBean addressBean = new AddressBean();
        addressBean.setCity("Essen");
        addressBean.setStreet("Beisenstr");
        addressBean.setZip(4711);

        BeanInfo info = Introspector.getBeanInfo(AddressBean.class);
        PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
        assertEquals("city", descriptors[0].getName());
        assertEquals("class", descriptors[1].getName());
        assertEquals("street", descriptors[2].getName());
        assertEquals("zip", descriptors[3].getName());
    }

}