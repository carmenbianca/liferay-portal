/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public class StandaloneTopLevelBuild extends TopLevelBuild {

	public StandaloneTopLevelBuild(String url) {
		super(url);
	}

	public StandaloneTopLevelBuild(String url, TopLevelBuild topLevelBuild) {
		super(url, topLevelBuild);
	}

	@Override
	public String getResult() {
		String result = super.getResult();

		if ((getParentBuild() == null) && (result == null)) {
			result = "SUCCESS";
		}

		return result;
	}

}