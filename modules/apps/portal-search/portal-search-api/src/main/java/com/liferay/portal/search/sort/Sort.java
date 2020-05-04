/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.sort;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface Sort {

	public <T> T accept(SortVisitor<T> sortVisitor);

	public SortOrder getSortOrder();

	public void setSortOrder(SortOrder sortOrder);

}