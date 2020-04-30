/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.view.count;

import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Preston Crary
 */
@ProviderType
public interface ViewCountManager {

	public void deleteViewCount(long companyId, long classNameId, long classPK)
		throws PortalException;

	public long getViewCount(long companyId, long classNameId, long classPK);

	public void incrementViewCount(
		long companyId, long classNameId, long classPK, int increment);

}