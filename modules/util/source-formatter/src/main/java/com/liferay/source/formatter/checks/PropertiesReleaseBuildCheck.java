/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import java.io.IOException;
import java.io.StringReader;

import java.util.Properties;

/**
 * @author Hugo Huijser
 */
public class PropertiesReleaseBuildCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		if (!absolutePath.endsWith("/release.properties")) {
			return content;
		}

		Properties properties = new Properties();

		properties.load(new StringReader(content));

		String releaseInfoBuildValue = properties.getProperty(
			"release.info.build");

		if (releaseInfoBuildValue == null) {
			return content;
		}

		String releaseInfoContent = getPortalContent(
			"portal-kernel/src/com/liferay/portal/kernel/util/ReleaseInfo.java",
			absolutePath);

		if (!releaseInfoContent.contains(releaseInfoBuildValue)) {
			addMessage(
				fileName,
				"release.info.build '" + releaseInfoBuildValue +
					"' does not exist in ReleaseInfo.java");
		}

		return content;
	}

}