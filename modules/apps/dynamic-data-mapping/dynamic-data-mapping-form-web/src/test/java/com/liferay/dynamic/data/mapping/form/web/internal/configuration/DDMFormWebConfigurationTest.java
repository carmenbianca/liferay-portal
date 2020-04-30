/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.util.HashMapDictionary;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pedro Queiroz
 */
public class DDMFormWebConfigurationTest {

	@Test
	public void testCreateDefaultDDMFormWebConfiguration() {
		DDMFormWebConfiguration ddmFormWebConfiguration =
			ConfigurableUtil.createConfigurable(
				DDMFormWebConfiguration.class, new HashMapDictionary<>());

		Assert.assertEquals(1, ddmFormWebConfiguration.autosaveInterval());
		Assert.assertEquals(
			"enabled-with-warning", ddmFormWebConfiguration.csvExport());
		Assert.assertEquals(
			"list", ddmFormWebConfiguration.defaultDisplayView());
	}

}