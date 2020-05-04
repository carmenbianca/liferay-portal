/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.categories.internal.model.listener;

import com.liferay.asset.kernel.model.AssetCategory;
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
public class AssetCategoryStagingModelListener
	extends BaseModelListener<AssetCategory> {

	@Override
	public void onAfterCreate(AssetCategory assetCategory)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(assetCategory);
	}

	@Override
	public void onAfterRemove(AssetCategory assetCategory)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(assetCategory);
	}

	@Override
	public void onAfterUpdate(AssetCategory assetCategory)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(assetCategory);
	}

	@Reference
	private StagingModelListener<AssetCategory> _stagingModelListener;

}