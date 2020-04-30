/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.model.impl;

import com.liferay.segments.constants.SegmentsExperimentConstants;
import com.liferay.segments.service.SegmentsExperimentLocalServiceUtil;

/**
 * @author Eduardo García
 */
public class SegmentsExperienceImpl extends SegmentsExperienceBaseImpl {

	public SegmentsExperienceImpl() {
	}

	public boolean hasSegmentsExperiment() {
		return SegmentsExperimentLocalServiceUtil.hasSegmentsExperiment(
			getSegmentsExperienceId(), getClassNameId(), getClassPK(),
			SegmentsExperimentConstants.Status.getLockedStatusValues());
	}

}