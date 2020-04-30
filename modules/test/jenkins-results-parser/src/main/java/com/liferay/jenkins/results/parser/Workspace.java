/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public interface Workspace {

	public void addJenkinsWorkspaceGitRepository(String jenkinsGitHubURL);

	public WorkspaceGitRepository getJenkinsWorkspaceGitRepository();

	public void setBuildData(BuildData buildData);

	public void setJob(Job job);

	public void setUp();

	public void tearDown();

}