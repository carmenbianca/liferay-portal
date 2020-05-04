/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.display.template.internal.exportimport.portlet.preferences.processor;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.portlet.preferences.processor.Capability;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.display.template.PortletDisplayTemplate;
import com.liferay.portlet.display.template.exportimport.portlet.preferences.processor.PortletDisplayTemplateRegister;

import java.util.Map;

import javax.portlet.PortletPreferences;

/**
 * @author Máté Thurzó
 */
public class PortletDisplayTemplateImportCapability implements Capability {

	public PortletDisplayTemplateImportCapability(
		Portal portal, PortletLocalService portletLocalService,
		PortletDisplayTemplate portletDisplayTemplate,
		PortletDisplayTemplateRegister portletDisplayTemplateImportRegister) {

		_portal = portal;
		_portletLocalService = portletLocalService;
		_portletDisplayTemplate = portletDisplayTemplate;
		_portletDisplayTemplateImportRegister =
			portletDisplayTemplateImportRegister;
	}

	@Override
	public PortletPreferences process(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences)
		throws PortletDataException {

		try {
			return importDisplayStyle(
				portletDataContext, portletDataContext.getPortletId(),
				portletPreferences);
		}
		catch (Exception exception) {
			return portletPreferences;
		}
	}

	protected long getClassNameId(
		PortletDataContext portletDataContext, String portletId) {

		Portlet portlet = _portletLocalService.getPortletById(
			portletDataContext.getCompanyId(), portletId);

		TemplateHandler templateHandler = portlet.getTemplateHandlerInstance();

		if (templateHandler == null) {
			return 0;
		}

		return _portal.getClassNameId(templateHandler.getClassName());
	}

	protected PortletPreferences importDisplayStyle(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		PortletPreferences processedPreferences = portletPreferences;

		String displayStyle =
			_portletDisplayTemplateImportRegister.getDisplayStyle(
				portletDataContext, portletId, portletPreferences);

		if (Validator.isNull(displayStyle) ||
			!displayStyle.startsWith(
				PortletDisplayTemplateManager.DISPLAY_STYLE_PREFIX)) {

			return processedPreferences;
		}

		StagedModelDataHandlerUtil.importReferenceStagedModels(
			portletDataContext, DDMTemplate.class);

		long displayStyleGroupId =
			_portletDisplayTemplateImportRegister.getDisplayStyleGroupId(
				portletDataContext, portletId, portletPreferences);

		Map<Long, Long> groupIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				Group.class);

		long groupId = MapUtil.getLong(
			groupIds, displayStyleGroupId, displayStyleGroupId);

		DDMTemplate ddmTemplate =
			_portletDisplayTemplate.getPortletDisplayTemplateDDMTemplate(
				groupId, getClassNameId(portletDataContext, portletId),
				displayStyle, false);

		if (ddmTemplate != null) {
			portletPreferences.setValue(
				"displayStyleGroupId",
				String.valueOf(ddmTemplate.getGroupId()));
		}
		else {
			portletPreferences.setValue(
				"displayStyleGroupId", StringPool.BLANK);
		}

		return processedPreferences;
	}

	private final Portal _portal;
	private final PortletDisplayTemplate _portletDisplayTemplate;
	private final PortletDisplayTemplateRegister
		_portletDisplayTemplateImportRegister;
	private final PortletLocalService _portletLocalService;

}