/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.display.context;

import com.liferay.fragment.constants.FragmentActionKeys;
import com.liferay.fragment.web.internal.security.permission.resource.FragmentPermission;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class InheritedFragmentManagementToolbarDisplayContext
	extends FragmentManagementToolbarDisplayContext {

	public InheritedFragmentManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		FragmentDisplayContext fragmentDisplayContext) {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			fragmentDisplayContext.getFragmentEntriesSearchContainer(),
			fragmentDisplayContext);
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return DropdownItemListBuilder.add(
			dropdownItem -> {
				dropdownItem.putData(
					"action", "exportFragmentCompositionsAndFragmentEntries");
				dropdownItem.setIcon("import-export");
				dropdownItem.setLabel(LanguageUtil.get(request, "export"));
				dropdownItem.setQuickAction(true);
			}
		).add(
			() -> FragmentPermission.contains(
				themeDisplay.getPermissionChecker(),
				themeDisplay.getScopeGroupId(),
				FragmentActionKeys.MANAGE_FRAGMENT_ENTRIES),
			dropdownItem -> {
				dropdownItem.putData("action", "copyToSelectedFragmentEntries");
				dropdownItem.setIcon("paste");
				dropdownItem.setLabel(LanguageUtil.get(request, "copy-to"));
				dropdownItem.setQuickAction(true);
			}
		).build();
	}

	@Override
	public Map<String, Object> getComponentContext() throws Exception {
		return HashMapBuilder.<String, Object>put(
			"copyFragmentEntryURL",
			() -> {
				ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
					WebKeys.THEME_DISPLAY);

				PortletURL copyFragmentEntryURL =
					liferayPortletResponse.createActionURL();

				copyFragmentEntryURL.setParameter(
					ActionRequest.ACTION_NAME, "/fragment/copy_fragment_entry");
				copyFragmentEntryURL.setParameter(
					"redirect", themeDisplay.getURLCurrent());

				return copyFragmentEntryURL.toString();
			}
		).put(
			"exportFragmentEntriesURL",
			() -> {
				ResourceURL exportFragmentEntriesURL =
					liferayPortletResponse.createResourceURL();

				exportFragmentEntriesURL.setResourceID(
					"/fragment/export_fragment_compositions_and_fragment_" +
						"entries");

				return exportFragmentEntriesURL.toString();
			}
		).put(
			"fragmentCollectionId",
			ParamUtil.getLong(liferayPortletRequest, "fragmentCollectionId")
		).put(
			"selectFragmentCollectionURL",
			() -> {
				PortletURL selectFragmentCollectionURL =
					liferayPortletResponse.createActionURL();

				selectFragmentCollectionURL.setParameter(
					"mvcRenderCommandName",
					"/fragment/select_fragment_collection");
				selectFragmentCollectionURL.setWindowState(
					LiferayWindowState.POP_UP);

				return selectFragmentCollectionURL.toString();
			}
		).build();
	}

}