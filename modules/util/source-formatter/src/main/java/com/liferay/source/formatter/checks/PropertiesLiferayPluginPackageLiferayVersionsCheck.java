/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Shin
 */
public class PropertiesLiferayPluginPackageLiferayVersionsCheck
	extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		if (fileName.endsWith("/liferay-plugin-package.properties")) {
			return _fixIncorrectLiferayVersions(absolutePath, content);
		}

		return content;
	}

	private String _fixIncorrectLiferayVersions(
			String absolutePath, String content)
		throws IOException {

		if (!isPortalSource() || !isModulesApp(absolutePath, false)) {
			return content;
		}

		Matcher matcher = _liferayVersionsPattern.matcher(content);

		if (!matcher.find()) {
			return content;
		}

		boolean privateApp = isModulesApp(absolutePath, true);

		String portalVersion = getPortalVersion(privateApp);

		if (Validator.isNull(portalVersion)) {
			return content;
		}

		return StringUtil.replace(
			content, "liferay-versions=" + matcher.group(1),
			"liferay-versions=" + portalVersion + "+", matcher.start());
	}

	private static final Pattern _liferayVersionsPattern = Pattern.compile(
		"\nliferay-versions=(.*)\n");

}