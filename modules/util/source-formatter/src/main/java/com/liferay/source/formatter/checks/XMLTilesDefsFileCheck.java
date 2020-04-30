/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
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
public class XMLTilesDefsFileCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws DocumentException {

		if (fileName.endsWith("/tiles-defs.xml")) {
			_checkTilesDefsXML(fileName, content);
		}

		return content;
	}

	private void _checkTilesDefsXML(String fileName, String content)
		throws DocumentException {

		Document document = SourceUtil.readXML(content);

		checkElementOrder(
			fileName, document.getRootElement(), "definition", null,
			new TilesDefinitionElementComparator());
	}

	private class TilesDefinitionElementComparator extends ElementComparator {

		@Override
		public int compare(
			Element definitionElement1, Element definitionElement2) {

			String definitionName1 = getElementName(definitionElement1);

			if (definitionName1.equals("portlet")) {
				return -1;
			}

			return super.compare(definitionElement1, definitionElement2);
		}

	}

}