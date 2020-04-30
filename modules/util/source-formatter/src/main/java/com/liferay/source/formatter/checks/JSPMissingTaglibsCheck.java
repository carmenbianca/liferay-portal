/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.checks.util.JSPSourceUtil;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSPMissingTaglibsCheck extends BaseJSPTermsCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		if (absolutePath.contains("/custom_jsps/") ||
			absolutePath.contains("-fragment/")) {

			return content;
		}

		_checkMissingTaglibs(fileName, content);

		return content;
	}

	private void _checkMissingTaglibs(String fileName, String content)
		throws IOException {

		Set<String> taglibPrefixes = _getTaglibPrefixes(content);

		if (taglibPrefixes.isEmpty()) {
			return;
		}

		populateContentsMap(fileName, content);

		List<String> dependentfileNames = new ArrayList<>();

		dependentfileNames.add(fileName);

		Map<String, String> contentsMap = getContentsMap();

		dependentfileNames = JSPSourceUtil.addIncludedAndReferencedFileNames(
			dependentfileNames, new HashSet<String>(), contentsMap,
			".*\\.jspf");

		if (fileName.endsWith(".jspf") && (dependentfileNames.size() == 1)) {
			return;
		}

		for (String dependentfileName : dependentfileNames) {
			dependentfileName = StringUtil.replace(
				dependentfileName, CharPool.BACK_SLASH, CharPool.SLASH);

			String dependenFileContent = contentsMap.get(dependentfileName);

			if (dependenFileContent == null) {
				return;
			}

			Iterator<String> iterator = taglibPrefixes.iterator();

			while (iterator.hasNext()) {
				String prefix = iterator.next();

				if (dependenFileContent.contains("prefix=\"" + prefix + "\"")) {
					iterator.remove();

					if (taglibPrefixes.isEmpty()) {
						return;
					}
				}
			}
		}

		for (String prefix : taglibPrefixes) {
			addMessage(
				fileName,
				"Missing taglib for tag with prefix '" + prefix + "'");
		}
	}

	private Set<String> _getTaglibPrefixes(String content) {
		Set<String> taglibPrefixes = new HashSet<>();

		Matcher matcher = _tagPattern.matcher(content);

		while (matcher.find()) {
			taglibPrefixes.add(matcher.group(1));
		}

		return taglibPrefixes;
	}

	private static final Pattern _tagPattern = Pattern.compile(
		"<(aui|c|chart|clay|display|liferay(-[\\w-]+)|portlet|soy):");

}