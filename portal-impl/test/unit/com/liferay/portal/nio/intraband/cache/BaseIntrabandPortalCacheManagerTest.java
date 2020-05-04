/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.nio.intraband.cache;

import com.liferay.portal.kernel.cache.PortalCacheManager;
import com.liferay.portal.kernel.nio.intraband.RegistrationReference;
import com.liferay.portal.kernel.nio.intraband.proxy.ExceptionHandler;
import com.liferay.portal.kernel.nio.intraband.test.MockIntraband;
import com.liferay.portal.kernel.nio.intraband.test.MockRegistrationReference;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.nio.intraband.proxy.IntrabandProxyUtil;
import com.liferay.portal.nio.intraband.proxy.WarnLogExceptionHandler;
import com.liferay.portal.util.FileImpl;

import java.lang.reflect.Constructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class BaseIntrabandPortalCacheManagerTest {

	@Test
	public void testStubGeneration() throws Exception {
		FileUtil fileUtil = new FileUtil();

		fileUtil.setFile(new FileImpl());

		Class<?> stubClass = IntrabandProxyUtil.getStubClass(
			BaseIntrabandPortalCacheManager.class,
			PortalCacheManager.class.getName());

		Constructor<?> constructor = stubClass.getConstructor(
			String.class, RegistrationReference.class, ExceptionHandler.class);

		PortalCacheManager<?, ?> portalCacheManager =
			(PortalCacheManager<?, ?>)constructor.newInstance(
				"PortalCacheManager",
				new MockRegistrationReference(new MockIntraband()),
				WarnLogExceptionHandler.INSTANCE);

		Assert.assertNotNull(portalCacheManager.getPortalCache("PortalCache"));
	}

}