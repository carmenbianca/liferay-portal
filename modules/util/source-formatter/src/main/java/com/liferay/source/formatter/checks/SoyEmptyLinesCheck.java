/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

/**
 * @author Peter Shin
 */
public class SoyEmptyLinesCheck extends BaseEmptyLinesCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return fixEmptyLinesBetweenTags(content);
	}

}