/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.web.internal.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Daniel Kocsis
 */
public class ExportImportWebConfigurationValues {

	public static final int DRAFT_EXPORT_IMPORT_CONFIGURATION_CHECK_INTERVAL =
		GetterUtil.getInteger(
			ExportImportWebConfigurationUtil.get(
				"draft.export.import.configuration.check.interval"));

	public static int DRAFT_EXPORT_IMPORT_CONFIGURATION_CLEAN_UP_COUNT =
		GetterUtil.getInteger(
			ExportImportWebConfigurationUtil.get(
				"draft.export.import.configuration.clean.up.count"));

}