/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal.xml;

import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.UnsecureSAXReaderUtil;

import java.io.IOException;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Neil Griffin
 */
public class DisplayDescriptorParser {

	public static Map<String, String> parse(URL displayDescriptorURL)
		throws DocumentException, IOException {

		Map<String, String> displayCategoryMap = new HashMap<>();

		Document document = UnsecureSAXReaderUtil.read(
			displayDescriptorURL, true);

		Element rootElement = document.getRootElement();

		for (Element categoryElement : rootElement.elements("category")) {
			String categoryName = categoryElement.attributeValue("name");

			for (Element portletElement : categoryElement.elements("portlet")) {
				String portletId = portletElement.attributeValue("id");

				displayCategoryMap.put(portletId, categoryName);
			}
		}

		return displayCategoryMap;
	}

}