/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSONPropertyOrderCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return _sortProperties(content);
	}

	private String _mergeProperties(List<String> properties) {
		StringBundler sb = new StringBundler(2 * properties.size());

		for (String property : properties) {
			sb.append(property);
			sb.append(",\n");
		}

		sb.setIndex(sb.index() - 1);

		return sb.toString();
	}

	private String _sortProperties(String content) {
		String tabs = StringPool.BLANK;

		while (true) {
			Pattern pattern1 = Pattern.compile(
				"(\n|^)" + tabs + "[^\n\t]*[\\{\\[]\n");

			Matcher matcher1 = pattern1.matcher(content);

			if (!matcher1.find()) {
				break;
			}

			Pattern pattern2 = Pattern.compile(
				StringBundler.concat(
					"((\n|^)", tabs, "[^\n\t]*\\{\n", tabs,
					"\t[^\n\t][\\s\\S]*?)\n", tabs, "\\}"));

			Matcher matcher2 = pattern2.matcher(content);

			while (matcher2.find()) {
				Pattern pattern3 = Pattern.compile(
					StringBundler.concat(
						"(", tabs,
						"\t[^\n\t]*?([^\\{\\[]|([\\{\\[]\n[\\s\\S]*?\n", tabs,
						"\t[\\}\\]]))),?(\n|$)"));

				String match = matcher2.group(1);

				Matcher matcher3 = pattern3.matcher(match);

				List<String> properties = new ArrayList<>();
				StringBundler sb = new StringBundler();

				while (matcher3.find()) {
					sb.append(matcher3.group());

					String s = StringUtil.trimTrailing(matcher3.group());

					if (s.endsWith(",")) {
						s = s.substring(0, s.length() - 1);
					}

					properties.add(s);
				}

				if (!properties.isEmpty()) {
					properties = ListUtil.sort(properties);

					content = StringUtil.replace(
						content, sb.toString(), _mergeProperties(properties));
				}
			}

			tabs += "\t";
		}

		return content;
	}

}