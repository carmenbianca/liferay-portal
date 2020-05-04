/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal;

import com.liferay.change.tracking.constants.CTConstants;
import com.liferay.change.tracking.model.CTPreferences;
import com.liferay.change.tracking.service.CTPreferencesLocalService;
import com.liferay.portal.kernel.change.tracking.CTCollectionIdSupplier;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = CTCollectionIdSupplier.class)
public class CTCollectionIdSupplierImpl implements CTCollectionIdSupplier {

	@Override
	public long getCTCollectionId() {
		CTPreferences ctPreferences =
			_ctPreferencesLocalService.fetchCTPreferences(
				CompanyThreadLocal.getCompanyId(),
				PrincipalThreadLocal.getUserId());

		if (ctPreferences == null) {
			return CTConstants.CT_COLLECTION_ID_PRODUCTION;
		}

		return ctPreferences.getCtCollectionId();
	}

	@Reference
	private CTPreferencesLocalService _ctPreferencesLocalService;

}