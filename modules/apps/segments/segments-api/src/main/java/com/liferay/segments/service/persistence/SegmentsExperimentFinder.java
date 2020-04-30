/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eduardo Garcia
 * @generated
 */
@ProviderType
public interface SegmentsExperimentFinder {

	public int countByS_C_C_S(
		long segmentsExperienceId, long classNameId, long classPK,
		int[] statuses);

	public java.util.List<com.liferay.segments.model.SegmentsExperiment>
		findByS_C_C_S(
			long segmentsExperienceId, long classNameId, long classPK,
			int[] statuses, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.segments.model.SegmentsExperiment>
					orderByComparator);

}