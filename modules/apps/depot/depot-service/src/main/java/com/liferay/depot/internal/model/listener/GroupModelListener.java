/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.internal.model.listener;

import com.liferay.depot.service.DepotEntryGroupRelLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(service = ModelListener.class)
public class GroupModelListener extends BaseModelListener<Group> {

	@Override
	public void onBeforeRemove(Group group) throws ModelListenerException {
		super.onBeforeRemove(group);

		if (!group.isSite()) {
			return;
		}

		_depotEntryGroupRelLocalService.deleteToGroupDepotEntryGroupRels(
			group.getGroupId());
	}

	@Reference
	private DepotEntryGroupRelLocalService _depotEntryGroupRelLocalService;

}