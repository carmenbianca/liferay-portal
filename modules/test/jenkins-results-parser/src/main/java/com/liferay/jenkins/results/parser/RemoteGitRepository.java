/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public interface RemoteGitRepository extends GitRepository {

	public String getHostname();

	public String getRemoteURL();

	public String getUsername();

}