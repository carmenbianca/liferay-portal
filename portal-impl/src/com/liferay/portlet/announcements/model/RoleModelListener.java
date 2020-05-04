/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.announcements.model;

import com.liferay.announcements.kernel.service.AnnouncementsEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Role;

/**
 * @author Christopher Kian
 */
public class RoleModelListener extends BaseModelListener<Role> {

	@Override
	public void onBeforeRemove(Role role) throws ModelListenerException {
		try {
			AnnouncementsEntryLocalServiceUtil.deleteEntries(
				role.getClassNameId(), role.getRoleId());
		}
		catch (Exception exception) {
			throw new ModelListenerException(exception);
		}
	}

}