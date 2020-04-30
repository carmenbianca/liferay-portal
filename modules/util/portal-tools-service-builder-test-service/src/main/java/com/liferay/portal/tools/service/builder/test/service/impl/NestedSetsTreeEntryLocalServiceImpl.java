/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.service.impl;

import com.liferay.portal.tools.service.builder.test.model.NestedSetsTreeEntry;
import com.liferay.portal.tools.service.builder.test.service.base.NestedSetsTreeEntryLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class NestedSetsTreeEntryLocalServiceImpl
	extends NestedSetsTreeEntryLocalServiceBaseImpl {

	@Override
	public NestedSetsTreeEntry addNestedSetsTreeEntry(long groupId) {
		long nestedSetsTreeEntryId = counterLocalService.increment();

		NestedSetsTreeEntry nestedSetsTreeEntry = createNestedSetsTreeEntry(
			nestedSetsTreeEntryId);

		nestedSetsTreeEntry.setGroupId(groupId);
		nestedSetsTreeEntry.setParentNestedSetsTreeEntryId(0);

		addNestedSetsTreeEntry(nestedSetsTreeEntry);

		return nestedSetsTreeEntry;
	}

}