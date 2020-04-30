/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.user.action.contributor;

import com.liferay.portal.kernel.model.User;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Drew Brokke
 */
@ProviderType
public interface UserActionContributor {

	public String getConfirmationMessage(PortletRequest portletRequest);

	public String getMessage(PortletRequest portletRequest);

	public String getURL(
		PortletRequest portletRequest, PortletResponse portletResponse,
		User user, User selUser);

	public boolean isShow(
		PortletRequest portletRequest, User user, User selUser);

	public boolean isShowConfirmationMessage(User selUser);

}