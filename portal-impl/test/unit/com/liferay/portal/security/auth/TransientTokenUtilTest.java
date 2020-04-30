/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.uuid.PortalUUIDImpl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class TransientTokenUtilTest {

	@BeforeClass
	public static void setUpClass() {
		PortalUUIDUtil portalUUIDUtil = new PortalUUIDUtil();

		portalUUIDUtil.setPortalUUID(new PortalUUIDImpl());
	}

	@Test
	public void testCheckTokenExpired() throws Exception {
		String tokenString = TransientTokenUtil.createToken(10);

		Thread.sleep(20);

		Assert.assertFalse(TransientTokenUtil.checkToken(tokenString));
	}

	@Test
	public void testCheckTokenNotExist() {
		Assert.assertFalse(TransientTokenUtil.checkToken("test1"));
		Assert.assertFalse(TransientTokenUtil.checkToken("test2"));
	}

	@Test
	public void testCheckTokenValid() {
		String tokenString = TransientTokenUtil.createToken(100);

		Assert.assertTrue(TransientTokenUtil.checkToken(tokenString));
	}

	@Test
	public void testClearAll() {
		String tokenString = TransientTokenUtil.createToken(100);

		Assert.assertTrue(TransientTokenUtil.checkToken(tokenString));

		TransientTokenUtil.clearAll();

		Assert.assertFalse(TransientTokenUtil.checkToken(tokenString));
	}

}