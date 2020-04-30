/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringPool;

/**
 * @author Peter Shin
 */
public class PropertiesServiceKeysCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (!fileName.endsWith("/service.properties")) {
			return content;
		}

		for (String legacyServiceKey : _LEGACY_SERVICE_KEYS) {
			content = content.replaceAll(
				"(\\A|\n)\\s*" + legacyServiceKey + "=.*(\\Z|\n)",
				StringPool.NEW_LINE);
		}

		return content;
	}

	private static final String[] _LEGACY_SERVICE_KEYS = {"build.auto.upgrade"};

}