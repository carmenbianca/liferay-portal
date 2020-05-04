/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.configuration.icon.locator.internal;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.configuration.icon.locator.PortletConfigurationIconLocator;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(immediate = true, service = PortletConfigurationIconLocator.class)
public class StrutsPortletConfigurationIconLocator
	implements PortletConfigurationIconLocator {

	@Override
	public List<String> getDefaultViews(String portletId) {
		Portlet portlet = _portletLocalService.getPortletById(portletId);

		if (portlet == null) {
			return Collections.emptyList();
		}

		Map<String, String> initParams = portlet.getInitParams();

		String viewAction = initParams.get("view-action");

		if (Validator.isNotNull(viewAction)) {
			return Collections.singletonList(viewAction);
		}

		return Collections.emptyList();
	}

	@Override
	public String getPath(PortletRequest portletRequest) {
		return ParamUtil.getString(portletRequest, "struts_action");
	}

	@Reference(unbind = "-")
	protected void setPortletLocalService(
		PortletLocalService portletLocalService) {

		_portletLocalService = portletLocalService;
	}

	private PortletLocalService _portletLocalService;

}