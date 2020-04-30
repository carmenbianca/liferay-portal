/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.poller;

import com.liferay.portal.kernel.poller.PollerProcessor;
import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.registry.BasicRegistryImpl;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceRegistration;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Leon Chi
 */
public class PollerProcessorUtilTest {

	@Test
	public void testGetPollerProcessor() {
		PollerProcessor pollerProcessor = ProxyFactory.newDummyInstance(
			PollerProcessor.class);

		RegistryUtil.setRegistry(new BasicRegistryImpl());

		Registry registry = RegistryUtil.getRegistry();

		ServiceRegistration<PollerProcessor> serviceRegistration =
			registry.registerService(
				PollerProcessor.class, pollerProcessor,
				Collections.singletonMap(
					"javax.portlet.name", _TEST_PORTLET_ID));

		try {
			Assert.assertSame(
				pollerProcessor,
				PollerProcessorUtil.getPollerProcessor(_TEST_PORTLET_ID));
		}
		finally {
			serviceRegistration.unregister();
		}
	}

	private static final String _TEST_PORTLET_ID = "TEST_PORTLET_ID";

}