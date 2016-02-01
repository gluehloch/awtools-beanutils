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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Testet die Funktionalität der {@link BeanInstanceUtils}.
 * 
 * @author by Andre Winkler
 */
public class BeanInstanceUtilsTest {

    @Test
    public void testBeanFactoryInstantiate() {
        Object object = BeanInstanceUtils.instantiate("java.lang.String");
        assertTrue(object instanceof String);

        try {
            BeanInstanceUtils.instantiate("java.lang.Test");
            fail("RuntimeException expected!");
        } catch (RuntimeException ex) {
            // Expecting a runtime exception.
        }
    }

}
