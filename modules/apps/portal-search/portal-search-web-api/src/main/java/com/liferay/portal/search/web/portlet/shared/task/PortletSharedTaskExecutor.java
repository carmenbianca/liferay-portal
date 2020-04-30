/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.portlet.shared.task;

import javax.portlet.RenderRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface PortletSharedTaskExecutor {

	public <T> T executeOnlyOnce(
		PortletSharedTask<T> portletSharedTask, String attributeSuffix,
		RenderRequest renderRequest);

}