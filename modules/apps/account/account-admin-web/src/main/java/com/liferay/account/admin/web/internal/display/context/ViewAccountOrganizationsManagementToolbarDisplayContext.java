/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.display.context;

import com.liferay.account.model.AccountEntry;
import com.liferay.account.service.AccountEntryLocalServiceUtil;
import com.liferay.account.service.AccountEntryOrganizationRelLocalServiceUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pei-Jung Lan
 */
public class ViewAccountOrganizationsManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public ViewAccountOrganizationsManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		SearchContainer searchContainer) {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			searchContainer);
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return DropdownItemList.of(
			() -> {
				DropdownItem dropdownItem = new DropdownItem();

				dropdownItem.putData("action", "removeOrganizations");

				PortletURL removeOrganizationsURL =
					liferayPortletResponse.createActionURL();

				removeOrganizationsURL.setParameter(
					ActionRequest.ACTION_NAME,
					"/account_admin/remove_account_organizations");
				removeOrganizationsURL.setParameter(
					"redirect", currentURLObj.toString());

				dropdownItem.putData(
					"removeOrganizationsURL",
					removeOrganizationsURL.toString());

				dropdownItem.setIcon("times-circle");
				dropdownItem.setLabel(LanguageUtil.get(request, "remove"));
				dropdownItem.setQuickAction(true);

				return dropdownItem;
			});
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	public CreationMenu getCreationMenu() {
		return CreationMenuBuilder.addPrimaryDropdownItem(
			dropdownItem -> {
				dropdownItem.putData("action", "selectAccountOrganizations");

				long accountEntryId = ParamUtil.getLong(
					request, "accountEntryId");

				AccountEntry accountEntry =
					AccountEntryLocalServiceUtil.fetchAccountEntry(
						accountEntryId);

				if (accountEntry != null) {
					dropdownItem.putData(
						"accountEntryName", accountEntry.getName());
				}

				PortletURL assignAccountOrganizationsURL =
					liferayPortletResponse.createActionURL();

				assignAccountOrganizationsURL.setParameter(
					ActionRequest.ACTION_NAME,
					"/account_admin/assign_account_organizations");
				assignAccountOrganizationsURL.setParameter(
					"redirect", currentURLObj.toString());

				dropdownItem.putData(
					"assignAccountOrganizationsURL",
					assignAccountOrganizationsURL.toString());

				PortletURL selectAccountOrganizationsURL =
					liferayPortletResponse.createRenderURL();

				selectAccountOrganizationsURL.setParameter(
					"mvcPath",
					"/account_entries_admin/select_account_organizations.jsp");
				selectAccountOrganizationsURL.setParameter(
					"accountEntryId", String.valueOf(accountEntryId));
				selectAccountOrganizationsURL.setWindowState(
					LiferayWindowState.POP_UP);

				dropdownItem.putData(
					"selectAccountOrganizationsURL",
					selectAccountOrganizationsURL.toString());

				dropdownItem.setLabel(
					LanguageUtil.get(request, "assign-organizations"));
			}
		).build();
	}

	@Override
	public String getDefaultEventHandler() {
		return "ACCOUNT_ORGANIZATIONS_MANAGEMENT_TOOLBAR_DEFAULT_EVENT_HANDLER";
	}

	@Override
	public String getSearchActionURL() {
		PortletURL searchActionURL = getPortletURL();

		return searchActionURL.toString();
	}

	@Override
	public Boolean isDisabled() {
		long accountEntryId = ParamUtil.getLong(
			liferayPortletRequest, "accountEntryId");

		long count =
			AccountEntryOrganizationRelLocalServiceUtil.
				getAccountEntryOrganizationRelsCount(accountEntryId);

		if (count > 0) {
			return false;
		}

		return true;
	}

	@Override
	protected String getOrderByCol() {
		return ParamUtil.getString(
			liferayPortletRequest, getOrderByColParam(), "name");
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {"name"};
	}

}