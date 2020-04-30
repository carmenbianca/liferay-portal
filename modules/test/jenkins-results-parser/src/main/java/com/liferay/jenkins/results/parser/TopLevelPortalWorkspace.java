/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public class TopLevelPortalWorkspace extends BasePortalWorkspace {

	protected TopLevelPortalWorkspace(
		String portalGitHubURL, String portalUpstreamBranchName) {

		super(portalGitHubURL, portalUpstreamBranchName);
	}

}