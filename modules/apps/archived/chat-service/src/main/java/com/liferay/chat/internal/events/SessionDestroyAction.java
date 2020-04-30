/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.internal.events;

import com.liferay.chat.internal.jabber.JabberUtil;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bruno Farache
 */
@Component(
	enabled = false, immediate = true,
	property = "key=servlet.session.destroy.events",
	service = LifecycleAction.class
)
public class SessionDestroyAction extends SessionAction {

	@Override
	public void run(HttpSession session) {
		Long userId = (Long)session.getAttribute(WebKeys.USER_ID);

		JabberUtil.disconnect(userId);
	}

}