/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.admin.web.internal.configuration.util;

import com.liferay.layout.page.template.admin.web.internal.configuration.ExportImportDisplayPageConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Rubén Pulido
 */
@Component(
	configurationPid = "com.liferay.layout.page.template.admin.web.internal.configuration.ExportImportDisplayPageConfiguration",
	immediate = true, service = ExportImportDisplayPageConfigurationUtil.class
)
public class ExportImportDisplayPageConfigurationUtil {

	public static boolean enabled() {
		return _exportImportDisplayPageConfiguration.enabled();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_exportImportDisplayPageConfiguration =
			ConfigurableUtil.createConfigurable(
				ExportImportDisplayPageConfiguration.class, properties);
	}

	private static volatile ExportImportDisplayPageConfiguration
		_exportImportDisplayPageConfiguration;

}