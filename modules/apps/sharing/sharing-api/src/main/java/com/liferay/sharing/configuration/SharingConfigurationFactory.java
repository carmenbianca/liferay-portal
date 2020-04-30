/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.configuration;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;

/**
 * @author Adolfo Pérez
 */
public interface SharingConfigurationFactory {

	public SharingConfiguration getCompanySharingConfiguration(Company company);

	public SharingConfiguration getGroupSharingConfiguration(Group group);

	public SharingConfiguration getSystemSharingConfiguration();

}