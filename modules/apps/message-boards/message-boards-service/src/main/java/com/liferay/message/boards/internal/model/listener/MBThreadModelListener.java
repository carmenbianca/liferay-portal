/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.model.listener;

import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBThreadFlagLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = ModelListener.class)
public class MBThreadModelListener extends BaseModelListener<MBThread> {

	@Override
	public void onBeforeRemove(MBThread mbThread)
		throws ModelListenerException {

		_mbThreadFlagLocalService.deleteThreadFlagsByThreadId(
			mbThread.getThreadId());
	}

	@Reference
	private MBThreadFlagLocalService _mbThreadFlagLocalService;

}