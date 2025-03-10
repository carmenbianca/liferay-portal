/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.file.install.deploy.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.test.util.ConfigurationTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.util.PropsValues;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Dictionary;
import java.util.concurrent.CountDownLatch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ManagedService;

/**
 * @author Kyle Miho
 */
@RunWith(Arquillian.class)
public class FileInstallConfigTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() {
		Bundle bundle = FrameworkUtil.getBundle(FileInstallConfigTest.class);

		_bundleContext = bundle.getBundleContext();
	}

	@After
	public void tearDown() throws Exception {
		if (_configurationPath != null) {
			Files.deleteIfExists(_configurationPath);
		}

		if (_configuration != null) {
			ConfigurationTestUtil.deleteConfiguration(_configuration);
		}
	}

	@Test
	public void testConfigurationArrayValues() throws Exception {
		String configurationPid = _CONFIGURATION_PID_PREFIX.concat(
			".testConfigurationArrayValues");

		_configurationPath = Paths.get(
			PropsValues.MODULE_FRAMEWORK_CONFIGS_DIR,
			configurationPid.concat(".config"));

		_configuration = _createConfiguration(
			configurationPid,
			StringBundler.concat(
				"configBooleanArray=B[\"True\",\"False\"]\n",
				"configByteArray=X[\"1\",\"3\"]\n",
				"configCharacterArray=C[\"A\",\"Z\"]\n",
				"configDoubleArray=D[\"12.2\",\"12.3\"]\n",
				"configFloatArray=F[\"12.2\",\"12.3\"]\n",
				"configIntegerArray=I[\"20\",\"21\"]\n",
				"configLongArray=L[\"30\",\"31\"]\n",
				"configShortArray=S[\"2\",\"3\"]\n",
				"configStringArray=T[\"testString\",\"testString2\"]\n",
				"configUntypedStringArray=[\"testUntypedString\"",
				",\"testUntypedString2\"]"));

		Dictionary<String, Object> properties = _configuration.getProperties();

		Assert.assertArrayEquals(
			new Boolean[] {true, false},
			(Boolean[])properties.get("configBooleanArray"));
		Assert.assertArrayEquals(
			new Byte[] {0b1, 0b11}, (Byte[])properties.get("configByteArray"));
		Assert.assertArrayEquals(
			new Character[] {'A', 'Z'},
			(Character[])properties.get("configCharacterArray"));
		Assert.assertArrayEquals(
			new Double[] {12.2D, 12.3D},
			(Double[])properties.get("configDoubleArray"));
		Assert.assertArrayEquals(
			new Float[] {12.2F, 12.3F},
			(Float[])properties.get("configFloatArray"));
		Assert.assertArrayEquals(
			new Integer[] {20, 21},
			(Integer[])properties.get("configIntegerArray"));
		Assert.assertArrayEquals(
			new Long[] {30L, 31L}, (Long[])properties.get("configLongArray"));
		Assert.assertArrayEquals(
			new Short[] {(short)2, (short)3},
			(Short[])properties.get("configShortArray"));
		Assert.assertArrayEquals(
			new String[] {"testString", "testString2"},
			(String[])properties.get("configStringArray"));
		Assert.assertArrayEquals(
			new String[] {"testUntypedString", "testUntypedString2"},
			(String[])properties.get("configUntypedStringArray"));
	}

	@Test
	public void testConfigurationValues() throws Exception {
		String configurationPid = _CONFIGURATION_PID_PREFIX.concat(
			".testConfigurationValues");

		_configurationPath = Paths.get(
			PropsValues.MODULE_FRAMEWORK_CONFIGS_DIR,
			configurationPid.concat(".config"));

		_configuration = _createConfiguration(
			configurationPid,
			StringBundler.concat(
				"configBoolean=B\"True\"\n", "configByte=X\"1\"\n",
				"configCharacter=C\"A\"\n", "configDouble=D\"12.2\"\n",
				"configFloat=F\"12.2\"\n", "configInteger=I\"20\"\n",
				"configLong=L\"30\"\n", "configShort=S\"2\"\n",
				"configString=T\"testString\"\n",
				"configUntypedString=\"testUntypedString\""));

		Dictionary<String, Object> properties = _configuration.getProperties();

		Assert.assertEquals(true, properties.get("configBoolean"));
		Assert.assertEquals((byte)1, properties.get("configByte"));
		Assert.assertEquals('A', properties.get("configCharacter"));
		Assert.assertEquals(12.2D, properties.get("configDouble"));
		Assert.assertEquals(12.2F, properties.get("configFloat"));
		Assert.assertEquals(20, properties.get("configInteger"));
		Assert.assertEquals(30L, properties.get("configLong"));
		Assert.assertEquals((short)2, properties.get("configShort"));
		Assert.assertEquals("testString", properties.get("configString"));
		Assert.assertEquals(
			"testUntypedString", properties.get("configUntypedString"));
	}

	private Configuration _createConfiguration(
			String configurationPid, String content)
		throws Exception {

		CountDownLatch countDownLatch = new CountDownLatch(2);

		ServiceRegistration<ManagedService> serviceRegistration =
			_bundleContext.registerService(
				ManagedService.class, props -> countDownLatch.countDown(),
				MapUtil.singletonDictionary(
					Constants.SERVICE_PID, configurationPid));

		try {
			Files.write(_configurationPath, content.getBytes());

			countDownLatch.await();
		}
		finally {
			serviceRegistration.unregister();
		}

		return _configurationAdmin.getConfiguration(
			configurationPid, StringPool.QUESTION);
	}

	private static final String _CONFIGURATION_PID_PREFIX =
		FileInstallConfigTest.class.getName() + "Configuration";

	@Inject
	private static ConfigurationAdmin _configurationAdmin;

	private BundleContext _bundleContext;
	private Configuration _configuration;
	private Path _configurationPath;

}