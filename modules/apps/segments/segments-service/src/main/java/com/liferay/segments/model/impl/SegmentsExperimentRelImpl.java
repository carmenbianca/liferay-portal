/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.segments.constants.SegmentsExperienceConstants;
import com.liferay.segments.model.SegmentsExperience;
import com.liferay.segments.model.SegmentsExperiment;
import com.liferay.segments.service.SegmentsExperienceLocalServiceUtil;
import com.liferay.segments.service.SegmentsExperimentLocalServiceUtil;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The extended model implementation for the SegmentsExperimentRel service.
 * Represents a row in the &quot;SegmentsExperimentRel&quot; database table,
 * with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the <code>com.liferay.segments.model.SegmentsExperimentRel</code>
 * interface.
 * </p>
 *
 * @author Eduardo García
 */
public class SegmentsExperimentRelImpl extends SegmentsExperimentRelBaseImpl {

	public SegmentsExperimentRelImpl() {
	}

	@Override
	public String getName(Locale locale) throws PortalException {
		if (isControl()) {
			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, SegmentsExperienceConstants.class);

			return LanguageUtil.get(resourceBundle, "variant-control");
		}

		SegmentsExperience segmentsExperience =
			SegmentsExperienceLocalServiceUtil.getSegmentsExperience(
				getSegmentsExperienceId());

		return segmentsExperience.getName(locale);
	}

	@Override
	public String getSegmentsExperienceKey() {
		SegmentsExperience segmentsExperience =
			SegmentsExperienceLocalServiceUtil.fetchSegmentsExperience(
				getSegmentsExperienceId());

		if (segmentsExperience != null) {
			return segmentsExperience.getSegmentsExperienceKey();
		}

		return SegmentsExperienceConstants.KEY_DEFAULT;
	}

	@Override
	public String getSegmentsExperimentKey() throws PortalException {
		SegmentsExperiment segmentsExperiment =
			SegmentsExperimentLocalServiceUtil.getSegmentsExperiment(
				getSegmentsExperimentId());

		return segmentsExperiment.getSegmentsExperimentKey();
	}

	@Override
	public boolean isActive() throws PortalException {
		if (SegmentsExperienceConstants.ID_DEFAULT ==
				getSegmentsExperienceId()) {

			return true;
		}

		SegmentsExperience segmentsExperience =
			SegmentsExperienceLocalServiceUtil.getSegmentsExperience(
				getSegmentsExperienceId());

		return segmentsExperience.isActive();
	}

	@Override
	public boolean isControl() throws PortalException {
		SegmentsExperiment segmentsExperiment =
			SegmentsExperimentLocalServiceUtil.getSegmentsExperiment(
				getSegmentsExperimentId());

		if (getSegmentsExperienceId() ==
				segmentsExperiment.getSegmentsExperienceId()) {

			return true;
		}

		return false;
	}

}