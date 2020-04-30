/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @deprecated As of Mueller (7.2.x), replaced by {@link
 com.liferay.layout.service.persistence.impl.LayoutClassedModelUsageFinderImpl}
 * @generated
 */
@Deprecated
@ProviderType
public interface AssetEntryUsageFinder {

	public int countByAssetEntryId(long assetEntryId);

}