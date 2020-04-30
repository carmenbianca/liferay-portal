/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.web.internal.dao.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.segments.model.SegmentsEntry;
import com.liferay.segments.service.SegmentsEntryRoleLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Pei-Jung Lan
 */
public class SegmentsEntryRoleChecker extends EmptyOnClickRowChecker {

	public SegmentsEntryRoleChecker(
		RenderResponse renderResponse, long roleId) {

		super(renderResponse);

		_roleId = roleId;
	}

	@Override
	public boolean isChecked(Object obj) {
		SegmentsEntry segmentsEntry = (SegmentsEntry)obj;

		return SegmentsEntryRoleLocalServiceUtil.hasSegmentEntryRole(
			segmentsEntry.getSegmentsEntryId(), _roleId);
	}

	@Override
	public boolean isDisabled(Object obj) {
		return isChecked(obj);
	}

	private final long _roleId;

}