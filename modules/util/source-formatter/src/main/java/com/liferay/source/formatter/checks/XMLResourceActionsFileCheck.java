/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringPool;
import com.liferay.source.formatter.checks.comparator.ElementComparator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Hugo Huijser
 */
public class XMLResourceActionsFileCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.contains("/resource-actions/")) {
			_checkResourceActionXML(fileName, content, "model");
			_checkResourceActionXML(fileName, content, "portlet");
		}

		return content;
	}

	private void _checkResourceActionXML(
			String fileName, String content, String type)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		List<Element> resourceElements = rootElement.elements(
			type + "-resource");

		for (Element resourceElement : resourceElements) {
			Element nameElement = resourceElement.element(type + "-name");

			String name = StringPool.BLANK;

			if (nameElement != null) {
				name = nameElement.getText();
			}

			Element compositeModelNameElement = resourceElement.element(
				"composite-model-name");

			checkElementOrder(
				fileName, compositeModelNameElement, "model-name", name,
				new ResourceActionNameElementComparator());

			Element portletRefElement = resourceElement.element("portlet-ref");

			checkElementOrder(
				fileName, portletRefElement, "portlet-name", name,
				new ResourceActionNameElementComparator());

			Element permissionsElement = resourceElement.element("permissions");

			if (permissionsElement == null) {
				continue;
			}

			List<Element> permissionsChildElements =
				permissionsElement.elements();

			for (Element permissionsChildElement : permissionsChildElements) {
				checkElementOrder(
					fileName, permissionsChildElement, "action-key", name,
					new ResourceActionNameElementComparator());
			}
		}

		checkElementOrder(
			fileName, rootElement, type + "-resource", null,
			new ResourceActionResourceElementComparator(type + "-name"));
	}

	private class ResourceActionNameElementComparator
		extends ElementComparator {

		@Override
		public String getElementName(Element actionNameElement) {
			return actionNameElement.getStringValue();
		}

	}

	private class ResourceActionResourceElementComparator
		extends ElementComparator {

		public ResourceActionResourceElementComparator(String nameAttribute) {
			super(nameAttribute);
		}

		@Override
		public String getElementName(Element portletResourceElement) {
			return getTagValue(portletResourceElement);
		}

	}

}