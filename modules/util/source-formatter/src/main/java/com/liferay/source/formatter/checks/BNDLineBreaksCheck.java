/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.checks.util.BNDSourceUtil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class BNDLineBreaksCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		int pos = fileName.lastIndexOf(StringPool.SLASH);

		String shortFileName = fileName.substring(pos + 1);

		return _formatLineBreaks(shortFileName, content);
	}

	private String _formatLineBreaks(
		String content, Map<String, String> definitionsKeysMap) {

		if (definitionsKeysMap == null) {
			return content;
		}

		for (Map.Entry<String, String> entry : definitionsKeysMap.entrySet()) {
			String definitionKey = entry.getValue();

			Pattern pattern = Pattern.compile(" " + definitionKey + ":");

			Matcher matcher = pattern.matcher(content);

			if (matcher.find()) {
				return StringUtil.replaceFirst(
					content, " ", "\n", matcher.start());
			}
		}

		return content;
	}

	private String _formatLineBreaks(String shortFileName, String content) {
		content = _formatLineBreaks(
			content, BNDSourceUtil.getDefinitionKeysMap());

		Map<String, Map<String, String>> fileSpecificDefinitionKeysMap =
			BNDSourceUtil.getFileSpecificDefinitionKeysMap();

		return _formatLineBreaks(
			content, fileSpecificDefinitionKeysMap.get(shortFileName));
	}

}