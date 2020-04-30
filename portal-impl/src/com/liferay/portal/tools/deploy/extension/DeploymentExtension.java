/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.deploy.extension;

import com.liferay.portal.tools.deploy.BaseDeployer;

import java.io.File;

/**
 * @author Shuyang Zhou
 */
public interface DeploymentExtension {

	public void copyXmls(BaseDeployer baseDeployer, File srcFile)
		throws Exception;

	public String getServerId();

	public void postDeploy(String destDir, String deployDir) throws Exception;

}