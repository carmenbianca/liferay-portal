/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.application;

import com.liferay.depot.application.DepotApplication;
import com.liferay.trash.constants.TrashPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(immediate = true, service = DepotApplication.class)
public class TrashDepotApplication implements DepotApplication {

	@Override
	public String getPortletId() {
		return TrashPortletKeys.TRASH;
	}

	@Override
	public boolean isCustomizable() {
		return false;
	}

}