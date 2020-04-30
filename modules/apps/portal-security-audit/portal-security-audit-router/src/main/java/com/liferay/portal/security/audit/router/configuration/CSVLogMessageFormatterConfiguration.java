/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit.router.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Brian Greenwald
 * @author Prathima Shreenath
 */
@ExtendedObjectClassDefinition(category = "audit")
@Meta.OCD(
	id = "com.liferay.portal.security.audit.router.configuration.CSVLogMessageFormatterConfiguration",
	localization = "content/Language",
	name = "csv-log-message-formatter-configuration-name"
)
public interface CSVLogMessageFormatterConfiguration {

	@Meta.AD(
		deflt = "additionalInfo|className|classPK|clientHost|clientIP|companyId|eventType|message|serverName|serverPort|sessionID|timestamp|userId|userName",
		name = "columns", required = false
	)
	public String[] columns();

}