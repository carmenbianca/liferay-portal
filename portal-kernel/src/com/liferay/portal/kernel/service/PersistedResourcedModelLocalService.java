/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;

import java.util.List;

/**
 * @author Daniel Kocsis
 */
public interface PersistedResourcedModelLocalService
	extends PersistedModelLocalService {

	public List<? extends PersistedModel> getPersistedModel(
			long resourcePrimKey)
		throws PortalException;

}