/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.model.impl;

import com.liferay.layout.page.template.model.LayoutPageTemplateStructureRel;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureRelLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.segments.constants.SegmentsExperienceConstants;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @author Eduardo García
 */
public class LayoutPageTemplateStructureImpl
	extends LayoutPageTemplateStructureBaseImpl {

	public LayoutPageTemplateStructureImpl() {
	}

	public String getData(long segmentsExperienceId) {
		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			LayoutPageTemplateStructureRelLocalServiceUtil.
				fetchLayoutPageTemplateStructureRel(
					getLayoutPageTemplateStructureId(), segmentsExperienceId);

		if (layoutPageTemplateStructureRel != null) {
			return layoutPageTemplateStructureRel.getData();
		}

		return StringPool.BLANK;
	}

	public String getData(long[] segmentsExperienceIds) throws PortalException {
		long segmentsExperienceId = _getFirstSegmentsExperienceId(
			segmentsExperienceIds);

		return getData(segmentsExperienceId);
	}

	private long _getFirstSegmentsExperienceId(long[] segmentsExperienceIds) {
		if (segmentsExperienceIds.length == 1) {
			return segmentsExperienceIds[0];
		}

		LongStream stream = Arrays.stream(segmentsExperienceIds);

		return stream.filter(
			segmentsExperienceId -> {
				LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
					LayoutPageTemplateStructureRelLocalServiceUtil.
						fetchLayoutPageTemplateStructureRel(
							getLayoutPageTemplateStructureId(),
							segmentsExperienceId);

				return layoutPageTemplateStructureRel != null;
			}
		).findFirst(
		).orElse(
			SegmentsExperienceConstants.ID_DEFAULT
		);
	}

}