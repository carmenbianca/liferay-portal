/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.Properties;

/**
 * @author Peter Shin
 * @author Hugo Huijser
 */
public class PropertiesLanguageKeysCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		if (!fileName.endsWith("/content/Language.properties")) {
			return content;
		}

		StringBundler sb = new StringBundler();

		Properties portalImplLanguageProperties =
			_getPortalImplLanguageProperties(absolutePath);

		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new UnsyncStringReader(content))) {

			String line = null;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				String[] array = line.split("=", 2);

				if (array.length < 2) {
					sb.append(line);
					sb.append("\n");

					continue;
				}

				String key = array[0];
				String value = array[1];

				if ((portalImplLanguageProperties != null) &&
					!absolutePath.contains("/modules/dxp/apps/") &&
					!absolutePath.contains("/modules/private/apps/")) {

					String portalImplValue =
						portalImplLanguageProperties.getProperty(key);

					if (value.equals(portalImplValue)) {
						continue;
					}
				}

				if (!_isAllowedLanguageKey(key, absolutePath) &&
					value.matches("(?s).*<([a-zA-Z0-9]+)[^>]*>.*?<\\/\\1>.*")) {

					addMessage(
						fileName, "Remove HTML markup for '" + key + "'",
						getLineNumber(content, content.indexOf(line)));
				}

				sb.append(line);
				sb.append("\n");
			}
		}

		content = sb.toString();

		if (content.endsWith("\n")) {
			content = content.substring(0, content.length() - 1);
		}

		return content;
	}

	private Properties _getPortalImplLanguageProperties(String absolutePath)
		throws IOException {

		if (absolutePath.endsWith(_PORTAL_IMPL_LANGUAGE_PROPERTIES_FILE_NAME)) {
			return null;
		}

		if (_portalImplLanguageProperties != null) {
			return _portalImplLanguageProperties;
		}

		Properties portalImplLanguageProperties = new Properties();

		InputStream inputStream = getPortalInputStream(
			_PORTAL_IMPL_LANGUAGE_PROPERTIES_FILE_NAME, absolutePath);

		if (inputStream != null) {
			portalImplLanguageProperties.load(inputStream);
		}

		_portalImplLanguageProperties = portalImplLanguageProperties;

		return _portalImplLanguageProperties;
	}

	private boolean _isAllowedLanguageKey(String key, String absolutePath) {
		String s = key.replaceAll("[^\\w.-]", StringPool.BLANK);

		List<String> allowedLanguageKeys = getAttributeValues(
			_ALLOWED_LANGUAGE_KEYS_KEY, absolutePath);

		for (String allowedLanguageKey : allowedLanguageKeys) {
			if (s.equals(allowedLanguageKey)) {
				return true;
			}
		}

		return false;
	}

	private static final String _ALLOWED_LANGUAGE_KEYS_KEY =
		"allowedLanguageKeys";

	private static final String _PORTAL_IMPL_LANGUAGE_PROPERTIES_FILE_NAME =
		"portal-impl/src/content/Language.properties";

	private Properties _portalImplLanguageProperties;

}