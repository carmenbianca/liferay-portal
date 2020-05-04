/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.PortletContainer;
import com.liferay.portlet.internal.PortletContainerImpl;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Akos Thurzo
 */
public class SecurityPortletContainerWrapperTest {

	@Test
	public void testIsValidPortletId() {
		PortletContainer portletContainer = new PortletContainerImpl();

		SecurityPortletContainerWrapper securityPortletContainerWrapper =
			new SecurityPortletContainerWrapper(portletContainer);

		Assert.assertTrue(
			securityPortletContainerWrapper.isValidPortletId("aaa"));
		Assert.assertTrue(
			securityPortletContainerWrapper.isValidPortletId("AAA"));
		Assert.assertTrue(
			securityPortletContainerWrapper.isValidPortletId("123"));
		Assert.assertTrue(
			securityPortletContainerWrapper.isValidPortletId("aA1"));
		Assert.assertTrue(
			securityPortletContainerWrapper.isValidPortletId("aaa_bbb"));
		Assert.assertTrue(
			securityPortletContainerWrapper.isValidPortletId("aaa#bbb"));
		Assert.assertFalse(
			securityPortletContainerWrapper.isValidPortletId(
				"2_INSTANCE_'\"><script>alert(1)</script>"));
	}

}