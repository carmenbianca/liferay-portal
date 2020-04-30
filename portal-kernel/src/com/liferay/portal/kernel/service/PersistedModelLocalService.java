/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface PersistedModelLocalService {

	public default PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public default BasePersistence<?> getBasePersistence() {
		throw new UnsupportedOperationException();
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

}