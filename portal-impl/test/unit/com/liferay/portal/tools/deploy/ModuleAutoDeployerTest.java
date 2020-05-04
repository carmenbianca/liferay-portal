/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.deploy;

import com.liferay.portal.deploy.auto.ModuleAutoDeployer;
import com.liferay.portal.kernel.deploy.auto.context.AutoDeploymentContext;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.util.PropsUtil;

import java.io.File;

import java.text.MessageFormat;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Gregory Amerson
 */
public class ModuleAutoDeployerTest extends BaseDeployerTestCase {

	@Override
	public BaseDeployer getDeployer() {
		return new ModuleAutoDeployer();
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();

		PropsUtil.removeProperties(PropsUtil.getProperties());

		String moduleFrameworkAutoDeployDirs = MessageFormat.format(
			"{0},{1}", getConfigsDir(), getModulesDir());

		PropsUtil.set(
			PropsKeys.MODULE_FRAMEWORK_AUTO_DEPLOY_DIRS,
			moduleFrameworkAutoDeployDirs);
	}

	@Test
	public void testDeployJARToModules() throws Exception {
		BaseDeployer baseDeployer = getDeployer();

		AutoDeploymentContext autoDeploymentContext =
			new AutoDeploymentContext();

		File jarFile = File.createTempFile("some", ".jar");

		autoDeploymentContext.setFile(jarFile);

		baseDeployer.deployFile(autoDeploymentContext);

		File deployedJarFile = new File(getModulesDir(), jarFile.getName());

		Assert.assertTrue(deployedJarFile.exists());
	}

	protected File getConfigsDir() {
		return new File(getRootDir(), "configs");
	}

	protected File getModulesDir() {
		return new File(getRootDir(), "modules");
	}

}