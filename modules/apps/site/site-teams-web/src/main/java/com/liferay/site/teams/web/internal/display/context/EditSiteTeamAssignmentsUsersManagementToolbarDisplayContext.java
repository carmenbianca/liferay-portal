/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.teams.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class EditSiteTeamAssignmentsUsersManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public EditSiteTeamAssignmentsUsersManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		EditSiteTeamAssignmentsUsersDisplayContext
			editSiteTeamAssignmentsUsersDisplayContext) {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			editSiteTeamAssignmentsUsersDisplayContext.
				getUserSearchContainer());

		_editSiteTeamAssignmentsUsersDisplayContext =
			editSiteTeamAssignmentsUsersDisplayContext;
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return DropdownItemListBuilder.add(
			dropdownItem -> {
				dropdownItem.putData("action", "deleteUsers");
				dropdownItem.setIcon("times-circle");
				dropdownItem.setLabel(LanguageUtil.get(request, "delete"));
				dropdownItem.setQuickAction(true);
			}
		).build();
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	@Override
	public String getComponentId() {
		return "editTeamAssignemntsUsersWebManagementToolbar";
	}

	@Override
	public CreationMenu getCreationMenu() {
		try {
			return CreationMenuBuilder.addDropdownItem(
				dropdownItem -> {
					dropdownItem.putData("action", "selectUser");

					ThemeDisplay themeDisplay =
						(ThemeDisplay)request.getAttribute(
							WebKeys.THEME_DISPLAY);

					PortletURL selectUserURL =
						liferayPortletResponse.createRenderURL();

					selectUserURL.setParameter("mvcPath", "/select_users.jsp");
					selectUserURL.setParameter(
						"redirect", themeDisplay.getURLCurrent());
					selectUserURL.setParameter(
						"teamId",
						String.valueOf(
							_editSiteTeamAssignmentsUsersDisplayContext.
								getTeamId()));
					selectUserURL.setWindowState(LiferayWindowState.POP_UP);

					dropdownItem.putData(
						"selectUserURL", selectUserURL.toString());

					String title = LanguageUtil.format(
						request, "add-new-user-to-x",
						_editSiteTeamAssignmentsUsersDisplayContext.
							getTeamName());

					dropdownItem.putData("title", title);

					dropdownItem.setLabel(LanguageUtil.get(request, "add"));
				}
			).build();
		}
		catch (Exception exception) {
			return null;
		}
	}

	@Override
	public String getDefaultEventHandler() {
		return "editTeamAssignmentsUsersManagementToolbarDefaultEventHandler";
	}

	@Override
	public String getSearchActionURL() {
		PortletURL searchActionURL = getPortletURL();

		return searchActionURL.toString();
	}

	@Override
	public String getSearchContainerId() {
		return "users";
	}

	@Override
	public Boolean isShowCreationMenu() {
		return true;
	}

	@Override
	protected String getDefaultDisplayStyle() {
		return "icon";
	}

	@Override
	protected String[] getDisplayViews() {
		return new String[] {"list", "descriptive", "icon"};
	}

	@Override
	protected String[] getNavigationKeys() {
		return new String[] {"all"};
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {"first-name", "screen-name"};
	}

	private final EditSiteTeamAssignmentsUsersDisplayContext
		_editSiteTeamAssignmentsUsersDisplayContext;

}