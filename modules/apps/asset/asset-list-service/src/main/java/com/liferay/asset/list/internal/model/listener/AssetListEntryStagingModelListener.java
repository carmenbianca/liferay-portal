/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.internal.model.listener;

import com.liferay.asset.list.model.AssetListEntry;
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
public class AssetListEntryStagingModelListener
	extends BaseModelListener<AssetListEntry> {

	@Override
	public void onAfterCreate(AssetListEntry assetListEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(assetListEntry);
	}

	@Override
	public void onAfterRemove(AssetListEntry assetListEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(assetListEntry);
	}

	@Override
	public void onAfterUpdate(AssetListEntry assetListEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(assetListEntry);
	}

	@Reference
	private StagingModelListener<AssetListEntry> _stagingModelListener;

}