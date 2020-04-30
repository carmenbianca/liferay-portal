/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public class JDK8 extends BaseJDK {

	@Override
	public String getAntOpts() {
		String antOpts = System.getenv("ANT_OPTS");

		return antOpts.replace("PermSize", "MetaspaceSize");
	}

	@Override
	public String getName() {
		return "jdk8";
	}

}