/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.source.formatter.checks.comparator.ElementComparator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.io.IOException;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Hugo Huijser
 */
public class XMLCheckstyleFileCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException, IOException {

		if (fileName.endsWith("/checkstyle.xml") ||
			fileName.endsWith("/checkstyle-jsp.xml")) {

			_checkCheckstyleXML(fileName, content);
		}

		return content;
	}

	private void _checkCheckstyleXML(String fileName, String content)
		throws DocumentException, IOException {

		Document document = SourceUtil.readXML(content);

		_checkOrder(fileName, document.getRootElement());
	}

	private void _checkMissingProperty(
		String fileName, Element moduleElement, String moduleName,
		String propertyName) {

		if (true) {
			return;
		}

		for (Element propertyElement :
				(List<Element>)moduleElement.elements("property")) {

			if (propertyName.equals(propertyElement.attributeValue("name"))) {
				return;
			}
		}

		addMessage(
			fileName,
			StringBundler.concat(
				"Missing property '", propertyName, "' for check '", moduleName,
				"'"));
	}

	private void _checkOrder(String fileName, Element element) {
		checkElementOrder(
			fileName, element, "module", null, new ElementComparator());

		String moduleName = element.attributeValue("name");

		checkElementOrder(
			fileName, element, "message", moduleName,
			new ElementComparator("key"));
		checkElementOrder(
			fileName, element, "property", moduleName, new ElementComparator());

		List<Element> childModuleElements = (List<Element>)element.elements(
			"module");

		if (childModuleElements.isEmpty()) {
			_checkMissingProperty(fileName, element, moduleName, "category");
			_checkMissingProperty(fileName, element, moduleName, "description");
		}

		for (Element moduleElement : childModuleElements) {
			_checkOrder(fileName, moduleElement);
		}
	}

}