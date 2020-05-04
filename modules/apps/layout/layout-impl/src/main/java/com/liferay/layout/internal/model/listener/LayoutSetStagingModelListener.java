/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelListener.class)
public class LayoutSetStagingModelListener
	extends BaseModelListener<LayoutSet> {

	@Override
	public void onAfterCreate(LayoutSet layoutSet)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(layoutSet);
	}

	@Override
	public void onAfterRemove(LayoutSet layoutSet)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(layoutSet);
	}

	@Override
	public void onAfterUpdate(LayoutSet layoutSet)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(layoutSet);
	}

	@Reference
	private StagingModelListener<LayoutSet> _stagingModelListener;

}