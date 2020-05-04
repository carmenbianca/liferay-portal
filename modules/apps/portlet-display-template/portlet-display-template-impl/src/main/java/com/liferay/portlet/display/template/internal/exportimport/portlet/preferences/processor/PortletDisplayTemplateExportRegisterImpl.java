/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.display.template.internal.exportimport.portlet.preferences.processor;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.display.template.constants.PortletDisplayTemplateConstants;
import com.liferay.portlet.display.template.exportimport.portlet.preferences.processor.PortletDisplayTemplateRegister;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lance Ji
 */
@Component(
	immediate = true,
	property = {
		"name=PortletDisplayTemplateExporter",
		"type=" + PortletDisplayTemplateConstants.DISPLAY_TEMPLATE_EXPORT
	},
	service = PortletDisplayTemplateRegister.class
)
public class PortletDisplayTemplateExportRegisterImpl
	implements PortletDisplayTemplateRegister {

	@Override
	public String getDisplayStyle(
		PortletDataContext portletDataContext, String portletId,
		PortletPreferences portletPreferences) {

		try {
			Portlet portlet = _portletLocalService.getPortletById(
				portletDataContext.getCompanyId(), portletId);

			if (Validator.isNotNull(portlet.getTemplateHandlerInstance())) {
				return portletPreferences.getValue("displayStyle", null);
			}
		}
		catch (Exception exception) {
		}

		return null;
	}

	@Override
	public long getDisplayStyleGroupId(
		PortletDataContext portletDataContext, String portletId,
		PortletPreferences portletPreferences) {

		try {
			Portlet portlet = _portletLocalService.getPortletById(
				portletDataContext.getCompanyId(), portletId);

			if (Validator.isNotNull(portlet.getTemplateHandlerInstance())) {
				return GetterUtil.getLong(
					portletPreferences.getValue("displayStyleGroupId", null));
			}
		}
		catch (Exception exception) {
		}

		return 0;
	}

	@Reference(unbind = "-")
	private PortletLocalService _portletLocalService;

}