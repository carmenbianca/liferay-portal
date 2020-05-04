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
public interface AssetVocabularyFinder {

	public int countByG_N(long groupId, String name);

	public int filterCountByG_N(long groupId, String name);

	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		filterFindByG_N(
			long groupId, String name, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.asset.kernel.model.AssetVocabulary> obc);

	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		findByG_N(
			long groupId, String name, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.asset.kernel.model.AssetVocabulary> obc);

}