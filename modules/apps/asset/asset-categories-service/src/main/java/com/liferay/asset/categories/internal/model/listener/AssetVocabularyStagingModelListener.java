/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.categories.internal.model.listener;

import com.liferay.asset.kernel.model.AssetVocabulary;
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
public class AssetVocabularyStagingModelListener
	extends BaseModelListener<AssetVocabulary> {

	@Override
	public void onAfterCreate(AssetVocabulary assetVocabulary)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(assetVocabulary);
	}

	@Override
	public void onAfterRemove(AssetVocabulary assetVocabulary)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(assetVocabulary);
	}

	@Override
	public void onAfterUpdate(AssetVocabulary assetVocabulary)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(assetVocabulary);
	}

	@Reference
	private StagingModelListener<AssetVocabulary> _stagingModelListener;

}