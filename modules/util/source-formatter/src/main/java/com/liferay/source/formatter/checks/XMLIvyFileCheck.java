/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
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
public class XMLIvyFileCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("/ivy.xml")) {
			_checkIvyXML(fileName, content);
		}

		return content;
	}

	private void _checkIvyXML(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		for (Element dependenciesElement :
				(List<Element>)rootElement.elements("dependencies")) {

			String defaultconf = dependenciesElement.attributeValue(
				"defaultconf");

			checkElementOrder(
				fileName, dependenciesElement, "dependency", defaultconf,
				new ElementComparator());
		}
	}

}