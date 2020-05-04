/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.dependency;

import com.liferay.registry.BasicRegistryImpl;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceReference;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class ClassServiceDependencyVerifierTest {

	@Before
	public void setUp() {
		RegistryUtil.setRegistry(null);
		RegistryUtil.setRegistry(new BasicRegistryImpl());
	}

	@Test
	public void testVerifyImplementations() {
		Registry registry = RegistryUtil.getRegistry();

		registry.registerService(TestInstance1.class, new TestInstance1());
		registry.registerService(TestInterface2.class, new TestInstance2());

		ServiceReference<?> serviceReference = registry.getServiceReference(
			TestInstance1.class);

		ClassServiceDependencyVerifier classServiceDependencyVerifier1 =
			new ClassServiceDependencyVerifier(TestInstance1.class);

		Assert.assertTrue(
			classServiceDependencyVerifier1.verify(serviceReference));

		ClassServiceDependencyVerifier classServiceDependencyVerifier2 =
			new ClassServiceDependencyVerifier(TestInterface1.class);

		Assert.assertTrue(
			classServiceDependencyVerifier2.verify(serviceReference));
	}

	@Test
	public void testVerifyInterfaces() {
		Registry registry = RegistryUtil.getRegistry();

		registry.registerService(TestInterface1.class, new TestInstance1());
		registry.registerService(TestInterface2.class, new TestInstance2());

		ServiceReference<?> serviceReference1 = registry.getServiceReference(
			TestInterface1.class);
		ServiceReference<?> serviceReference2 = registry.getServiceReference(
			TestInterface2.class);
		ServiceReference<?> serviceReference3 = registry.getServiceReference(
			TestInterface2.class);

		ClassServiceDependencyVerifier classServiceDependencyVerifier =
			new ClassServiceDependencyVerifier(TestInstance1.class);

		Assert.assertTrue(
			classServiceDependencyVerifier.verify(serviceReference1));
		Assert.assertFalse(
			classServiceDependencyVerifier.verify(serviceReference2));

		ClassServiceDependencyVerifier classServiceDependencyVerifier2 =
			new ClassServiceDependencyVerifier(TestInstance2.class);

		Assert.assertTrue(
			classServiceDependencyVerifier2.verify(serviceReference2));

		ClassServiceDependencyVerifier classServiceDependencyVerifier3 =
			new ClassServiceDependencyVerifier(TestInstance3.class);

		Assert.assertFalse(
			classServiceDependencyVerifier3.verify(serviceReference3));
	}

	private static class TestInstance1 implements TestInterface1 {
	}

	private static class TestInstance2 implements TestInterface2 {
	}

	private static class TestInstance3
		implements TestInterface1, TestInterface2 {
	}

	private interface TestInterface1 {
	}

	private interface TestInterface2 {
	}

}