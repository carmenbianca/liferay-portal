/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lar;

import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Michael C. Han
 */
public class PortletDataHandlerStatusMessageSenderUtil {

	public static void sendStatusMessage(
		String messageType, String portletId, ManifestSummary manifestSummary) {

		_getPortletDataHandlerStatusMessageSender().sendStatusMessage(
			messageType, portletId, manifestSummary);
	}

	public static void sendStatusMessage(
		String messageType, String[] portletIds,
		ManifestSummary manifestSummary) {

		_getPortletDataHandlerStatusMessageSender().sendStatusMessage(
			messageType, portletIds, manifestSummary);
	}

	public static <T extends StagedModel> void sendStatusMessage(
		String messageType, T stagedModel, ManifestSummary manifestSummary) {

		_getPortletDataHandlerStatusMessageSender().sendStatusMessage(
			messageType, stagedModel, manifestSummary);
	}

	private static PortletDataHandlerStatusMessageSender
		_getPortletDataHandlerStatusMessageSender() {

		return _dataHandlerStatusMessageSender;
	}

	private static volatile PortletDataHandlerStatusMessageSender
		_dataHandlerStatusMessageSender =
			ServiceProxyFactory.newServiceTrackedInstance(
				PortletDataHandlerStatusMessageSender.class,
				PortletDataHandlerStatusMessageSenderUtil.class,
				"_dataHandlerStatusMessageSender", false);

}