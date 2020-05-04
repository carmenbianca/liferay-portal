/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.configuration;

import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;

import java.util.Map;
import java.util.Properties;

import org.junit.Test;

/**
 * @author André de Oliveira
 */
public class ElasticsearchConfigurationTest {

	@Test
	public void testConfigurationsFromBuildTestXmlAntFile() throws Exception {
		Map<String, Object> configurationProperties =
			loadConfigurationProperties(
				"ElasticsearchConfigurationTest-build-test-xml.cfg");

		Class<? extends ElasticsearchConfigurationTest> clazz = getClass();

		ElasticsearchFixture elasticsearchFixture = new ElasticsearchFixture(
			clazz.getSimpleName(), configurationProperties);

		try {
			elasticsearchFixture.createNode();
		}
		finally {
			elasticsearchFixture.destroyNode();
		}
	}

	protected Map<String, Object> loadConfigurationProperties(String fileName)
		throws Exception {

		Properties properties = new Properties();

		Class<?> clazz = getClass();

		properties.load(clazz.getResourceAsStream(fileName));

		return PropertiesUtil.toMap(properties);
	}

}