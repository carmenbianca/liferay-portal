/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.internal.model.listener;

import com.liferay.fragment.model.FragmentCollection;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(immediate = true, service = ModelListener.class)
public class FragmentCollectionStagingModelListener
	extends BaseModelListener<FragmentCollection> {

	@Override
	public void onAfterCreate(FragmentCollection fragmentCollection)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(fragmentCollection);
	}

	@Override
	public void onAfterRemove(FragmentCollection fragmentCollection)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(fragmentCollection);
	}

	@Override
	public void onAfterUpdate(FragmentCollection fragmentCollection)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(fragmentCollection);
	}

	@Reference
	private StagingModelListener<FragmentCollection> _stagingModelListener;

}