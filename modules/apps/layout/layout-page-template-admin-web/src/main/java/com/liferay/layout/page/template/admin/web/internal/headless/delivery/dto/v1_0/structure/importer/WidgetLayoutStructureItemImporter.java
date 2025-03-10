/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.page.template.admin.web.internal.headless.delivery.dto.v1_0.structure.importer;

import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.fragment.processor.FragmentEntryProcessorRegistry;
import com.liferay.fragment.service.FragmentEntryLinkLocalService;
import com.liferay.headless.delivery.dto.v1_0.PageElement;
import com.liferay.layout.page.template.admin.web.internal.headless.delivery.dto.v1_0.structure.importer.util.PortletConfigurationImporterHelper;
import com.liferay.layout.page.template.admin.web.internal.headless.delivery.dto.v1_0.structure.importer.util.PortletPermissionsImporterHelper;
import com.liferay.layout.util.structure.LayoutStructure;
import com.liferay.layout.util.structure.LayoutStructureItem;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortletIdException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.PortletIdCodec;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.service.PortletPreferencesLocalService;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(service = LayoutStructureItemImporter.class)
public class WidgetLayoutStructureItemImporter
	extends BaseLayoutStructureItemImporter
	implements LayoutStructureItemImporter {

	@Override
	public LayoutStructureItem addLayoutStructureItem(
			Layout layout, LayoutStructure layoutStructure,
			PageElement pageElement, String parentItemId, int position)
		throws Exception {

		FragmentEntryLink fragmentEntryLink = _addFragmentEntryLink(
			layout, pageElement);

		if (fragmentEntryLink == null) {
			return null;
		}

		return layoutStructure.addFragmentLayoutStructureItem(
			fragmentEntryLink.getFragmentEntryLinkId(), parentItemId, position);
	}

	@Override
	public PageElement.Type getPageElementType() {
		return PageElement.Type.WIDGET;
	}

	private FragmentEntryLink _addFragmentEntryLink(
			Layout layout, PageElement pageElement)
		throws Exception {

		Map<String, Object> definitionMap = getDefinitionMap(
			pageElement.getDefinition());

		if (definitionMap == null) {
			return null;
		}

		Map<String, Object> widgetInstance =
			(Map<String, Object>)definitionMap.get("widgetInstance");

		if (widgetInstance == null) {
			return null;
		}

		String widgetName = (String)widgetInstance.get("widgetName");

		if (Validator.isNull(widgetName)) {
			return null;
		}

		String widgetInstanceId = (String)widgetInstance.get(
			"widgetInstanceId");

		JSONObject editableValueJSONObject =
			_fragmentEntryProcessorRegistry.getDefaultEditableValuesJSONObject(
				StringPool.BLANK, StringPool.BLANK);

		if (Validator.isNull(widgetInstanceId)) {
			widgetInstanceId = StringUtil.randomId();
		}

		widgetInstanceId = _getPortletInstanceId(
			layout, widgetInstanceId, widgetName);

		editableValueJSONObject.put(
			"instanceId", widgetInstanceId
		).put(
			"portletId", widgetName
		);

		Map<String, Object> widgetConfigDefinitionMap =
			(Map<String, Object>)widgetInstance.get("widgetConfig");

		_portletConfigurationImporterHelper.importPortletConfiguration(
			layout.getPlid(),
			PortletIdCodec.encode(widgetName, widgetInstanceId),
			widgetConfigDefinitionMap);

		List<Map<String, Object>> widgetPermissionsMaps =
			(List<Map<String, Object>>)widgetInstance.get("widgetPermissions");

		_portletPermissionsImporterHelper.importPortletPermissions(
			layout.getPlid(),
			PortletIdCodec.encode(widgetName, widgetInstanceId),
			widgetPermissionsMaps);

		return _fragmentEntryLinkLocalService.addFragmentEntryLink(
			layout.getUserId(), layout.getGroupId(), 0, 0, 0,
			_portal.getClassNameId(Layout.class), layout.getPlid(),
			StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
			StringPool.BLANK, editableValueJSONObject.toString(),
			widgetInstanceId, 0, null,
			ServiceContextThreadLocal.getServiceContext());
	}

	private String _getPortletInstanceId(
			Layout layout, String portletInstanceId, String portletId)
		throws PortletIdException {

		Portlet portlet = _portletLocalService.fetchPortletById(
			layout.getCompanyId(), portletId);

		if (portlet == null) {
			throw new PortletIdException();
		}

		if (portlet.isInstanceable()) {
			return portletInstanceId;
		}

		long count = _portletPreferencesLocalService.getPortletPreferencesCount(
			PortletKeys.PREFS_OWNER_TYPE_LAYOUT, layout.getPlid(), portletId);

		if (count > 0) {
			throw new PortletIdException(
				"Unable to add uninstanceable portlet more than once");
		}

		return StringPool.BLANK;
	}

	@Reference
	private FragmentEntryLinkLocalService _fragmentEntryLinkLocalService;

	@Reference
	private FragmentEntryProcessorRegistry _fragmentEntryProcessorRegistry;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private PortletConfigurationImporterHelper
		_portletConfigurationImporterHelper;

	@Reference
	private PortletLocalService _portletLocalService;

	@Reference
	private PortletPermissionsImporterHelper _portletPermissionsImporterHelper;

	@Reference
	private PortletPreferencesLocalService _portletPreferencesLocalService;

}