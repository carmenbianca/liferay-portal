/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.portlet.data.handler.helper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Máté Thurzó
 */
@ProviderType
public interface PortletDataHandlerHelper {

	public boolean validateSchemaVersion(
		String schemaVersion, String portletSchemaVersion);

}