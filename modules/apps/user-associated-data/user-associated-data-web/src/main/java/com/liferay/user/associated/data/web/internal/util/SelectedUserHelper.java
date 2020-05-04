/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Portal;

import java.util.Objects;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(immediate = true, service = SelectedUserHelper.class)
public class SelectedUserHelper {

	public User getSelectedUser(PortletRequest portletRequest)
		throws PortalException {

		User selectedUser = portal.getSelectedUser(portletRequest);

		if (Objects.equals(portal.getUser(portletRequest), selectedUser)) {
			throw new PortalException(
				"The selected user cannot be the logged in user");
		}

		if (uadAnonymizerHelper.isAnonymousUser(selectedUser)) {
			throw new PortalException(
				"The selected user cannot be the anonymous user");
		}

		return selectedUser;
	}

	public long getSelectedUserId(PortletRequest portletRequest)
		throws PortalException {

		User selectedUser = getSelectedUser(portletRequest);

		return selectedUser.getUserId();
	}

	@Reference
	protected Portal portal;

	@Reference
	protected UADAnonymizerHelper uadAnonymizerHelper;

}