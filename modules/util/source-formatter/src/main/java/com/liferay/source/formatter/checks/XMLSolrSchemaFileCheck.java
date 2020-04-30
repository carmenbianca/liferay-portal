/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.comparator.ElementComparator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Hugo Huijser
 */
public class XMLSolrSchemaFileCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("/schema.xml") && absolutePath.contains("solr")) {
			_checkSolrSchemaXML(fileName, content);
		}

		return content;
	}

	private void _checkSolrSchemaXML(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		checkElementOrder(
			fileName, rootElement.element("fields"), "field", null,
			new ElementComparator());
		checkElementOrder(
			fileName, rootElement.element("types"), "fieldType", null,
			new ElementComparator());
	}

}