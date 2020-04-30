/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.test.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Eudaldo Alonso
 */
public class TrashTestUtil {

	public static Group disableTrash(Group group) {
		UnicodeProperties typeSettingsUnicodeProperties =
			group.getParentLiveGroupTypeSettingsProperties();

		typeSettingsUnicodeProperties.setProperty(
			"trashEnabled", StringPool.FALSE);

		group.setTypeSettingsProperties(typeSettingsUnicodeProperties);

		return GroupLocalServiceUtil.updateGroup(group);
	}

}