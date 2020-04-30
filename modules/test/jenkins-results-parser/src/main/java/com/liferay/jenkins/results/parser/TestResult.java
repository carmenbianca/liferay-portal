/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import org.dom4j.Element;

/**
 * @author Kenji Heigel
 */
public interface TestResult {

	public Build getBuild();

	public String getClassName();

	public String getDisplayName();

	public long getDuration();

	public String getErrorDetails();

	public String getErrorStackTrace();

	public Element getGitHubElement();

	public String getPackageName();

	public String getSimpleClassName();

	public String getStatus();

	public String getTestName();

	public String getTestReportURL();

	public boolean isFailing();

}