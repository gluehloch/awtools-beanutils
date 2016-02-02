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

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

/**
 * Testet die Klasse {@link de.gluehloch.util.bean.DefaultPropertyMapper}.
 * 
 * @author Andre Winkler
 */
public class DefaultPropertyMapperTest {

	@Test
	public void testDefaultPropertyMapper() {
		DefaultPropertyMapper mapper = new DefaultPropertyMapper("file");
		PropertyBean bean = new PropertyBean();

		File file = new File("test.html");
		bean.setFile(file);

		assertEquals(File.class, mapper.getProperty(bean).getClass());
		assertEquals(file, mapper.getProperty(bean));
	}

	public class PropertyBean {
		private File file;

		public void setFile(File _file) {
			file = _file;
		}

		public File getFile() {
			return file;
		}
	}
}
