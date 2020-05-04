/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Hugo Huijser
 */
public class XMLPortletFileCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("/liferay-portlet.xml") ||
			((isPortalSource() || isSubrepository()) &&
			 fileName.endsWith("/portlet-custom.xml")) ||
			(!isPortalSource() && !isSubrepository() &&
			 fileName.endsWith("/portlet.xml"))) {

			_checkPortletXML(fileName, absolutePath, content);
		}

		return content;
	}

	private void _checkPortletXML(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		boolean checkNumericalPortletNameElement = !isExcludedPath(
			_NUMERICAL_PORTLET_NAME_ELEMENT_EXCLUDES, absolutePath);

		List<Element> portletElements = rootElement.elements("portlet");

		for (Element portletElement : portletElements) {
			if (checkNumericalPortletNameElement) {
				Element portletNameElement = portletElement.element(
					"portlet-name");

				String portletNameText = portletNameElement.getText();

				if (!Validator.isNumber(portletNameText)) {
					addMessage(
						fileName,
						"Nonstandard portlet-name element '" + portletNameText +
							"'");
				}
			}
		}
	}

	private static final String _NUMERICAL_PORTLET_NAME_ELEMENT_EXCLUDES =
		"numerical.portlet.name.element.excludes";

}