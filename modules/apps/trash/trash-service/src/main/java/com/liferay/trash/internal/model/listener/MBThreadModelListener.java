/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.internal.model.listener;

import com.liferay.message.boards.model.MBThread;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.trash.service.TrashEntryLocalService;
import com.liferay.trash.service.TrashVersionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = ModelListener.class)
public class MBThreadModelListener extends BaseModelListener<MBThread> {

	@Override
	public void onBeforeRemove(MBThread mbThread)
		throws ModelListenerException {

		if (mbThread.isInTrashExplicitly()) {
			_trashEntryLocalService.deleteEntry(
				MBThread.class.getName(), mbThread.getThreadId());
		}
		else {
			_trashVersionLocalService.deleteTrashVersion(
				MBThread.class.getName(), mbThread.getThreadId());
		}
	}

	@Reference
	private TrashEntryLocalService _trashEntryLocalService;

	@Reference
	private TrashVersionLocalService _trashVersionLocalService;

}