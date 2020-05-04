/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.model.listener;

import com.liferay.knowledge.base.model.KBComment;
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
public class KBCommentStagingModelListener
	extends BaseModelListener<KBComment> {

	@Override
	public void onAfterCreate(KBComment kbComment)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(kbComment);
	}

	@Override
	public void onAfterRemove(KBComment kbComment)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(kbComment);
	}

	@Override
	public void onAfterUpdate(KBComment kbComment)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(kbComment);
	}

	@Reference
	private StagingModelListener<KBComment> _stagingModelListener;

}