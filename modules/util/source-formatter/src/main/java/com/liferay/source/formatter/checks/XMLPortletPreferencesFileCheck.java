/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.comparator.ElementComparator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Hugo Huijser
 */
public class XMLPortletPreferencesFileCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("portlet-preferences.xml")) {
			_checkPortletPreferencesXML(fileName, content);
		}

		return content;
	}

	private void _checkPortletPreferencesXML(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		checkElementOrder(
			fileName, document.getRootElement(), "preference", null,
			new PortletPreferenceElementComparator());

		Matcher matcher = _incorrectDefaultPreferencesFileName.matcher(
			fileName);

		if (matcher.find()) {
			String correctFileName =
				matcher.group(1) + "-default-portlet-preferences.xml";

			addMessage(fileName, "Rename file to " + correctFileName);
		}
	}

	private static final Pattern _incorrectDefaultPreferencesFileName =
		Pattern.compile("/default-([\\w-]+)-portlet-preferences\\.xml$");

	private class PortletPreferenceElementComparator extends ElementComparator {

		@Override
		public String getElementName(Element preferenceElement) {
			Element nameElement = preferenceElement.element(getNameAttribute());

			return nameElement.getStringValue();
		}

	}

}