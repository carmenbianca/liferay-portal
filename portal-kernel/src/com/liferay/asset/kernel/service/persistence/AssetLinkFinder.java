/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface AssetLinkFinder {

	public java.util.List<com.liferay.asset.kernel.model.AssetLink>
		findByAssetEntryGroupId(long groupId, int start, int end);

	public java.util.List<com.liferay.asset.kernel.model.AssetLink> findByG_C(
		long groupId, java.util.Date startDate, java.util.Date endDate,
		int start, int end);

	public java.util.List<com.liferay.asset.kernel.model.AssetLink> findByC_C(
		long classNameId, long classPK);

}