/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.segments.model.SegmentsEntry;

import java.io.IOException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eduardo García
 */
@ProviderType
public interface SegmentsEntryDemoDataCreator {

	public SegmentsEntry create(long userId, long groupId)
		throws IOException, PortalException;

	public void delete() throws PortalException;

}