/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.social.service.impl;

import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.registry.BasicRegistryImpl;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceRegistration;
import com.liferay.social.kernel.model.SocialActivityInterpreter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Leon Chi
 */
public class SocialActivityInterpreterLocalServiceImplTest {

	@BeforeClass
	public static void setUpClass() {
		RegistryUtil.setRegistry(new BasicRegistryImpl());

		Registry registry = RegistryUtil.getRegistry();

		_socialActivityInterpreterLocalServiceImpl =
			new SocialActivityInterpreterLocalServiceImpl();

		_socialActivityInterpreterLocalServiceImpl.afterPropertiesSet();

		_serviceRegistration = registry.registerService(
			SocialActivityInterpreter.class,
			(SocialActivityInterpreter)ProxyUtil.newProxyInstance(
				SocialActivityInterpreter.class.getClassLoader(),
				new Class<?>[] {SocialActivityInterpreter.class},
				(proxy, method, args) -> {
					if (Objects.equals(method.getName(), "getClassNames")) {
						return _CLASS_NAMES;
					}

					if (Objects.equals(method.getName(), "getSelector")) {
						return _SELECTOR;
					}

					return null;
				}),
			Collections.singletonMap(
				"javax.portlet.name",
				"SocialActivityInterpreterLocalServiceImplTest"));
	}

	@AfterClass
	public static void tearDownClass() {
		_serviceRegistration.unregister();
	}

	@Test
	public void testGetActivityInterpreters() {
		Map<String, List<SocialActivityInterpreter>> activityInterpreters =
			_socialActivityInterpreterLocalServiceImpl.
				getActivityInterpreters();

		List<SocialActivityInterpreter> socialActivityInterpreters =
			activityInterpreters.get(_SELECTOR);

		Assert.assertEquals(
			socialActivityInterpreters.toString(), 1,
			socialActivityInterpreters.size());

		SocialActivityInterpreter socialActivityInterpreter =
			socialActivityInterpreters.get(0);

		Assert.assertSame(_SELECTOR, socialActivityInterpreter.getSelector());
		Assert.assertSame(
			_CLASS_NAMES, socialActivityInterpreter.getClassNames());
	}

	@Test
	public void testGetActivityInterpretersBySelector() {
		List<SocialActivityInterpreter> activityInterpreters =
			_socialActivityInterpreterLocalServiceImpl.getActivityInterpreters(
				_SELECTOR);

		Assert.assertEquals(
			activityInterpreters.toString(), 1, activityInterpreters.size());

		SocialActivityInterpreter socialActivityInterpreter =
			activityInterpreters.get(0);

		Assert.assertSame(_SELECTOR, socialActivityInterpreter.getSelector());
		Assert.assertSame(
			_CLASS_NAMES, socialActivityInterpreter.getClassNames());
	}

	private static final String[] _CLASS_NAMES = {
		"TestSocialActivityInterpreter"
	};

	private static final String _SELECTOR = "SELECTOR";

	private static ServiceRegistration<SocialActivityInterpreter>
		_serviceRegistration;
	private static SocialActivityInterpreterLocalServiceImpl
		_socialActivityInterpreterLocalServiceImpl;

}