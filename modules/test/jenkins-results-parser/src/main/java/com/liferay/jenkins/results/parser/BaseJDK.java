/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public abstract class BaseJDK implements JDK {

	@Override
	public String getJavaHome() {
		return JenkinsResultsParserUtil.combine(
			getJavaHomeRoot(), "/", getName());
	}

	protected String getJavaHomeRoot() {
		return "/opt/java";
	}

}