/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.jsp.compiler.internal;

import java.io.IOException;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Raymond Augé
 */
public class TldURIUtilTest {

	@Test
	public void testGetTldUri1() throws IOException {
		URL url = TldURIUtilTest.class.getResource("dependencies/test_1.tld");

		Assert.assertEquals("This is a test.", TldURIUtil.getTldURI(url));
	}

	@Test
	public void testGetTldUri2() throws IOException {
		URL url = TldURIUtilTest.class.getResource("dependencies/test_2.tld");

		Assert.assertEquals("This is a test.", TldURIUtil.getTldURI(url));
	}

	@Test
	public void testGetTldUri3() throws IOException {
		URL url = TldURIUtilTest.class.getResource("dependencies/test_3.tld");

		Assert.assertNull(TldURIUtil.getTldURI(url));
	}

	@Test
	public void testGetTldUri4() throws IOException {
		URL url = TldURIUtilTest.class.getResource("dependencies/test_4.tld");

		Assert.assertNull(TldURIUtil.getTldURI(url));
	}

}