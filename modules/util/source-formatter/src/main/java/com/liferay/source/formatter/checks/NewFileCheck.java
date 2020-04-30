/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.util.SourceFormatterUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class NewFileCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		List<String> forbiddenDirNames = getAttributeValues(
			_FORBIDDEN_DIR_NAMES_KEY, absolutePath);

		if (forbiddenDirNames.isEmpty()) {
			return content;
		}

		String portalBranchName = getAttributeValue(
			SourceFormatterUtil.GIT_LIFERAY_PORTAL_BRANCH, absolutePath);

		for (String forbiddenDirName : forbiddenDirNames) {
			int pos = absolutePath.indexOf(forbiddenDirName);

			if (pos == -1) {
				continue;
			}

			try {
				URL url = SourceFormatterUtil.getPortalGitURL(
					absolutePath.substring(pos), portalBranchName);

				url.openStream();
			}
			catch (FileNotFoundException fileNotFoundException) {
				addMessage(
					fileName,
					"Do not add new files to '" + forbiddenDirName + "'");
			}
			catch (IOException ioException) {
			}
		}

		return content;
	}

	private static final String _FORBIDDEN_DIR_NAMES_KEY = "forbiddenDirNames";

}