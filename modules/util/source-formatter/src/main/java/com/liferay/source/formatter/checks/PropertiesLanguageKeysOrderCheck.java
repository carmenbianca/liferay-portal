/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.NaturalOrderStringComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Peter Shin
 */
public class PropertiesLanguageKeysOrderCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		if (!fileName.endsWith("/content/Language.properties")) {
			return content;
		}

		int x = absolutePath.lastIndexOf("/");

		File dir = new File(absolutePath.substring(0, x + 1));

		File[] files = dir.listFiles(
			new FilenameFilter() {

				public boolean accept(File dir, String name) {
					String s = StringUtil.toLowerCase(name);

					if (!s.startsWith("language_") ||
						!s.endsWith(".properties")) {

						return false;
					}

					return true;
				}

			});

		if (files.length > 1) {
			return content;
		}

		StringBundler sb = new StringBundler();

		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new UnsyncStringReader(content))) {

			Map<String, String> messagesMap = new TreeMap<>(
				new NaturalOrderStringComparator(true, true));

			String line = null;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				String[] array = line.split("=", 2);

				if (array.length > 1) {
					messagesMap.put(array[0], array[1]);

					continue;
				}

				for (Map.Entry<String, String> entry : messagesMap.entrySet()) {
					sb.append(entry.getKey());
					sb.append(StringPool.EQUAL);
					sb.append(entry.getValue());
					sb.append("\n");
				}

				if (!messagesMap.isEmpty()) {
					messagesMap.clear();
				}

				sb.append(line);
				sb.append("\n");
			}

			for (Map.Entry<String, String> entry : messagesMap.entrySet()) {
				sb.append(entry.getKey());
				sb.append(StringPool.EQUAL);
				sb.append(entry.getValue());
				sb.append("\n");
			}

			if (!messagesMap.isEmpty()) {
				messagesMap.clear();
			}
		}

		return StringUtil.trim(sb.toString());
	}

}