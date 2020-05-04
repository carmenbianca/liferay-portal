/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutFriendlyURLComposite;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eduardo García
 * @author Marco Leo
 */
@ProviderType
public interface FriendlyURLResolver {

	public String getActualURL(
			long companyId, long groupId, boolean privateLayout,
			String mainPath, String friendlyURL, Map<String, String[]> params,
			Map<String, Object> requestContext)
		throws PortalException;

	public LayoutFriendlyURLComposite getLayoutFriendlyURLComposite(
			long companyId, long groupId, boolean privateLayout,
			String friendlyURL, Map<String, String[]> params,
			Map<String, Object> requestContext)
		throws PortalException;

	public default LayoutFriendlyURLSeparatorComposite
			getLayoutFriendlyURLSeparatorComposite(
				long companyId, long groupId, boolean privateLayout,
				String friendlyURL, Map<String, String[]> params,
				Map<String, Object> requestContext)
		throws PortalException {

		LayoutFriendlyURLComposite layoutFriendlyURLComposite =
			getLayoutFriendlyURLComposite(
				companyId, groupId, privateLayout, friendlyURL, params,
				requestContext);

		return new LayoutFriendlyURLSeparatorComposite(
			layoutFriendlyURLComposite, getURLSeparator());
	}

	public String getURLSeparator();

}