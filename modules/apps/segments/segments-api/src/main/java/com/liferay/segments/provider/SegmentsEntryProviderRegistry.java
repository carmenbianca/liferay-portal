/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.provider;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.segments.context.Context;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eduardo García
 */
@ProviderType
public interface SegmentsEntryProviderRegistry {

	public long[] getSegmentsEntryClassPKs(
			long segmentsEntryId, int start, int end)
		throws PortalException;

	public int getSegmentsEntryClassPKsCount(long segmentsEntryId)
		throws PortalException;

	public default long[] getSegmentsEntryIds(
			long groupId, String className, long classPK)
		throws PortalException {

		return getSegmentsEntryIds(groupId, className, classPK, null);
	}

	public long[] getSegmentsEntryIds(
			long groupId, String className, long classPK, Context context)
		throws PortalException;

	public SegmentsEntryProvider getSegmentsEntryProvider(String source);

}