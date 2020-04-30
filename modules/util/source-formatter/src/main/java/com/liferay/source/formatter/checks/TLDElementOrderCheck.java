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
public class TLDElementOrderCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		_checkElementOrder(fileName, content);

		return content;
	}

	private void _checkElementOrder(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		List<Element> tagElements = rootElement.elements("tag");

		for (Element tagElement : tagElements) {
			Element nameElement = tagElement.element("name");

			checkElementOrder(
				fileName, tagElement, "attribute", nameElement.getText(),
				new TagElementComparator());
		}

		checkElementOrder(
			fileName, rootElement, "tag", null, new TagElementComparator());
	}

	private static class TagElementComparator extends ElementComparator {

		@Override
		public String getElementName(Element element) {
			return getTagValue(element);
		}

	}

}