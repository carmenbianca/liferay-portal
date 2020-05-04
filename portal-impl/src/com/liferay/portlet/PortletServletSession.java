/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.servlet.HttpSessionWrapper;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletServletSession extends HttpSessionWrapper {

	public PortletServletSession(
		HttpSession session, LiferayPortletRequest liferayPortletRequest) {

		super(session);

		_liferayPortletRequestReference = new WeakReference<>(
			liferayPortletRequest);
	}

	@Override
	public void invalidate() {
		super.invalidate();

		LiferayPortletRequest liferayPortletRequest =
			_liferayPortletRequestReference.get();

		if (liferayPortletRequest != null) {
			liferayPortletRequest.invalidateSession();
		}
	}

	private final Reference<LiferayPortletRequest>
		_liferayPortletRequestReference;

}