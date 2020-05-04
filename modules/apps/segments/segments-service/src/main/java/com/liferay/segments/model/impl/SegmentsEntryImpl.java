/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.model.impl;

import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.segments.criteria.Criteria;
import com.liferay.segments.criteria.CriteriaSerializer;
import com.liferay.segments.model.SegmentsEntryRole;
import com.liferay.segments.service.SegmentsEntryRoleLocalServiceUtil;

import java.util.List;

/**
 * @author Eduardo García
 */
public class SegmentsEntryImpl extends SegmentsEntryBaseImpl {

	public SegmentsEntryImpl() {
	}

	@Override
	public Criteria getCriteriaObj() {
		if ((_criteria == null) && Validator.isNotNull(getCriteria())) {
			_criteria = CriteriaSerializer.deserialize(getCriteria());
		}

		return _criteria;
	}

	@Override
	public long[] getRoleIds() {
		List<SegmentsEntryRole> segmentsEntryRoles =
			SegmentsEntryRoleLocalServiceUtil.getSegmentsEntryRoles(
				getSegmentsEntryId());

		return ListUtil.toLongArray(
			segmentsEntryRoles, SegmentsEntryRole::getRoleId);
	}

	private Criteria _criteria;

}