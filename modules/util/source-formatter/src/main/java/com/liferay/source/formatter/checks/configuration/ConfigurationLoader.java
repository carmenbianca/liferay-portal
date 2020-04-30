/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks.configuration;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.io.IOException;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author Hugo Huijser
 */
public class ConfigurationLoader {

	public static SourceFormatterConfiguration loadConfiguration(
			String fileName)
		throws DocumentException, IOException {

		SourceFormatterConfiguration sourceFormatterConfiguration =
			new SourceFormatterConfiguration();

		ClassLoader classLoader = ConfigurationLoader.class.getClassLoader();

		String content = StringUtil.read(
			classLoader.getResourceAsStream(fileName));

		Document document = SourceUtil.readXML(content);

		Element rootElement = document.getRootElement();

		for (Element sourceProcessorElement :
				(List<Element>)rootElement.elements("source-processor")) {

			String sourceProcessorName = sourceProcessorElement.attributeValue(
				"name");

			for (Element checkElement :
					(List<Element>)sourceProcessorElement.elements("check")) {

				SourceCheckConfiguration sourceCheckConfiguration =
					new SourceCheckConfiguration(
						checkElement.attributeValue("name"));

				for (Element propertyElement :
						(List<Element>)checkElement.elements("property")) {

					sourceCheckConfiguration.addAttribute(
						propertyElement.attributeValue("name"),
						propertyElement.attributeValue("value"));
				}

				sourceFormatterConfiguration.addSourceCheckConfiguration(
					sourceProcessorName, sourceCheckConfiguration);
			}
		}

		return sourceFormatterConfiguration;
	}

}