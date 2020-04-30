/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.personal.menu.web.internal.configuration.definition;

import com.liferay.configuration.admin.definition.ConfigurationDDMFormDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Samuel Trong Tran
 */
@Component(
	immediate = true,
	property = "configurationPid=com.liferay.product.navigation.personal.menu.configuration.PersonalMenuConfiguration",
	service = ConfigurationDDMFormDeclaration.class
)
public class PersonalMenuConfigurationDDMFormDeclaration
	implements ConfigurationDDMFormDeclaration {

	@Override
	public Class<?> getDDMFormClass() {
		return PersonalMenuConfigurationForm.class;
	}

}