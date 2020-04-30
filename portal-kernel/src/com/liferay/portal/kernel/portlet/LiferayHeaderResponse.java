/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import javax.portlet.HeaderResponse;
import javax.portlet.MimeResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Neil Griffin
 */
@ProviderType
public interface LiferayHeaderResponse
	extends HeaderResponse, LiferayPortletResponse, MimeResponse {

	public void writeToHead();

}