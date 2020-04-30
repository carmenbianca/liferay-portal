/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.deploy;

import com.liferay.portal.kernel.deploy.auto.context.AutoDeploymentContext;
import com.liferay.portal.kernel.plugin.PluginPackage;

import java.util.List;
import java.util.Properties;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 * @author Ryan Park
 */
public interface DeployManager {

	public void deploy(AutoDeploymentContext autoDeploymentContext)
		throws Exception;

	public String getDeployDir() throws Exception;

	public String getInstalledDir() throws Exception;

	public PluginPackage getInstalledPluginPackage(String context);

	public List<PluginPackage> getInstalledPluginPackages();

	public List<String[]> getLevelsRequiredDeploymentContexts();

	public List<String[]> getLevelsRequiredDeploymentWARFileNames();

	public boolean isDeployed(String context);

	public boolean isRequiredDeploymentContext(String context);

	public PluginPackage readPluginPackageProperties(
		String displayName, Properties properties);

	public PluginPackage readPluginPackageXml(String xml) throws Exception;

	public void redeploy(String context) throws Exception;

	public void undeploy(String context) throws Exception;

}