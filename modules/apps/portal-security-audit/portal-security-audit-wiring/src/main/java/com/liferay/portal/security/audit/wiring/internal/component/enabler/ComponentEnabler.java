/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit.wiring.internal.component.enabler;

import com.liferay.osgi.util.ComponentUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.proxy.ProxyMessageListener;
import com.liferay.portal.security.audit.wiring.internal.AuditRouterProxyBeanConfigurator;
import com.liferay.portal.security.audit.wiring.internal.messaging.AuditMessagingConfigurator;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = {})
public class ComponentEnabler {

	@Activate
	protected void activate(ComponentContext componentContext) {
		ComponentUtil.enableComponents(
			ProxyMessageListener.class,
			"(destination.name=" + DestinationNames.AUDIT + ")",
			componentContext, AuditMessagingConfigurator.class,
			AuditRouterProxyBeanConfigurator.class);
	}

}