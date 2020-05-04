/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.web.internal.model.listener;

import com.liferay.mobile.device.rules.model.MDRAction;
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
public class MDRActionStagingModelListener
	extends BaseModelListener<MDRAction> {

	@Override
	public void onAfterCreate(MDRAction mdrAction)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(mdrAction);
	}

	@Override
	public void onAfterRemove(MDRAction mdrAction)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(mdrAction);
	}

	@Override
	public void onAfterUpdate(MDRAction mdrAction)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(mdrAction);
	}

	@Reference
	private StagingModelListener<MDRAction> _stagingModelListener;

}