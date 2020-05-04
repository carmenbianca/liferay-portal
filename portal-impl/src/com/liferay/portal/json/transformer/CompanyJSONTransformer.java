/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json.transformer;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONContext;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;

/**
 * @author Igor Spasic
 */
public class CompanyJSONTransformer extends ObjectTransformer {

	@Override
	public void transform(JSONContext jsonContext, Object object) {
		Company company = (Company)object;

		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		if ((permissionChecker == null) ||
			!permissionChecker.isCompanyAdmin(company.getCompanyId())) {

			company.setKey(StringPool.BLANK);
			company.setKeyObj(null);
		}

		super.transform(jsonContext, object);
	}

}