/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface CTProcessFinder {

	public java.util.List<com.liferay.change.tracking.model.CTProcess>
		findByC_U_N_D_S(
			long companyId, long userId, String keywords, int status, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<?>
				orderByComparator);

}