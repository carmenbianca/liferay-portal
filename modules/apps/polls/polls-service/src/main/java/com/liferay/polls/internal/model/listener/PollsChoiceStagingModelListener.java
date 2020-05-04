/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.internal.model.listener;

import com.liferay.polls.model.PollsChoice;
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
public class PollsChoiceStagingModelListener
	extends BaseModelListener<PollsChoice> {

	@Override
	public void onAfterCreate(PollsChoice pollsChoice)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(pollsChoice);
	}

	@Override
	public void onAfterRemove(PollsChoice pollsChoice)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(pollsChoice);
	}

	@Override
	public void onAfterUpdate(PollsChoice pollsChoice)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(pollsChoice);
	}

	@Reference
	private StagingModelListener<PollsChoice> _stagingModelListener;

}