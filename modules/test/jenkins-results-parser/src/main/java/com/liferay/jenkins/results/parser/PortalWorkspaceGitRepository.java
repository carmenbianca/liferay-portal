/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.util.Properties;

/**
 * @author Michael Hashimoto
 */
public interface PortalWorkspaceGitRepository extends WorkspaceGitRepository {

	public void setPortalAppServerProperties(Properties properties);

	public void setPortalBuildProperties(Properties properties);

	public void setPortalReleaseProperties(Properties properties);

	public void setPortalSQLProperties(Properties properties);

	public void setPortalTestProperties(Properties properties);

}