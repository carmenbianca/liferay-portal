/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelListener.class)
public class LayoutStagingModelListener extends BaseModelListener<Layout> {

	@Override
	public void onAfterCreate(Layout layout) throws ModelListenerException {
		_stagingModelListener.onAfterCreate(layout);
	}

	@Override
	public void onAfterRemove(Layout layout) throws ModelListenerException {
		_stagingModelListener.onAfterRemove(layout);
	}

	@Override
	public void onAfterUpdate(Layout layout) throws ModelListenerException {
		_stagingModelListener.onAfterUpdate(layout);
	}

	@Reference
	private StagingModelListener<Layout> _stagingModelListener;

}