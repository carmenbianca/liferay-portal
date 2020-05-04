/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.display.context;

import com.liferay.document.library.web.internal.display.context.util.DLRequestHelper;
import com.liferay.document.library.web.internal.security.permission.resource.DDMStructurePermission;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Cristina González
 */
public class DLViewFileEntryMetadataSetsManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public DLViewFileEntryMetadataSetsManagementToolbarDisplayContext(
			HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			DLViewFileEntryMetadataSetsDisplayContext
				dlViewFileEntryMetadataSetsDisplayContext)
		throws Exception {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			dlViewFileEntryMetadataSetsDisplayContext.getStructureSearch());

		_dlRequestHelper = new DLRequestHelper(httpServletRequest);
		_dlViewFileEntryMetadataSetsDisplayContext =
			dlViewFileEntryMetadataSetsDisplayContext;
	}

	@Override
	public String getClearResultsURL() {
		PortletURL portletURL = getPortletURL();

		portletURL.setParameter("keywords", StringPool.BLANK);

		return portletURL.toString();
	}

	@Override
	public CreationMenu getCreationMenu() {
		return CreationMenuBuilder.addPrimaryDropdownItem(
			dropdownItem -> {
				ThemeDisplay themeDisplay =
					(ThemeDisplay)liferayPortletRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

				dropdownItem.setHref(
					liferayPortletResponse.createRenderURL(),
					"mvcRenderCommandName",
					"/document_library/ddm/edit_ddm_structure", "redirect",
					themeDisplay.getURLCurrent(), "groupId",
					String.valueOf(_dlRequestHelper.getScopeGroupId()));

				dropdownItem.setLabel(
					LanguageUtil.get(_dlRequestHelper.getRequest(), "add"));
			}
		).build();
	}

	@Override
	public String getSearchActionURL() {
		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/view.jsp");
		portletURL.setParameter(
			"tabs1",
			ParamUtil.getString(liferayPortletRequest, "tabs1", "structures"));
		portletURL.setParameter(
			"groupId", String.valueOf(_dlRequestHelper.getScopeGroupId()));

		return portletURL.toString();
	}

	@Override
	public Boolean isSelectable() {
		return false;
	}

	@Override
	public Boolean isShowCreationMenu() {
		try {
			return _isShowAddButton();
		}
		catch (PortalException portalException) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to get creation menu", portalException);
			}

			return false;
		}
	}

	@Override
	protected String[] getNavigationKeys() {
		return new String[] {"all"};
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {"modified-date", "id"};
	}

	private boolean _isShowAddButton() throws PortalException {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		Group group = themeDisplay.getScopeGroup();

		if ((!group.hasLocalOrRemoteStagingGroup() || group.isStagingGroup()) &&
			DDMStructurePermission.containsAddDDMStructurePermission(
				_dlRequestHelper.getPermissionChecker(),
				_dlRequestHelper.getScopeGroupId(),
				_dlViewFileEntryMetadataSetsDisplayContext.
					getStructureClassNameId())) {

			return true;
		}

		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DLViewFileEntryMetadataSetsManagementToolbarDisplayContext.class);

	private final DLRequestHelper _dlRequestHelper;
	private final DLViewFileEntryMetadataSetsDisplayContext
		_dlViewFileEntryMetadataSetsDisplayContext;

}