/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.validator;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public interface AssetEntryValidator {

	public default void validate(
			long groupId, String className, long classPK, long classTypePK,
			long[] categoryIds, String[] entryNames)
		throws PortalException {

		validate(groupId, className, classTypePK, categoryIds, entryNames);
	}

	public void validate(
			long groupId, String className, long classTypePK,
			long[] categoryIds, String[] entryNames)
		throws PortalException;

}