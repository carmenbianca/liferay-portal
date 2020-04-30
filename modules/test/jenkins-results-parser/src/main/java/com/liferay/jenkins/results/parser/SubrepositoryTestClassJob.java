/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Yi-Chen Tsai
 */
public interface SubrepositoryTestClassJob extends PortalTestClassJob {

	public SubrepositoryGitWorkingDirectory
		getSubrepositoryGitWorkingDirectory();

}