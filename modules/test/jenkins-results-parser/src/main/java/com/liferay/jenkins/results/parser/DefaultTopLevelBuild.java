/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Peter Yoo
 */
public class DefaultTopLevelBuild extends TopLevelBuild {

	public DefaultTopLevelBuild(String url) {
		super(url);
	}

	public DefaultTopLevelBuild(String url, TopLevelBuild topLevelBuild) {
		super(url, topLevelBuild);
	}

	@Override
	public String getResult() {
		String result = super.getResult();

		if (!downstreamBuilds.isEmpty() && (result == null)) {
			boolean hasFailure = false;

			for (Build downstreamBuild : downstreamBuilds) {
				String downstreamBuildResult = downstreamBuild.getResult();

				if (downstreamBuildResult == null) {
					setResult(null);

					return null;
				}

				if (!downstreamBuildResult.equals("SUCCESS")) {
					hasFailure = true;
				}
			}

			if (result == null) {
				if (hasFailure) {
					return "FAILURE";
				}

				return "SUCCESS";
			}
		}

		return super.getResult();
	}

}