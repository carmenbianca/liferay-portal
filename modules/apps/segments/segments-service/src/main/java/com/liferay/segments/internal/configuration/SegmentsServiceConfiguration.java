/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author David Arques
 */
@ExtendedObjectClassDefinition(category = "segments")
@Meta.OCD(
	id = "com.liferay.segments.internal.configuration.SegmentsServiceConfiguration",
	localization = "content/Language",
	name = "segments-service-configuration-name"
)
public interface SegmentsServiceConfiguration {

	@Meta.AD(
		deflt = "true", description = "segmentation-enabled-description",
		name = "segmentation-enabled-name", required = false
	)
	public boolean segmentationEnabled();

	@Meta.AD(
		deflt = "120",
		description = "segments-preview-check-interval-description",
		name = "segments-preview-check-interval", required = false
	)
	public int segmentsPreviewCheckInterval();

}