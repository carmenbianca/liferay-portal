/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.web.internal.util;

import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portlet.display.template.PortletDisplayTemplate;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lance Ji
 */
@Component(immediate = true, service = {})
public class PortletDisplayTemplateUtil {

	public static List<TemplateHandler> getPortletDisplayTemplateHandlers() {
		return _portletDisplayTemplate.getPortletDisplayTemplateHandlers();
	}

	@Deactivate
	protected void deactivate() {
		_portletDisplayTemplate = null;
	}

	@Reference(unbind = "-")
	protected void setPortletDisplayTemplate(
		PortletDisplayTemplate portletDisplayTemplate) {

		_portletDisplayTemplate = portletDisplayTemplate;
	}

	private static PortletDisplayTemplate _portletDisplayTemplate;

}