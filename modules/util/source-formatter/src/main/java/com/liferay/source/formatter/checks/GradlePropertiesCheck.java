/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

/**
 * @author Peter Shin
 */
public class GradlePropertiesCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		StringBundler sb = new StringBundler();

		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new UnsyncStringReader(content))) {

			String line = null;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				String[] array = line.split(StringPool.EQUAL, 2);

				if (array.length == 2) {
					String key = array[0].trim();

					if (ArrayUtil.contains(_KEYS_WITH_QUOTED_VALUE, key)) {
						String value = array[1].trim();

						String strippedValue = StringUtil.removeChars(
							value, CharPool.APOSTROPHE, CharPool.QUOTE);

						line = StringUtil.replaceLast(
							line, value, "\"" + strippedValue + "\"");
					}
				}

				sb.append(line);
				sb.append("\n");
			}
		}

		if (sb.length() > 0) {
			sb.setIndex(sb.index() - 1);
		}

		return sb.toString();
	}

	private static final String[] _KEYS_WITH_QUOTED_VALUE = {
		"sourceCompatibility", "targetCompatibility"
	};

}