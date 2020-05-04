/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.staging.portlet.data.handler.internal;

import com.liferay.exportimport.kernel.lar.DefaultConfigurationPortletDataHandler;
import com.liferay.exportimport.kernel.lar.PortletDataHandler;

import org.osgi.service.component.annotations.Component;

/**
 * @author Raymond Augé
 */
@Component(
	property = {"javax.portlet.name=ALL", "service.ranking:Integer=-1"},
	service = PortletDataHandler.class
)
public class DefaultPortletDataHandler
	extends DefaultConfigurationPortletDataHandler {
}