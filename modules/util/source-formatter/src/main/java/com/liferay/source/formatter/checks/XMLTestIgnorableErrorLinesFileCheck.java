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
public class XMLTestIgnorableErrorLinesFileCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("/test-ignorable-error-lines.xml")) {
			_checkTestIgnorableErrorLinesXml(fileName, content);
		}

		return content;
	}

	private void _checkTestIgnorableErrorLinesXml(
			String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		List<Element> javascriptElements = rootElement.elements("javascript");

		for (Element javascriptElement : javascriptElements) {
			checkElementOrder(
				fileName, javascriptElement, "ignore-error", null,
				new ElementComparator("description"));
		}

		List<Element> logElements = rootElement.elements("log");

		for (Element logElement : logElements) {
			checkElementOrder(
				fileName, logElement, "ignore-error", null,
				new ElementComparator("description"));
		}
	}

}