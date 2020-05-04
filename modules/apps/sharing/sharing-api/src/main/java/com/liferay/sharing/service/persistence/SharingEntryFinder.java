/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface SharingEntryFinder {

	public int countByUserId(long userId, long classNameId);

	public java.util.List<com.liferay.sharing.model.SharingEntry> findByUserId(
		long userId, long classNameId, int begin, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.sharing.model.SharingEntry> orderByComparator);

}