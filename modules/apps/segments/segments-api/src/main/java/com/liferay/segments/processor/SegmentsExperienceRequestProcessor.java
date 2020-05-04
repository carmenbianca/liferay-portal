/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.processor;

import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides methods for processing {@link
 * com.liferay.segments.model.SegmentsExperiment SegmentsExperiment}s.
 *
 * @author Eduardo García
 * @review
 */
@ProviderType
public interface SegmentsExperienceRequestProcessor {

	/**
	 * Returns the processed IDs of segments experiences that will be actually
	 * applied in the current request.
	 *
	 * @param  httpServletRequest the servlet request
	 * @param  httpServletResponse the servlet response
	 * @param  groupId the primary key of the group
	 * @param  classNameId the entity's class name ID
	 * @param  classPK the primary key of the entity
	 * @param  segmentsEntryIds the primary keys of the user's active segment
	 *         entries
	 * @param  segmentsExperienceIds the primary keys of the user's active
	 *         segment experiences
	 * @return the processed IDs of segments experiences that will be actually
	 *         applied in the current request
	 * @throws PortalException if a portal exception occurred
	 */
	public long[] getSegmentsExperienceIds(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, long groupId,
			long classNameId, long classPK, long[] segmentsEntryIds,
			long[] segmentsExperienceIds)
		throws PortalException;

}