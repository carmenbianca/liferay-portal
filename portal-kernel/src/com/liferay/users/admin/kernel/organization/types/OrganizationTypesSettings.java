/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.kernel.organization.types;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Marco Leo
 */
@ProviderType
public interface OrganizationTypesSettings {

	public String[] getChildrenTypes(String type);

	public String[] getTypes();

	public boolean isCountryEnabled(String type);

	public boolean isCountryRequired(String type);

	public boolean isRootable(String type);

}