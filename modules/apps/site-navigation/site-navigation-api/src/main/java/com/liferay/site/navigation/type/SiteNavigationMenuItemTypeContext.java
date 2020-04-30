/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.type;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;

import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Pavel Savinov
 */
@ProviderType
public interface SiteNavigationMenuItemTypeContext {

	public Company getCompany();

	public Optional<Group> getGroupOptional();

}