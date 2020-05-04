/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.model.listener;

import com.liferay.message.boards.model.MBThread;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelListener.class)
public class MBThreadStagingModelListener extends BaseModelListener<MBThread> {

	@Override
	public void onAfterCreate(MBThread mbThread) throws ModelListenerException {
		_stagingModelListener.onAfterCreate(mbThread);
	}

	@Override
	public void onAfterRemove(MBThread mbThread) throws ModelListenerException {
		_stagingModelListener.onAfterRemove(mbThread);
	}

	@Override
	public void onAfterUpdate(MBThread mbThread) throws ModelListenerException {
		_stagingModelListener.onAfterUpdate(mbThread);
	}

	@Reference
	private StagingModelListener<MBThread> _stagingModelListener;

}