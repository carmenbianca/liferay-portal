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
public class XMLDDLStructuresFileCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("structures.xml")) {
			_checkDDLStructuresXML(fileName, content);
		}

		return content;
	}

	private void _checkDDLStructuresXML(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		checkElementOrder(
			fileName, rootElement, "structure", null,
			new StructureElementComparator());

		List<Element> structureElements = rootElement.elements("structure");

		for (Element structureElement : structureElements) {
			Element structureRootElement = structureElement.element("root");

			checkElementOrder(
				fileName, structureRootElement, "dynamic-element", "root",
				new ElementComparator());

			List<Element> dynamicElementElements =
				structureRootElement.elements("dynamic-element");

			for (Element dynamicElementElement : dynamicElementElements) {
				Element metaDataElement = dynamicElementElement.element(
					"meta-data");

				checkElementOrder(
					fileName, metaDataElement, "entry", "meta-data",
					new ElementComparator());
			}
		}
	}

	private static class StructureElementComparator extends ElementComparator {

		@Override
		public String getElementName(Element element) {
			return getTagValue(element);
		}

	}

}