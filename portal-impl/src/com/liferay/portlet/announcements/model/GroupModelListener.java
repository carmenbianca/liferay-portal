/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.announcements.model;

import com.liferay.announcements.kernel.service.AnnouncementsEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;

/**
 * @author Christopher Kian
 */
public class GroupModelListener extends BaseModelListener<Group> {

	@Override
	public void onBeforeRemove(Group group) throws ModelListenerException {
		try {
			if (group.isSite()) {
				AnnouncementsEntryLocalServiceUtil.deleteEntries(
					group.getClassNameId(), group.getGroupId());
			}
			else {
				AnnouncementsEntryLocalServiceUtil.deleteEntries(
					group.getClassNameId(), group.getClassPK());

				if (group.isOrganization()) {
					long classNameId = ClassNameLocalServiceUtil.getClassNameId(
						Group.class);

					AnnouncementsEntryLocalServiceUtil.deleteEntries(
						classNameId, group.getGroupId());
				}
			}
		}
		catch (Exception exception) {
			throw new ModelListenerException(exception);
		}
	}

}