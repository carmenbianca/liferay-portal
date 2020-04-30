/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public interface JDK {

	public String getAntOpts();

	public String getJavaHome();

	public String getName();

}