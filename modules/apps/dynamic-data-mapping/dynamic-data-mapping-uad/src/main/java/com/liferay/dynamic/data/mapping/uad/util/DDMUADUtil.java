/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.uad.util;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.xml.SecureXMLFactoryProviderUtil;
import com.liferay.portal.kernel.util.Time;

import java.io.IOException;
import java.io.StringReader;

import java.util.Date;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author Gabriel Ibson
 * @author Marcos Martins
 */
public class DDMUADUtil {

	public static void formatCreateDate(Map<String, Object> fieldValues) {
		Date createdDate = (Date)fieldValues.get("createDate");

		if (createdDate != null) {
			fieldValues.put(
				"createDate",
				Time.getSimpleDate(createdDate, "MMM dd yyyy 'at' HH:mm"));
		}
	}

	public static String getFormattedName(DDMFormInstance ddmFormInstance) {
		Document document = _toDocument(ddmFormInstance.getName());

		Node firstChildNode = document.getFirstChild();

		return firstChildNode.getTextContent();
	}

	private static Document _toDocument(String xml) {
		try {
			DocumentBuilderFactory documentBuilderFactory =
				SecureXMLFactoryProviderUtil.newDocumentBuilderFactory();

			DocumentBuilder documentBuilder =
				documentBuilderFactory.newDocumentBuilder();

			return documentBuilder.parse(
				new InputSource(new StringReader(xml)));
		}
		catch (IOException | ParserConfigurationException | SAXException
					exception) {

			_log.error(exception, exception);
		}

		return null;
	}

	private static final Log _log = LogFactoryUtil.getLog(DDMUADUtil.class);

}