/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.exportimport.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.security.ldap.configuration.CompanyScopedConfiguration;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(
	category = "ldap", factoryInstanceLabelAttribute = "companyId",
	scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(
	factory = true,
	id = "com.liferay.portal.security.ldap.exportimport.configuration.LDAPExportConfiguration",
	localization = "content/Language", name = "ldap-export-configuration-name"
)
public interface LDAPExportConfiguration extends CompanyScopedConfiguration {

	@Meta.AD(deflt = "0", name = "company-id", required = false)
	@Override
	public long companyId();

	@Meta.AD(
		deflt = "false", description = "export-enabled-help",
		name = "export-enabled", required = false
	)
	public boolean exportEnabled();

	@Meta.AD(
		deflt = "true", description = "export-group-enabled-help",
		name = "export-group-enabled", required = false
	)
	public boolean exportGroupEnabled();

}