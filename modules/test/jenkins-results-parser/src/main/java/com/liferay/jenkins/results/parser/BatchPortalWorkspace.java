/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public class BatchPortalWorkspace extends BasePortalWorkspace {

	protected BatchPortalWorkspace(
		String portalGitHubURL, String portalUpstreamBranchName,
		String portalBranchSHA) {

		super(portalGitHubURL, portalUpstreamBranchName, portalBranchSHA);
	}

}