/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.internal.manager.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.workflow.kaleo.runtime.constants.KaleoRuntimeDestinationNames;
import com.liferay.portal.workflow.kaleo.runtime.manager.PortalKaleoManager;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "destination.name=" + KaleoRuntimeDestinationNames.WORKFLOW_DEFINITION_LINK,
	service = MessageListener.class
)
public class KaleoAssetDeploymentMessageListener extends BaseMessageListener {

	public void setPortalKaleoManager(PortalKaleoManager portalKaleoManager) {
		_portalKaleoManager = portalKaleoManager;
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String assetClassName = (String)message.get("ASSET_CLASS_NAME");

		_portalKaleoManager.deployDefaultDefinitionLink(assetClassName);
	}

	@Reference
	private PortalKaleoManager _portalKaleoManager;

}