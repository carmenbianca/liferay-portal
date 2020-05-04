/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public interface PortalBuildData extends BuildData {

	public String getPortalBranchSHA();

	public String getPortalGitHubBranchName();

	public String getPortalGitHubRepositoryName();

	public String getPortalGitHubURL();

	public String getPortalGitHubUsername();

	public String getPortalUpstreamBranchName();

	public void setPortalBranchSHA(String portalBranchSHA);

	public void setPortalGitHubURL(String portalGitHubURL);

	public void setPortalUpstreamBranchName(String portalUpstreamBranchName);

	public final String NAME_PORTAL_UPSTREAM_BRANCH_DEFAULT = "master";

	public final String URL_PORTAL_GITHUB_BRANCH_DEFAULT =
		"https://github.com/liferay/liferay-portal/tree/master";

}