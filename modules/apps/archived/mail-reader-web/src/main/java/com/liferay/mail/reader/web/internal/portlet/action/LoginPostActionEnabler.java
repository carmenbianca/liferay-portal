/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.web.internal.portlet.action;

import com.liferay.osgi.util.ComponentUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageListener;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Shuyang Zhou
 */
@Component(immediate = true, service = {})
public class LoginPostActionEnabler {

	@Activate
	protected void activate(ComponentContext componentContext) {
		ComponentUtil.enableComponents(
			MessageListener.class,
			"(destination.name=" + DestinationNames.MAIL_SYNCHRONIZER + ")",
			componentContext, LoginPostAction.class);
	}

	@Deactivate
	protected void deactivate(ComponentContext componentContext) {
		componentContext.disableComponent(LoginPostAction.class.getName());
	}

}