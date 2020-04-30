/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lar;

import com.liferay.portal.kernel.model.StagedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface PortletDataHandlerStatusMessageSender {

	public void sendStatusMessage(
		String messageType, String portletId, ManifestSummary manifestSummary);

	public void sendStatusMessage(
		String messageType, String[] portletIds,
		ManifestSummary manifestSummary);

	public <T extends StagedModel> void sendStatusMessage(
		String messageType, T stagedModel, ManifestSummary manifestSummary);

}