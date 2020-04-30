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
public interface AssetEntryFinder {

	public int countEntries(AssetEntryQuery entryQuery);

	public java.util.List<com.liferay.asset.kernel.model.AssetEntry>
		findEntries(AssetEntryQuery entryQuery);

	public double findPriorityByC_C(long classNameId, long classPK);

}