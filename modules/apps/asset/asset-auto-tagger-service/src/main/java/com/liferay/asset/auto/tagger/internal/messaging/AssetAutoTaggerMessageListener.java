/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.internal.messaging;

import com.liferay.asset.auto.tagger.AssetAutoTagger;
import com.liferay.asset.auto.tagger.internal.constants.AssetAutoTaggerDestinationNames;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = "destination.name=" + AssetAutoTaggerDestinationNames.ASSET_AUTO_TAGGER,
	service = MessageListener.class
)
public class AssetAutoTaggerMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		AssetEntry assetEntry = (AssetEntry)message.getPayload();

		_assetAutoTagger.tag(assetEntry);
	}

	@Reference
	private AssetAutoTagger _assetAutoTagger;

}