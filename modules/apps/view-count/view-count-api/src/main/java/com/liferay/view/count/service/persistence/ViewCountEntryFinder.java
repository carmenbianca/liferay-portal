/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.view.count.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Preston Crary
 * @generated
 */
@ProviderType
public interface ViewCountEntryFinder {

	public void incrementViewCount(
		long companyId, long classNameId, long classPK, int increment);

}