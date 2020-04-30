/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.comparator.ElementComparator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Hugo Huijser
 */
public class XMLLookAndFeelFileCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("-look-and-feel.xml")) {
			_checkLookAndFeelXML(fileName, content);
		}

		return content;
	}

	private void _checkLookAndFeelXML(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		List<Element> themeElements = rootElement.elements("theme");

		for (Element themeElement : themeElements) {
			checkElementOrder(
				fileName, themeElement, "portlet-decorator", null,
				new ElementComparator("id"));

			Element settingsElement = themeElement.element("settings");

			checkElementOrder(
				fileName, settingsElement, "setting", null,
				new ElementComparator("key"));
		}
	}

}