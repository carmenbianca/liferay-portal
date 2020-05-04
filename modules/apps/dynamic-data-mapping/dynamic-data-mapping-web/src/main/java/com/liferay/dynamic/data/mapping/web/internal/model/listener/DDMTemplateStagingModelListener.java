/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.web.internal.model.listener;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
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
public class DDMTemplateStagingModelListener
	extends BaseModelListener<DDMTemplate> {

	@Override
	public void onAfterCreate(DDMTemplate ddmTemplate)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(ddmTemplate);
	}

	@Override
	public void onAfterRemove(DDMTemplate ddmTemplate)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(ddmTemplate);
	}

	@Override
	public void onAfterUpdate(DDMTemplate ddmTemplate)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(ddmTemplate);
	}

	@Reference
	private StagingModelListener<DDMTemplate> _stagingModelListener;

}