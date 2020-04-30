/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public interface BuildRunner<T extends BuildData, S extends Workspace> {

	public T getBuildData();

	public S getWorkspace();

	public void run();

	public void setUp();

	public void tearDown();

}