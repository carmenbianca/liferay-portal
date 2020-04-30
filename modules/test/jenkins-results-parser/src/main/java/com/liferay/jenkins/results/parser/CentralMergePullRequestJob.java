/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Leslie Wong
 */
public class CentralMergePullRequestJob extends PortalAcceptancePullRequestJob {

	public CentralMergePullRequestJob(String url) {
		super(url, "relevant");
	}

}