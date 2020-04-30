/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class JournalArticleItemSelectorViewManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public JournalArticleItemSelectorViewManagementToolbarDisplayContext(
			HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			JournalArticleItemSelectorViewDisplayContext
				journalArticleItemSelectorViewDisplayContext)
		throws Exception {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			journalArticleItemSelectorViewDisplayContext.getSearchContainer());

		_journalArticleItemSelectorViewDisplayContext =
			journalArticleItemSelectorViewDisplayContext;

		_themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	@Override
	public String getSearchActionURL() {
		PortletURL searchActionURL = getPortletURL();

		return searchActionURL.toString();
	}

	@Override
	public String getSortingOrder() {
		if (Objects.equals(getOrderByCol(), "relevance")) {
			return null;
		}

		return super.getSortingOrder();
	}

	@Override
	public Boolean isSelectable() {
		return false;
	}

	@Override
	protected String getDefaultDisplayStyle() {
		return "descriptive";
	}

	@Override
	protected String[] getDisplayViews() {
		return new String[] {"list", "descriptive", "icon"};
	}

	@Override
	protected List<DropdownItem> getDropdownItems(
		Map<String, String> entriesMap, PortletURL entryURL,
		String parameterName, String parameterValue) {

		if ((entriesMap == null) || entriesMap.isEmpty()) {
			return null;
		}

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", _themeDisplay.getLocale(), getClass());

		return new DropdownItemList() {
			{
				for (Map.Entry<String, String> entry : entriesMap.entrySet()) {
					add(
						dropdownItem -> {
							if (parameterValue != null) {
								dropdownItem.setActive(
									parameterValue.equals(entry.getValue()));
							}

							dropdownItem.setHref(
								entryURL, parameterName, entry.getValue());
							dropdownItem.setLabel(
								LanguageUtil.get(
									resourceBundle, entry.getKey()));
						});
				}
			}
		};
	}

	@Override
	protected String[] getOrderByKeys() {
		String[] orderColumns = {"modified-date", "title"};

		if (_journalArticleItemSelectorViewDisplayContext.isSearch()) {
			orderColumns = ArrayUtil.append(orderColumns, "relevance");
		}

		if (_journalArticleItemSelectorViewDisplayContext.showArticleId()) {
			orderColumns = ArrayUtil.append(orderColumns, "id");
		}

		return orderColumns;
	}

	private final JournalArticleItemSelectorViewDisplayContext
		_journalArticleItemSelectorViewDisplayContext;
	private final ThemeDisplay _themeDisplay;

}