/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.web.internal.display.context;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.vulcan.util.TransformUtil;
import com.liferay.segments.model.SegmentsEntry;
import com.liferay.segments.provider.SegmentsEntryProviderRegistry;

import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(service = {})
public class SegmentsEntryDisplayContext {

	public static String getGroupDescriptiveName(
			SegmentsEntry segmentsEntry, Locale locale)
		throws Exception {

		Group group = _groupLocalService.fetchGroup(segmentsEntry.getGroupId());

		return group.getDescriptiveName(locale);
	}

	public static List<User> getSegmentsEntryUsers(
			long segmentsEntryId, int start, int end)
		throws Exception {

		return TransformUtil.transformToList(
			ArrayUtil.toLongArray(
				_segmentsEntryProviderRegistry.getSegmentsEntryClassPKs(
					segmentsEntryId, start, end)),
			_userLocalService::fetchUser);
	}

	public static int getSegmentsEntryUsersCount(long segmentsEntryId)
		throws Exception {

		return _segmentsEntryProviderRegistry.getSegmentsEntryClassPKsCount(
			segmentsEntryId);
	}

	@Reference(unbind = "-")
	protected void setGroupLocalService(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

	@Reference(unbind = "-")
	protected void setSegmentsEntryProviderRegistry(
		SegmentsEntryProviderRegistry segmentsEntryProviderRegistry) {

		_segmentsEntryProviderRegistry = segmentsEntryProviderRegistry;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private static GroupLocalService _groupLocalService;
	private static SegmentsEntryProviderRegistry _segmentsEntryProviderRegistry;
	private static UserLocalService _userLocalService;

}