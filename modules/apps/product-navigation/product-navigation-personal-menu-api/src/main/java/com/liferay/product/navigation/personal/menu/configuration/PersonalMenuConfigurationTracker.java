/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.personal.menu.configuration;

/**
 * @author Samuel Trong Tran
 */
public interface PersonalMenuConfigurationTracker {

	public PersonalMenuConfiguration getCompanyPersonalMenuConfiguration(
		long companyId);

}