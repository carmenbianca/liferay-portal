/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.comparator.ElementComparator;
import com.liferay.source.formatter.checks.util.SourceUtil;

import org.dom4j.Document;
import org.dom4j.DocumentException;

/**
 * @author Hugo Huijser
 */
public class XMLLog4jFileCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("-log4j-ext.xml") ||
			fileName.endsWith("-log4j.xml")) {

			_checkLog4jXML(fileName, content);
		}

		return content;
	}

	private void _checkLog4jXML(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		checkElementOrder(
			fileName, document.getRootElement(), "category", null,
			new ElementComparator(true));
	}

}