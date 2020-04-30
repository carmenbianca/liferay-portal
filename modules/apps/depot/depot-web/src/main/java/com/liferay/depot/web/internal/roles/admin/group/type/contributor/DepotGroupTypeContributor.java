/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.roles.admin.group.type.contributor;

import com.liferay.depot.configuration.DepotConfiguration;
import com.liferay.depot.model.DepotEntry;
import com.liferay.roles.admin.group.type.contributor.GroupTypeContributor;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(service = GroupTypeContributor.class)
public class DepotGroupTypeContributor implements GroupTypeContributor {

	@Override
	public String getClassName() {
		return DepotEntry.class.getName();
	}

	@Override
	public boolean isEnabled() {
		if (_depotConfiguration.isEnabled()) {
			return true;
		}

		return false;
	}

	@Reference
	private DepotConfiguration _depotConfiguration;

}