/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.taglib.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.item.selector.taglib.servlet.taglib.RepositoryEntryBrowserTag;
import com.liferay.item.selector.taglib.servlet.taglib.util.RepositoryEntryBrowserTagUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alejandro Tardín
 */
public class ItemSelectorRepositoryEntryManagementToolbarDisplayContext {

	public ItemSelectorRepositoryEntryManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		_httpServletRequest = httpServletRequest;

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;

		_currentURLObj = PortletURLUtil.getCurrent(
			_liferayPortletRequest, _liferayPortletResponse);

		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
			liferayPortletRequest);
	}

	public List<DropdownItem> getFilterDropdownItems() {
		return DropdownItemListBuilder.addGroup(
			dropdownGroupItem -> {
				dropdownGroupItem.setDropdownItems(_getOrderByDropdownItems());
				dropdownGroupItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "order-by"));
			}
		).build();
	}

	public String getOrderByType() {
		if (_orderByType != null) {
			return _orderByType;
		}

		_orderByType = RepositoryEntryBrowserTagUtil.getOrderByType(
			_httpServletRequest, _portalPreferences);

		return _orderByType;
	}

	public PortletURL getSearchURL() throws PortletException {
		PortletURL searchURL = PortletURLUtil.clone(
			_currentURLObj, _liferayPortletResponse);

		searchURL.setParameter("keywords", (String)null);
		searchURL.setParameter("resetCur", Boolean.TRUE.toString());

		return searchURL;
	}

	public PortletURL getSortingURL() throws PortletException {
		PortletURL sortingURL = _getCurrentSortingURL();

		sortingURL.setParameter(
			"orderByType",
			Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

		return sortingURL;
	}

	public ViewTypeItemList getViewTypes() throws PortletException {
		PortletURL displayStyleURL = PortletURLUtil.clone(
			_getPortletURL(), _liferayPortletResponse);

		return new ViewTypeItemList(displayStyleURL, _getDisplayStyle()) {
			{
				if (ArrayUtil.contains(_getDisplayStyles(), "icon")) {
					addCardViewTypeItem();
				}

				if (ArrayUtil.contains(_getDisplayStyles(), "descriptive")) {
					addListViewTypeItem();
				}

				if (ArrayUtil.contains(_getDisplayStyles(), "list")) {
					addTableViewTypeItem();
				}
			}
		};
	}

	public boolean isDisabled() {
		return false;
	}

	private PortletURL _getCurrentSortingURL() throws PortletException {
		PortletURL currentSortingURL = PortletURLUtil.clone(
			_getPortletURL(), _liferayPortletResponse);

		currentSortingURL.setParameter("orderByType", getOrderByType());
		currentSortingURL.setParameter("orderByCol", _getOrderByCol());

		return currentSortingURL;
	}

	private String _getDisplayStyle() {
		return GetterUtil.getString(
			_httpServletRequest.getAttribute(
				"liferay-item-selector:repository-entry-browser:displayStyle"));
	}

	private String[] _getDisplayStyles() {
		return RepositoryEntryBrowserTag.DISPLAY_STYLES;
	}

	private String _getOrderByCol() {
		if (_orderByCol != null) {
			return _orderByCol;
		}

		_orderByCol = RepositoryEntryBrowserTagUtil.getOrderByCol(
			_httpServletRequest, _portalPreferences);

		return _orderByCol;
	}

	private List<DropdownItem> _getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				Map<String, String> orderColumnsMap = HashMapBuilder.put(
					"modifiedDate", "modified-date"
				).put(
					"size", "size"
				).put(
					"title", "title"
				).build();

				for (Map.Entry<String, String> orderByColEntry :
						orderColumnsMap.entrySet()) {

					add(
						dropdownItem -> {
							String orderByCol = orderByColEntry.getKey();

							dropdownItem.setActive(
								orderByCol.equals(_getOrderByCol()));
							dropdownItem.setHref(
								_getCurrentSortingURL(), "orderByCol",
								orderByCol);

							dropdownItem.setLabel(
								LanguageUtil.get(
									_httpServletRequest,
									orderByColEntry.getValue()));
						});
				}
			}
		};
	}

	private PortletURL _getPortletURL() {
		return (PortletURL)_httpServletRequest.getAttribute(
			"liferay-item-selector:repository-entry-browser:portletURL");
	}

	private final PortletURL _currentURLObj;
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private String _orderByCol;
	private String _orderByType;
	private final PortalPreferences _portalPreferences;

}