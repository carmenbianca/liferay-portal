/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.admin.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Rubén Pulido
 */
@ExtendedObjectClassDefinition(generateUI = false)
@Meta.OCD(
	id = "com.liferay.layout.page.template.admin.web.internal.configuration.ExportImportMasterLayoutConfiguration"
)
public interface ExportImportMasterLayoutConfiguration {

	@Meta.AD(deflt = "false", required = false)
	public boolean enabled();

}